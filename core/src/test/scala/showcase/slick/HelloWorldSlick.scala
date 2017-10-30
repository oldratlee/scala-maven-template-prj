package showcase.slick

// Use H2Profile to connect to an H2 database
import slick.jdbc.H2Profile.api._

import scala.collection.mutable.ArrayBuffer
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

/**
  * Example source:
  * - http://slick.lightbend.com/doc/3.2.1/gettingstarted.html
  * - https://github.com/slick/slick/blob/v3.2.1/doc/code/FirstExample.scala
  */
object HelloWorldSlick {

  // Definition of the SUPPLIERS table
  class Suppliers(tag: Tag) extends Table[(Int, String, String, String, String, String)](tag, "SUPPLIERS") {
    def id = column[Int]("SUP_ID", O.PrimaryKey, O.AutoInc) // This is the primary key column

    def name = column[String]("SUP_NAME")

    def street = column[String]("STREET")

    def city = column[String]("CITY")

    def state = column[String]("STATE")

    def zip = column[String]("ZIP")

    // Every table needs a * projection with the same type as the table's type parameter
    def * = (id, name, street, city, state, zip)
  }

  def main(args: Array[String]): Unit = {
    val suppliers = TableQuery[Suppliers]

    // Connect to the database and execute the following block within a session
    val db = Database.forConfig("h2mem1")
    try {
      val setup = DBIO.seq(
        // Create the tables
        suppliers.schema.create,

        // Insert some suppliers
        suppliers += (0, "Acme, Inc.", "99 Market Street", "Groundsville", "CA", "95199"),
        suppliers += (0, "Superior Coffee", "1 Party Place", "Mendocino", "CA", "95460"),
        suppliers += (0, "The High Ground", "100 Coffee Lane", "Meadows", "CA", "93966"),
        // Equivalent SQL code:
        // insert into SUPPLIERS(SUP_ID, SUP_NAME, STREET, CITY, STATE, ZIP) values (?,?,?,?,?,?)
      )

      val setupFuture = db.run(setup)

      val resultFuture = setupFuture.flatMap { _ =>

        // Read all suppliers and print them to the console
        println("Coffees:")
        db.run(suppliers.result).map(_.foreach {
          case (id, name, street, city, state, zip) =>
            println("  " + id + "\t" + name + "\t" + street + "\t" + city + "\t" + state + "\t" + zip)
        })
        // Equivalent SQL code:
        // select SUP_ID, SUP_NAME, STREET, CITY, STATE, ZIP from SUPPLIERS

      }.flatMap { _ =>

        // Why not let the database do the string conversion and concatenation?
        println("Coffees (concatenated by DB):")
        val q1 = for (s <- suppliers)
          yield LiteralColumn("  ") ++
            s.id.asColumnOf[String] ++ "\t" ++ s.name ++ "\t" ++
            s.street ++ "\t" ++ s.city ++ "\t" ++ s.state ++ "\t" ++ s.zip
        // The first string constant needs to be lifted manually to a LiteralColumn
        // so that the proper ++ operator is found
        //
        // Equivalent SQL code:
        // select '  ' || SUP_ID || '\t' || SUP_NAME ||
        //    '\t' || STREET || '\t' || CITY || '\t' || STATE || '\t' || ZIP
        //    from SUPPLIERS

        db.stream(q1.result).foreach(println)

      }.flatMap { _ =>

        println("Conditional select:")
        val q2 = for {
          s <- suppliers
          if s.zip.startsWith("95")
          if s.name.like("%Inc%")
        } yield (s.id, s.name, s.zip)
        // Equivalent SQL code:
        // select SUP_ID, SUP_NAME, STREET, CITY, STATE, ZIP from SUPPLIERS
        //    where ZIP like '95%' and SUP_NAME like '%Inc%'

        db.run(q2.result).map(_.foreach(t =>
          println(s"  id: ${t._1}, name: ${t._2}, zip: ${t._3}")
        ))

      }

      Await.result(resultFuture, Duration.Inf)
      lines.foreach(Predef.println)

    } finally db.close
  }

  private val lines = new ArrayBuffer[Any]()

  private def println(s: Any) = lines += s
}

package showcase.testing.scalatest

import com.oldratlee.scala.hello.Person
import org.scalacheck.Prop.propBoolean
import org.scalacheck.{Gen, Prop, Properties}

object BasicScalaCheckProperties extends Properties("Hello") {
  // simple properties
  property("Sums is associative") = Prop.forAll {
    (x: Int, y: Int) => x + y == y + x
  }

  // create Option[String] instance randomly
  property("person name") = Prop.forAll {
    (name: String, lastName: Option[String], age: Int) => {
      val person = new Person(name, age, null)
      println(s"name: $name, lastName: $lastName, age: $age")
      name == person.name
    }
  }

  // constraining properties
  property("constraining person name") = Prop.forAll(Gen.alphaStr, Gen.oneOf(Gen.alphaStr.sample, None), Gen.chooseNum[Int](0, 99)) {
    (name: String, lastName: Option[String], age: Int) => {
      val person = new Person(name, age, null)
      println(s"name: $name, lastName: $lastName, age: $age")
      name == person.name
    }
  }

  // constraining properties
  property("age from 0 ~ 120") = Prop.forAll {
    (name: String, age: Int) => {
      // set constraint by ==>
      (age >= 0) ==> {
        val person = new Person(name, age, null)
        println(s"age: $age")
        name == person.name
      }
    }
  }

  // Grouping Properties
  val stringOnly = Prop.forAll(Gen.alphaStr) {
    x: String => (x != "") ==> { x.size >= 0 }
  }

  val positiveNumOnly = Prop.forAll(Gen.posNum[Int]) { _ > 0 }

  val alwaysPass = Prop.forAll { _: Int => true }

  property("And") = stringOnly && positiveNumOnly

  property("Or") = stringOnly && alwaysPass
}

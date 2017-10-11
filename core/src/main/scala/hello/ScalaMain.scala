package hello

import com.oldratlee.scala.hello.{Company, Employee, Pet}

/**
  * Hello world demo.
  *
  * Just a Scala rewrite for [[JavaMain]]
  *
  * @see [[JavaMain]]
  */
object ScalaMain {
  def main(args: Array[String]): Unit = {
    println("Hello World!")

    // Use Java class Company from Scala
    val employee = new Employee("jerry", 42, Pet("buddy"), new Company("abc.com", "Street 1"))
    println(employee)
  }
}

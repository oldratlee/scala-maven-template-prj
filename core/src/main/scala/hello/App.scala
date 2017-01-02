package hello

import com.oldratlee.scala.hello.{Company, Employee, Pet}

/**
  * Hello world!
  */
object App {
  def main(args: Array[String]) = {
    println("Hello World!")

    val employee = new Employee("jerry", 42, Pet("buddy"), new Company("abc.com", "Street 1"))
    println(employee)
  }
}

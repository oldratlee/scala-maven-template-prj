package com.oldratlee.scala.hello

class Person(val name: String,
             val age: Int
            ) {

  override def toString = s"Person($name, $age)"
}

class Employee(override val name: String,
               override val age: Int,
               val company: Company)
  extends Person(name, age) {

  override def toString = s"Employee($name, $age, $company)"
}

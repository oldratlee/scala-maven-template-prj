package com.oldratlee.scala.hello

case class Pet(name: String)

class Person(val name: String,
             val age: Int,
             val pet: Pet
            ) {

  override def toString = s"Person($name, $age)"
}

class Employee(override val name: String,
               override val age: Int,
               override val pet: Pet,
               val company: Company)
  extends Person(name, age, pet) {

  override def toString = s"Employee($name, $age, $pet, $company)"
}

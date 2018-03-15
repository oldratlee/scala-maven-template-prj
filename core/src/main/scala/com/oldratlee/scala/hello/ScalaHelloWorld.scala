package com.oldratlee.scala.hello

object ScalaHelloWorld extends HelloService {
  def main(args: Array[String]): Unit = {
    println(ScalaHelloWorld.hello("world"))
  }

  override def hello(name: String): String = s"Hello $name"
}

package showcase.delayed_init

trait T extends DelayedInit {
  def delayedInit(body: => Unit): Unit = {
    println("run delayInit")
    body // evaluates the initialization code
  }

  println("this is the initialization code of T")
}

class C1T extends T {
  println("this is the initialization code of C1T")
}

class C2C1T extends C1T {
  println("this is the initialization code of C2C1T")
}

trait C extends DelayedInit {
  def delayedInit(body: => Unit): Unit = {
    println("run delayInit")
    body // evaluates the initialization code
  }

  println("this is the initialization code of C")
}

class C1C extends C {
  println("this is the initialization code of C1C")
}

class C2C1C extends C1C {
  println("this is the initialization code of C2C1C")
}


object DelayInitDemo {
  def main(args: Array[String]): Unit = {
    println("New C2C1T...")
    val t = new C2C1T
    println(s"End C2C1T, instance $t")

    println()
    println("=" * 80)
    println()

    println("New C2C1C...")
    val c = new C2C1C
    println(s"End C2C1C, instance $c")
  }
}

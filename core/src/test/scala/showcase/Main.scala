package showcase

object Main {
  def main(args: Array[String]): Unit = {
    List(1, 2, 3) map { i => s"hello $i" } foreach println
  }
}

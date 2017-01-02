package showcase.testing.junit

import com.oldratlee.scala.hello.Pet
import org.junit.Assert._
import org.junit._

@Test
class Hello_Junit4ByScala_Test {

  @Test
  def testOK() = assertEquals(3, "abc".length)

  @Test
  def pet() = {
    val buddy = "buddy"
    val pet = Pet(buddy)
    assertEquals(buddy, pet.name)
  }

}

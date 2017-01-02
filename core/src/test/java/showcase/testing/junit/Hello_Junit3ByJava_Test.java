package showcase.testing.junit;

import com.oldratlee.scala.hello.Pet;
import junit.framework.TestCase;

public class Hello_Junit3ByJava_Test extends TestCase {
    public void testHello() throws Exception {
        assertEquals(3, "abc".length());
    }

    public void testPetName() throws Exception {
        final String buddy = "buddy";
        Pet pet = new Pet(buddy);
        assertEquals(buddy, pet.name());
    }
}

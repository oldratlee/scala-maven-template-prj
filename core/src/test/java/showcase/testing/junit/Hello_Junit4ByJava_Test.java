package showcase.testing.junit;

import com.oldratlee.scala.hello.Pet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Hello_Junit4ByJava_Test {
    @Test
    public void hello() throws Exception {
        assertEquals(3, "abc".length());
    }

    @Test
    public void petName() throws Exception {
        final String buddy = "buddy";
        Pet pet = new Pet(buddy);
        assertEquals(buddy, pet.name());
    }
}

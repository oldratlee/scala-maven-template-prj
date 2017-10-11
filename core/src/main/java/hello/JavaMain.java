package hello;

import com.oldratlee.scala.hello.Company;
import com.oldratlee.scala.hello.Employee;
import com.oldratlee.scala.hello.Pet;

/**
 * Hello world demo.
 * <p>
 * Just a Java rewrite for {@link ScalaMain}
 *
 * @see ScalaMain
 */
public class JavaMain {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // Use Scala class from Java
        final Employee employee = new Employee("jerry", 42, Pet.apply("buddy"), new Company("abc.com", "Street 1"));
        System.out.println(employee);
    }
}

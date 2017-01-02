package showcase.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaLogDemo {
    private static final Logger logger = LoggerFactory.getLogger(JavaLogDemo.class);

    public static void main(String[] args) {
        logger.info("Hello java logger!");
    }
}

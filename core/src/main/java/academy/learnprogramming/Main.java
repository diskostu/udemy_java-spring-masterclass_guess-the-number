package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";


    public static void main(String[] args) {
        log.info("Guess the number game");

        // create the context
        final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // get the bean
        final NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);

        final int number = numberGenerator.next();
        log.info("number = " + number);

        // close the context
        context.close();
    }
}
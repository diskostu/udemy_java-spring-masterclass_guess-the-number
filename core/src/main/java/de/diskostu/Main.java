package de.diskostu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        log.info("Guess the number game");

        // create the context
        final ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // get the number generator bean from the context
        // this works as long as there is only 1 implementation of NumberGenerator
        final NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);


        // call the method to get the next number, and log it
        final int number = numberGenerator.next();
        log.info(String.format("number = %d", number));

        // get the message generator bean from the context
        final MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info(String.format("messageGenerator.getMainMessage() = %s", messageGenerator.getMainMessage()));
        log.info(String.format("messageGenerator.getResultMessage() = %s", messageGenerator.getResultMessage()));

        // close the context
        context.close();
    }
}
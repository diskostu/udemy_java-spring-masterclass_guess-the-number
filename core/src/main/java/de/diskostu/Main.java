package de.diskostu;

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

        // get the number generator bean from the context
        // this works as long as there is only 1 implementation of NumberGenerator
        final NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);


        // call the method to get the next number, and log it
        final int number = numberGenerator.next();
        log.info("number = " + number);

        // get the game bean from the context
        // this works as long as there is only 1 implementation of Game
        final Game game = context.getBean(Game.class);

        // close the context
        context.close();
    }
}
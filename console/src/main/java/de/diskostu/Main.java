package de.diskostu;

import de.diskostu.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Guess the number game");

        // create the context - also starts the app
        final ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

        // close the context
        context.close();
    }
}
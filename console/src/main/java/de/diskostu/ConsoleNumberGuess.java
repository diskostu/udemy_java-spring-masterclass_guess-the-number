package de.diskostu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess {

    // == fields ==
    private final Game game;

    private final MessageGenerator messageGenerator;


    // == constructor ==
    @Autowired
    public ConsoleNumberGuess(Game aGame, MessageGenerator aMessageGenerator) {
        this.game = aGame;
        this.messageGenerator = aMessageGenerator;
    }


    /**
     * When using the {@link EventListener} annotation, the method name is free to choose.
     * <p>
     * Option 1: use the type of the event as a method parameter.
     * </p>
     */
    @EventListener(ContextRefreshedEvent.class)
    public void onContextRefreshed() {
        log.info("event: Context refreshed.");

        final Scanner scanner = new Scanner(System.in);
        while (true) {
            log.info(messageGenerator.getMainMessage());
            log.info(messageGenerator.getResultMessage());

            final int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if (game.isGameWon() || game.isGameLost()) {
                log.info(messageGenerator.getResultMessage());
                log.info("Play again y/n ?");

                final String playAgainString = scanner.nextLine().trim();
                if (!playAgainString.equalsIgnoreCase("y")) {
                    break;
                }

                game.reset();
            }
        }
    }


    /**
     * When using the {@link EventListener} annotation, the method name is free to choose.
     * <p>
     * Option 2: use the type of the event as a parameter for the annotation. This is useful if we don't need
     * the event as a method parameter.
     * </p>
     */
    @EventListener(ContextClosedEvent.class)
    public void onContextClosed() {
        log.info("event: Context closed.");
    }
}
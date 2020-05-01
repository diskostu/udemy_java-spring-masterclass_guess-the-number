package de.diskostu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    private final static Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;


    @PostConstruct
    private void init() {
        log.info("game = " + game);
    }


    @Override
    public String getMainMessage() {
        return String.format("Name is between %d and %d. Can you guess it?", game.getSmallest(), game.getBiggest());
    }


    @Override
    public String getResultMessage() {
        if (game.isGameWon()) {
            return String.format("You guessed it! The number was %d", game.getNumber());
        } else if (game.isGameLost()) {
            return String.format("You lost. The number was %d", game.getNumber());
        } else if (!game.isValidNumberRange()) {
            return "Invalid number range. " + getMainMessage();
        } else if (game.getRemainingGuesses() == game.getGuessCount1()) {
            return "What is your first guess?";
        } else {
            String direction = "lower";

            if (game.getGuess() < game.getNumber()) {
                direction = "higher";
            }

            return String.format("%s! You have %d guesses left.", direction, game.getRemainingGuesses());
        }
    }
}
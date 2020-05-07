package de.diskostu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    private final Game game;


    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }


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
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
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
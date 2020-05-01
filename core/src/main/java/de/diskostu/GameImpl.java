package de.diskostu;

import de.diskostu.config.GameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class GameImpl implements Game {

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // == fields ==
    @Autowired
    private NumberGenerator numberGenerator;

    /**
     * Normally, the name of the field has to match the method {@link GameConfig#guessCount()}. To be on the extra
     * safe side, we add the {@link Qualifier} annotation and pass the method name as the argument.
     * <br><br>
     * IntelliJ is smart enough to rename the value inside {@link Qualifier} when the bean method is renamed.
     */
    @Autowired
    @Qualifier("guessCount")
    private int guessCount1;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;


    // == init ==
    @PostConstruct
    @Override
    public void reset() {
        smallest = 0;
        guess = 0;
        remainingGuesses = guessCount1;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug(String.format("the number is %d", number));
    }


    // == destroy ==
    @PreDestroy
    public void preDestroy() {
        log.info("predestroy called");
    }


    // == public methods ==
    @Override
    public void check() {
        checkValidNumberRange();

        if (validNumberRange) {
            if (guess > number) {
                biggest = guess - 1;
            }

            if (guess < number) {
                smallest = guess + 1;
            }
        }

        remainingGuesses--;
    }


    @Override
    public int getNumber() {
        return number;
    }


    @Override
    public int getGuess() {
        return guess;
    }


    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }


    @Override
    public int getSmallest() {
        return smallest;
    }


    @Override
    public int getBiggest() {
        return biggest;
    }


    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }


    @Override
    public int getGuessCount1() {
        return guessCount1;
    }


    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }


    @Override
    public boolean isGameWon() {
        return guess == number;
    }


    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }


    // == private mthods ==
    private void checkValidNumberRange() {
        validNumberRange = guess >= smallest && guess <= biggest;
    }
}

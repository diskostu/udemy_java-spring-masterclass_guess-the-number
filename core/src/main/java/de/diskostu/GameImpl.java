package de.diskostu;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Getter
@Component
public class GameImpl implements Game {

    // == fields ==

    @Getter(AccessLevel.NONE) // we don't want a getter for this field
    private final NumberGenerator numberGenerator;
    private final int guessCount;
    private int number;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Setter // we need a setter for this field
    private int guess;


    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }


    // == init ==
    @PostConstruct
    @Override
    public void reset() {
        remainingGuesses = guessCount;
        guess = numberGenerator.getMinNumber();
        smallest = numberGenerator.getMinNumber();
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

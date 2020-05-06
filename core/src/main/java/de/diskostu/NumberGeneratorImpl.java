package de.diskostu;

import de.diskostu.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Notice that there is no {@link org.springframework.stereotype.Component} annotation here. This bean is created in
 * {@link AppConfig} via method.
 */
@Component
public class NumberGeneratorImpl implements NumberGenerator {

    // == fields ==
    private final Random random = new Random();

    private final int maxNumber;

    private final int minNumber;


    // == constructors ==
    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }


    // == public methods ==
    @Override
    public int next() {
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }


    @Override
    public int getMinNumber() {
        return minNumber;
    }


    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
package de.diskostu;

import de.diskostu.config.AppConfig;
import de.diskostu.config.GameConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

/**
 * Notice that there is no {@link org.springframework.stereotype.Component} annotation here. This bean is created in
 * {@link AppConfig} via method.
 */
public class NumberGeneratorImpl implements NumberGenerator {

    // == fields ==
    private final Random random = new Random();

    /**
     * The name of the field does not need to match the method {@link GameConfig#maxNumber()} anymore,
     * because of the custom annotation {@link MaxNumber} we created. Both the method which generates the bean AND
     * the field have to be annotated with @{@link MaxNumber}.
     */
    @Autowired
    @MaxNumber
    private int maxNumber;

    @Autowired
    @MinNumber
    private int minNumber;


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
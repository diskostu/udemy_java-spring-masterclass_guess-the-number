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
     * The name of the field has to match the method {@link GameConfig#maxNumber()}.
     */
    @Autowired
    private int maxNumber;


    // == public methods ==
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }


    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
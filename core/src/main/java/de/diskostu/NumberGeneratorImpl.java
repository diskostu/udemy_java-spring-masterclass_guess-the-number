package de.diskostu;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator {

    private final Random random = new Random();
    private final static int maxNumber = 100;


    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }


    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
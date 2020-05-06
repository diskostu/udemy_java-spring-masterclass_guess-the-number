package de.diskostu.config;

import de.diskostu.GuessCount;
import de.diskostu.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    // == fields ==
    private final int maxNumber = 25;

    private final int guessCount = 8;


    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumberDifferent() {
        return maxNumber;
    }


    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}
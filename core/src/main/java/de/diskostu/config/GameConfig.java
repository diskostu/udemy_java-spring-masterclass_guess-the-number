package de.diskostu.config;

import de.diskostu.GuessCount;
import de.diskostu.MaxNumber;
import de.diskostu.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // == fields ==
    @Value("${game.maxNumber}")
    private int maxNumber;

    @Value("${game.minNumber}")
    private int minNumber;

    @Value("${game.guessCount}")
    private int guessCount;


    // == bean methods ==


    /**
     * Notice that the {@link Bean} annotation is missing here. That's because the {@link MinNumber} annotation also
     * has the {@link Bean} annotation.
     */
    @MinNumber
    public int minNumber() {
        return minNumber;
    }


    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }


    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}
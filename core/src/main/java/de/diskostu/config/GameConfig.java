package de.diskostu.config;

import de.diskostu.GuessCount;
import de.diskostu.MaxNumber;
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

    @Value("${game.guessCount}")
    private int guessCount;


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
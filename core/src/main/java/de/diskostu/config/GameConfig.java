package de.diskostu.config;

import de.diskostu.GuessCount;
import de.diskostu.MaxNumber;
import de.diskostu.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
// explicit @Import for GameConfig class is not necessary, because GameConfig is found via component scanning
// (see the "Bean Dependencies" diagram)
//
// the explicit definition of the base package is not really necessary here, since component scanning happens
// per default in the package this class resides in. But it's a good habit to explicitly define it.
@ComponentScan(basePackages = "de.diskostu")
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
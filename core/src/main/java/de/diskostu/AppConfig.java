package de.diskostu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// the explicit definition of the base package is not really necessary here, since component scanning happens
// per default in the package this class resides in. But it's a good habit to explicitly define it.
@ComponentScan(basePackages = "de.diskostu")
public class AppConfig {

    /**
     * This is an alternative way of creating a bean, instead of using
     * {@link org.springframework.stereotype.Component} on the class itself. Useful if we have additional
     * configuration to take place.
     * <br><br>
     * The name of the method is not important here. <strong>Spring resolves the bean by type</strong>.
     *
     * @return an instance of the type {@link NumberGenerator}
     */
    @Bean
    public NumberGenerator createNumberGenerator() {
        return new NumberGeneratorImpl();
    }


    @Bean
    public MessageGenerator createMessageGenerator() {
        return new MessageGeneratorImpl();
    }
}
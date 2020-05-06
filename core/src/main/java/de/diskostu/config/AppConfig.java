package de.diskostu.config;

import de.diskostu.Game;
import de.diskostu.GameImpl;
import de.diskostu.MessageGenerator;
import de.diskostu.MessageGeneratorImpl;
import de.diskostu.NumberGenerator;
import de.diskostu.NumberGeneratorImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// explicit @Import for GameConfig class is not necessary, because GameConfig is found via component scanning
// (see the "Bean Dependencies" diagram)
//
// the explicit definition of the base package is not really necessary here, since component scanning happens
// per default in the package this class resides in. But it's a good habit to explicitly define it.
@ComponentScan(basePackages = "de.diskostu")
public class AppConfig {

    /**
     * This is an alternative way of creating a bean, instead of using
     * {@link org.springframework.stereotype.Component} on the class itself. Useful if we have additional
     * configuration to take place.
     * <br><br>
     * The name of the method is not important, if there is only 1 bean for a given type. <strong>Spring resolves the
     * bean by type in this case</strong>.
     * <br><br>
     * Things are different when there are <strong>more than 1</strong> methods annotated with {@link Bean} that
     * return the same type. When autowired, Spring does not know which bean definition to use, unless you use the
     * {@link Qualifier} annotation. In this annotation, you can either use the <strong>name of the method</strong> -
     * it's no longer unimportant - or, you could give the {@link Bean} annotation a <code>name</code> argument and
     * use this one in the {@link Qualifier} annotation.
     *
     * @return an instance of the type {@link NumberGenerator}
     */
    @Bean
    public NumberGenerator numberGenerator() {
        return new NumberGeneratorImpl();
    }


    @Bean
    public MessageGenerator messageGenerator() {
        return new MessageGeneratorImpl();
    }


    @Bean
    public Game game() {
        return new GameImpl();
    }
}
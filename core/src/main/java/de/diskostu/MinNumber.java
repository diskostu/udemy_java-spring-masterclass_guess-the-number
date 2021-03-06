package de.diskostu;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This is a custom annotation which can be used to qualify beans (hence the @{@link Qualifier} annotation. Both the
 * method which generates the bean AND the field which is autowired have to be annotated with this annotation.
 */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Bean
public @interface MinNumber {
}
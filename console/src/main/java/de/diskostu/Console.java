package de.diskostu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Console {

    private static final Logger log = LoggerFactory.getLogger(Console.class);


    /**
     * When using the {@link EventListener} annotation, the method name is free to choose.
     * <p>
     * Option 1: use the type of the event as a method parameter.
     * </p>
     *
     * @param event the event to listen for
     */
    @EventListener
    public void onContextRefreshed(ContextRefreshedEvent event) {
        log.info("event: Context refreshed.");
    }


    /**
     * When using the {@link EventListener} annotation, the method name is free to choose.
     * <p>
     * Option 2: use the type of the event as a parameter for the annotation. This is useful if we don't need
     * the event as a method parameter.
     * </p>
     */
    @EventListener(ContextClosedEvent.class)
    public void onContextClosed() {
        log.info("event: Context closed.");
    }
}
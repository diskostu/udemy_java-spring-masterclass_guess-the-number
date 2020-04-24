package de.diskostu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    private final static Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;

    private int guessCount = 10;


    @PostConstruct
    private void init() {
        log.info("game = " + game);
    }


    @Override
    public String getMainMessage() {
        return "This is the main message.";
    }


    @Override
    public String getResultMessage() {
        return "This is the result message.";
    }
}

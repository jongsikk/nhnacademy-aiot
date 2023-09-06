package main.java;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerPractice {
    private final static Logger logger = Logger.getLogger("myLogger");

    public static Logger getLogger() {
        logger.setLevel(Level.INFO);
        return logger;
    }
}
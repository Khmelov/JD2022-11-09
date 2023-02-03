package by.it.cherny.calc.controller;

import by.it.cherny.calc.util.PathFinder;
import by.it.cherny.jd02_06.Log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public enum Logger implements Log {
    INSTANCE;

    private static final String ERROR = "ERROR:";
    private static final String INFO = "INFO:";
    private final String filename = PathFinder.getFilePath("log.txt", Logger.class);

    @Override
    public void error(String message) {
        boolean append = true;
        log(append, ERROR, message);
        System.err.printf("%s %s%n",ERROR, message);
    }

    @Override
    public void info(String message) {
        boolean append = true;
        log(append, INFO, message);
        System.out.printf("%s %s%n",INFO, message);
    }

    private void log(boolean append, String TYPE, String message) {
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(filename, append))
        ) {
            printWriter.printf("%s %s%n",TYPE, message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

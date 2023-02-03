package by.it.vasileuskaya.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger implements Log {

    private static final boolean APPEND = true;
    private static final String ERROR = "Error: ";
    private static final String INFO = "Info: ";
    private final String fileName = PathFinder.getFilePath("log.txt", Logger.class);

    public Logger() {
    }

    private volatile static Logger logger;

    public static Logger getLogger() {
        Logger localLogger = logger;
        if (localLogger == null) {
            synchronized (Logger.class) {
                localLogger = logger;
                if (logger == null) {
                    localLogger = logger = new Logger();
                }
            }
        }
        return localLogger;
    }

    @Override
    public synchronized void info(String message) {
        logExtracted(message, INFO, message);
        System.out.println(INFO + message);
    }

    @Override
    public synchronized void error(String message) {
        logExtracted(message, ERROR, message);
        System.err.println(ERROR + message);
    }

    private void logExtracted(String message, String error, String s) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileName, APPEND))) {
            printWriter.println("error " + message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package by.it.han.jd02_06;

import by.it.han.jd01_15.PatchFinder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SingletonLogger implements Log {

    private static final String filePath = PatchFinder.getFilePath("log.txt", SingletonLogger.class);
    private static final boolean APPEND = true;
    private static final String ERROR = "ERROR: %s%n";
    private static final String INFO = "INFO: %s%n";
    private static volatile SingletonLogger INSTANCE;

    private SingletonLogger() {
    }

    public static SingletonLogger getInstance() {
        SingletonLogger singletonLogger = INSTANCE;
        if (INSTANCE == null) {
            synchronized (SingletonLogger.class) {
                if (singletonLogger == null) {
                    singletonLogger = INSTANCE = new SingletonLogger();
                }
            }
        }
        return singletonLogger;
    }

    @Override
    public synchronized void error(String message) {
        System.out.printf(ERROR, message);
        writeToFile(ERROR, message);
    }

    @Override
    public synchronized void info(String message) {
        System.out.printf(INFO, message);
        writeToFile(INFO, message);
    }

    private void writeToFile(String type, String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath, APPEND))) {
            out.printf(type, message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package by.it.bolshakov.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger implements Log {

    public static final boolean INFO_APPEND_TO_LOG = true;
    public static final boolean ERROR_APPEND_TO_LOG = true;
    private static final String ERROR = "ERROR:";
    private static final String INFO = "INFO:";
    private volatile static Logger logger;
    private final String filename = PathFinder.getFilePath("log.txt", Logger.class);

    private Logger() {
    }
    public static Logger getLogger() {
        Logger localLogger = logger;
        if (localLogger == null) {
            synchronized (Logger.class) {
                localLogger = logger;
                if (localLogger == null) {
                    logger = localLogger = new Logger();
                }
            }
        }
        return localLogger;
    }

    @Override
    public synchronized void info(String message) {
        log(INFO_APPEND_TO_LOG, INFO, message);
        System.out.printf("%s %s%n", INFO, message);
    }

    @Override
    public synchronized void error(String message) {
        log(ERROR_APPEND_TO_LOG, ERROR, message);
        System.err.printf("%s %s%n", ERROR, message);
    }

    private void log(boolean append, String TYPE, String message) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename, append))) {
            printWriter.printf("%s %s%n", TYPE, message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

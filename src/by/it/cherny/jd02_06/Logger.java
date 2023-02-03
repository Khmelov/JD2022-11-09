package by.it.cherny.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger implements Log {
    private static final String ERROR = "ERROR";
    private static final String INFO = "INFO";
    private final String filename = PathFinder.getFilePath("log.txt", Logger.class);

    private Logger() {
    }

    private volatile static Logger logger;


    public static Logger getLogger(){
        Logger localLogger = logger;
        if (localLogger==null){
            synchronized (Logger.class){
                localLogger = logger;
                if (localLogger==null){
                    localLogger = logger = new Logger();
                }
            }
        }
        return localLogger;
    }

    @Override
    public synchronized void info(String message) {
        boolean append = true;
        log(append, INFO, message);
        System.out.printf("%s %s%n",INFO, message);
    }

    @Override
    public synchronized void error(String message) {
        boolean append = true;
        log(append, ERROR, message);
        System.err.printf("%s %s%n",ERROR, message);
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

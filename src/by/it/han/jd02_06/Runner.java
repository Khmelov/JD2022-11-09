package by.it.han.jd02_06;

public class Runner {

    public static final String ERROR_MESSAGE = "error message";
    public static final String INFO_MESSAGE = "info message";

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            getThread().start();
        }

    }

    private static Thread getThread() {
        return new Thread(() -> {
            SingletonLogger logger = SingletonLogger.getInstance();
            logger.error(ERROR_MESSAGE);
            logger.info(INFO_MESSAGE);
        });
    }
}

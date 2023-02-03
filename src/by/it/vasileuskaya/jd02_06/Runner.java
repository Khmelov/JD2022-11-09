package by.it.vasileuskaya.jd02_06;

public class Runner {

    public static final int COUNT_THREAD = 15;

    public static void main(String[] args) {
        for (int i = 0; i < COUNT_THREAD; i++) {
            getThread(i).start();
        }
    }

    private static Thread getThread(int i) {
        return new Thread("Number " + i) {
            @Override
            public void run() {
                Logger logger = Logger.getLogger();
                logger.error("ERROR");
                logger.info("MESSAGE");
            }
        };
    }
}

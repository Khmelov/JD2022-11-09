package by.it._classwork_.jd02_06;

public class Runner {

    public static final int COUNT_THREAD = 10;

    public static void main(String[] args) {
        for (int i = 0; i < COUNT_THREAD; i++) {
            getThread(i).start();
        }

    }

    private static Thread getThread(int i) {
        return new Thread("#" + i) {
            @Override
            public void run() {
                Logger logger = Logger.getLogger();
                logger.error("ОШИБКА");
                logger.info("СООБЩЕНИЕ");
            }
        };
    }
}

package by.it.han.player;

import by.it.han.player.service.PlayerGeneratorTask;
import by.it.han.player.service.PlayerReaderTask;

import java.util.concurrent.ExecutionException;

public class Runner {

    public static final String NAME_OF_THREAD_STR = "Name of thread: %s ";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            startThreads(i);
        }
    }

    private static void startThreads(int i) {
        PlayerGeneratorTask playerGeneratorTask = new PlayerGeneratorTask(i);
        System.out.printf(NAME_OF_THREAD_STR, playerGeneratorTask.call().getNameTask());
        PlayerReaderTask playerReaderTask = new PlayerReaderTask(playerGeneratorTask);
        playerReaderTask.start();
    }
}

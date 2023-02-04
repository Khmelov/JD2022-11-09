package by.it.han.player;

import by.it.han.player.service.PlayerGeneratorTask;
import by.it.han.player.service.PlayerReaderTask;

public class Runner {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            PlayerGeneratorTask playerGeneratorTask = new PlayerGeneratorTask(i);
            playerGeneratorTask.start();
            PlayerReaderTask playerReaderTask = new PlayerReaderTask(playerGeneratorTask);
            playerReaderTask.start();
        }
    }
}

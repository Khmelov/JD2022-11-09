package by.it.han.player.service;

import by.it.han.jd01_15.PatchFinder;
import by.it.han.player.model.Player;
import by.it.han.player.util.RandomUtil;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PlayerGeneratorTask implements Callable<PlayerGeneratorTask> {

    private static int countName = 0;
    private static final boolean APPEND_FILE = true;
    private static final int MIN_AGE = 20;
    private static final int MAX_AGE = 40;
    private static final int PLAYER_COUNT = 10;
    private final List<Player> playerList = new ArrayList<>(PLAYER_COUNT);
    private final int nameTask;

    public PlayerGeneratorTask(int nameTask) {
        this.nameTask = nameTask;
    }

    public int getNameTask() {
        return nameTask;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void appendPlayer() {
        for (int i = 0; i < PLAYER_COUNT; i++) {
            int age = RandomUtil.get(MIN_AGE, MAX_AGE);
            Player player = new Player(i, age, APPEND_FILE);
            playerList.add(player);
        }
        saveToFile(playerList);
    }

    public void saveToFile(List<Player> playerList) {
        String filePath = PatchFinder.getFilePath(++countName + "", PlayerGeneratorTask.class);
        List<Player> players = playerList.stream()
                .filter(Player::isActive)
                .toList();
        try (PrintWriter out = new PrintWriter(filePath)) {
            out.println(players);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PlayerGeneratorTask call() {
        appendPlayer();
        return this;
    }
}

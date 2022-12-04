package com.agutsul.poker;

import com.agutsul.poker.impl.GameImpl;

import static org.apache.commons.io.FileUtils.readLines;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class FileExampleMain {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = FileExampleMain.class.getClassLoader();
        File file = new File(classLoader.getResource("poker.txt").getFile());
        List<String> lines = readLines(file, StandardCharsets.UTF_8);

        List<Player> winners = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            Game game = new GameImpl(i + 1, lines.get(i));
            game.run();

            System.out.println(game);
            winners.add(game.getWinner().get());
        }

        Map<String, Long> stats =
                winners.stream().collect(groupingBy(Player::getName, counting()));
        System.out.println(stats);
    }

}

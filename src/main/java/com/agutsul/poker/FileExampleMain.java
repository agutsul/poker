package com.agutsul.poker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.apache.commons.io.FileUtils.readLines;

public class FileExampleMain {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = FileExampleMain.class.getClassLoader();
        File file = new File(classLoader.getResource("poker.txt").getFile());
        List<String> lines = readLines(file, StandardCharsets.UTF_8);

        List<Player> winners = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            Game game = new Game(i + 1, lines.get(i));
            Player winner = game.run();

            System.out.println(game + "\tWinner: " + winner.getName() + " => " + winner.getHand());
            winners.add(winner);
        }

        Map<String, Long> stats =
                winners.stream().collect(groupingBy(Player::getName, counting()));
        System.out.println("Statistic: " + stats);
    }

}

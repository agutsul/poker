package com.agutsul.poker;

import java.util.List;

public class ExampleMain {

    public static void main(String[] args) {
        List<String> gameCards = List.of(
                "5H 5C 6S 7S KD 2C 3S 8S 8D TD",
                "5D 8C 9S JS AC 2C 5C 7D 8S QH",
                "2D 9C AS AH AC 3D 6D 7D TD QD",
                "4D 6S 9H QH QC 3D 6D 7H QD QS",
                "2H 2D 4C 4D 4S 3C 3D 3S 9S 9D"
//                "2H 2D 4C 5D 6S 2C 3D 2S 6S 5H"
        );

        for (int i = 0; i < gameCards.size(); i++) {
            Game game = new Game(i + 1, gameCards.get(i));
            Player winner = game.run();

            System.out.println(game + "\tWinner: " + winner.getName() + " => " + winner.getHand());
        }
    }
}

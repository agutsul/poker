package com.agutsul.poker;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.split;

public class Game {

    private final int id;
    private final Player player1;
    private final Player player2;

    private final List<Card> cards;

    public Game(int id, String string) {
        this(id, parseCards(string));
    }

    Game(int id, List<Card> cards) {
        this(id, cards,
                new Player("player1", cards.subList(0, 5)),
                new Player("player2", cards.subList(5, cards.size()))
        );
    }

    Game(int id, List<Card> cards, Player player1, Player player2) {
        this.id = id;
        this.cards = cards;
        this.player1 = player1;
        this.player2 = player2;
    }

    public int getId() {
        return id;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Player run() {
        Hand hand1 = player1.getHand();
        Hand hand2 = player2.getHand();

        if (hand1 == null || hand2 == null) {
            throw new IllegalStateException("Unknown winner: undefined hand");
        }

        int comparison = hand1.compareTo(hand2);
        if (comparison == 0) {
            throw new IllegalStateException("Unknown winner: same hands");
        }

        return comparison > 0 ? player1 : player2;
    }

    @Override
    public String toString() {
        return String.format("Game#%d\t%s\tvs\t%s", id, player1, player2);
    }

    private static List<Card> parseCards(String string) {
        List<String> cards = asList(split(string, " "));
        if (cards.size() != 10) {
            throw new IllegalArgumentException("Incorrect game cards: " + string);
        }

        return cards.stream().map(Card::new).collect(toList());
    }
}

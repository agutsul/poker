package com.agutsul.poker.impl;

import com.agutsul.poker.Card;
import com.agutsul.poker.Game;
import com.agutsul.poker.Player;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.split;

public final class GameImpl implements Game {
    private final int id;
    private final Player player1;
    private final Player player2;

    private final List<Card> cards;

    public GameImpl(int id, String string) {
        this(id, parseCards(string));
    }

    GameImpl(int id, List<Card> cards) {
        this(id, cards,
                new PlayerImpl("player1", cards.subList(0, 5)),
                new PlayerImpl("player2", cards.subList(5, cards.size()))
        );
    }

    GameImpl(int id, List<Card> cards, Player player1, Player player2) {
        this.id = id;
        this.cards = cards;
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Player getPlayer1() {
        return player1;
    }

    @Override
    public Player getPlayer2() {
        return player2;
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }

    @Override
    public Optional<Player> getWinner() {
        if (player1.getHand().isEmpty() && player2.getHand().isEmpty()) {
            return Optional.empty();
        }

        int comparison = player1.compareTo(player2);
        if (comparison == 0) {
            throw new IllegalStateException("Unknown winner");
        }

        return Optional.of(comparison > 0 ? player1 : player2);
    }

    @Override
    public void run() {
        player1.play();
        player2.play();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Game#").append(getId());

        sb.append("\t").append(player1);
        if (player1.getHand().isPresent()) {
            sb.append(" '").append(player1.getHand().get()).append("'");
        }

        sb.append("\t").append(player2);
        if (player2.getHand().isPresent()) {
            sb.append(" '").append(player2.getHand().get()).append("'\t");
        }

        Optional<Player> winner = getWinner();
        if (winner.isPresent()) {
            sb.append("\tWinner: ").append(winner.get().getName());
        }

        return sb.toString();
    }

    private static List<Card> parseCards(String string) {
        List<String> cards = asList(split(string, " "));
        if (cards.size() != 10) {
            throw new IllegalArgumentException("Incorrect game cards: " + string);
        }

        return cards.stream().map(CardImpl::new).collect(toList());
    }
}

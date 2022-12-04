package com.agutsul.poker;

import java.util.List;

public interface Player extends Comparable<Player> {
    String getName();
    List<Card> getCards();
    Hand getHand();
    void play();
}

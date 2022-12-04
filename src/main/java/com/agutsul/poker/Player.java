package com.agutsul.poker;

import java.util.List;
import java.util.Optional;

public interface Player extends Comparable<Player> {
    String getName();
    List<Card> getCards();
    Optional<Hand> getHand();
    void play();
}

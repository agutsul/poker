package com.agutsul.poker;

import java.util.List;

public interface Player {
    String getName();
    List<Card> getCards();
    Hand getHand();
}

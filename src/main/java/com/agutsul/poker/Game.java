package com.agutsul.poker;

import java.util.List;

public interface Game {
    int getId();
    List<Card> getCards();
    Player run();
}

package com.agutsul.poker;

import java.util.List;

public interface Game {
    int getId();
    Player getPlayer1();
    Player getPlayer2();
    Player getWinner();
    List<Card> getCards();
    void run();
}

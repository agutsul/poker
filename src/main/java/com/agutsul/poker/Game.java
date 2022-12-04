package com.agutsul.poker;

import java.util.List;
import java.util.Optional;

public interface Game {
    int getId();
    Player getPlayer1();
    Player getPlayer2();
    Optional<Player> getWinner();
    List<Card> getCards();
    void run();
}

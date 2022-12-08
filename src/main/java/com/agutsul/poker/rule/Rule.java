package com.agutsul.poker.rule;

import com.agutsul.poker.Card;
import com.agutsul.poker.Hand;

import java.util.Collection;
import java.util.Optional;

public interface Rule {
    String label();
    int value();

    Optional<Hand> evaluate(Collection<Card> cards);
}

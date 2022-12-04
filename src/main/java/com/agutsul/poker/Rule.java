package com.agutsul.poker;

import java.util.Collection;
import java.util.Optional;

public interface Rule {
    String label();
    int value();

    Optional<Hand> evaluate(Collection<Card> cards);
}

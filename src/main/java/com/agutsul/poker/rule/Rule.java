package com.agutsul.poker.rule;

import com.agutsul.poker.Card;
import com.agutsul.poker.Hand;

import java.util.Collection;

public interface Rule {

    String label();

    int value();

    Hand evaluate(Collection<Card> cards);
}

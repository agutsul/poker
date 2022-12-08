package com.agutsul.poker.rule;

import com.agutsul.poker.Card;

import java.util.Collection;
import java.util.function.Function;

interface CardFunction extends Function<Collection<Card>, Collection<Card>> {
}

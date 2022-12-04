package com.agutsul.poker.impl.function;

import com.agutsul.poker.Card;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

final class CompositeCardFunction implements CardFunction {

    private final List<CardFunction> cardFunctions;

    public CompositeCardFunction(CardFunction cardFunction,
                                 CardFunction... additionalCardFunctions) {

        List<CardFunction> cardFunctions = new ArrayList<>();
        cardFunctions.add(cardFunction);
        cardFunctions.addAll(asList(additionalCardFunctions));

        this.cardFunctions = cardFunctions;
    }

    @Override
    public Collection<Card> apply(Collection<Card> cards) {
        Set<Card> matchedCards = new LinkedHashSet<>();
        for (CardFunction cardFunction : cardFunctions) {
            Collection<Card> cardCollection = cardFunction.apply(cards);
            if (cardCollection.isEmpty()) {
                return emptyList();
            }

            matchedCards.addAll(cardCollection);
        }

        return matchedCards;
    }
}

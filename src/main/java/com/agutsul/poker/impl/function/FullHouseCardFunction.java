package com.agutsul.poker.impl.function;

import com.agutsul.poker.Card;

import java.util.Collection;
import static java.util.Collections.emptyList;

public final class FullHouseCardFunction implements CardFunction {

    private final CardFunction cardFunction;

    public FullHouseCardFunction() {
        this.cardFunction = new CompositeCardFunction(
                new QuantityRankCardFunction(3),
                new PairRankCardFunction(1)
        );
    }

    @Override
    public Collection<Card> apply(Collection<Card> cards) {
        Collection<Card> matchedCards = cardFunction.apply(cards);
        if (cards.size() == matchedCards.size()) {
            return matchedCards;
        }

        return emptyList();
    }
}

package com.agutsul.poker.rule;

import com.agutsul.poker.Card;

import java.util.Collection;
import static java.util.Collections.emptyList;

final class FullHouseCardFunction implements CardFunction {

    private final CardFunction cardFunction;

    FullHouseCardFunction() {
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

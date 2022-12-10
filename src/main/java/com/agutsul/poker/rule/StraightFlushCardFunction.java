package com.agutsul.poker.rule;

import com.agutsul.poker.Card;
import com.agutsul.poker.Rank;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static com.agutsul.poker.enums.Ranks.*;
import static java.util.Collections.emptyList;
import static java.util.EnumSet.range;

class StraightFlushCardFunction implements CardFunction {

    private static final List<Set<? extends Rank>> STRAIGHTS = List.of(
            range(TWO,   SIX),
            range(THREE, SEVEN),
            range(FOUR,  EIGHT),
            range(FIVE,  NINE),
            range(SIX,   TEN),
            range(SEVEN, JACK),
            range(EIGHT, QUEEN),
            range(NINE,  KING)
    );
    private final CardFunction cardFunction;

    StraightFlushCardFunction() {
        this(STRAIGHTS);
    }
    StraightFlushCardFunction(List<Set<? extends Rank>> ranks) {
        this.cardFunction = new CompositeCardFunction(
                new SameSuitCardFunction(),
                new StraightRankCardFunction(ranks)
        );
    }

    @Override
    public Collection<Card> apply(Collection<Card> cards) {
        Collection<Card> matchedCards = cardFunction.apply(cards);
        if (matchedCards.isEmpty()) {
            return emptyList();
        }

        return matchedCards;
    }
}

package com.agutsul.poker.rule;

import com.agutsul.poker.Card;
import com.agutsul.poker.enums.Ranks;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static java.util.EnumSet.range;
import static java.util.Collections.emptyList;

class StraightFlushCardFunction implements CardFunction {

    private static final List<Set<Ranks>> STRAIGHTS = List.of(
            range(Ranks.TWO,   Ranks.SIX),
            range(Ranks.THREE, Ranks.SEVEN),
            range(Ranks.FOUR,  Ranks.EIGHT),
            range(Ranks.FIVE,  Ranks.NINE),
            range(Ranks.SIX,   Ranks.TEN),
            range(Ranks.SEVEN, Ranks.JACK),
            range(Ranks.EIGHT, Ranks.QUEEN),
            range(Ranks.NINE,  Ranks.KING)
    );
    private final CardFunction cardFunction;

    StraightFlushCardFunction() {
        this(STRAIGHTS);
    }
    StraightFlushCardFunction(List<Set<Ranks>> ranks) {
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

package com.agutsul.poker.rule;

import com.agutsul.poker.Card;
import com.agutsul.poker.Rank;
import com.agutsul.poker.enums.Ranks;

import java.util.*;

import static java.util.Comparator.reverseOrder;
import static java.util.EnumSet.range;
import static java.util.stream.Collectors.toSet;
import static java.util.Collections.emptyList;

final class StraightRankCardFunction implements CardFunction {

    private static final List<Set<Ranks>> STRAIGHTS = List.of(
            range(Ranks.TWO,   Ranks.SIX),
            range(Ranks.THREE, Ranks.SEVEN),
            range(Ranks.FOUR,  Ranks.EIGHT),
            range(Ranks.FIVE,  Ranks.NINE),
            range(Ranks.SIX,   Ranks.TEN),
            range(Ranks.SEVEN, Ranks.JACK),
            range(Ranks.EIGHT, Ranks.QUEEN),
            range(Ranks.NINE,  Ranks.KING),
            range(Ranks.TEN,   Ranks.ACE)
    );

    private final List<Set<Ranks>> straights;

    StraightRankCardFunction() {
        this(STRAIGHTS);
    }

    StraightRankCardFunction(List<Set<Ranks>> straights) {
        this.straights = straights;
    }

    @Override
    public Collection<Card> apply(Collection<Card> cards) {
        Set<Rank> cardRanks = cards.stream()
                .map(Card::getRank)
                .collect(toSet());

        if (cardRanks.size() != 5) {
            return emptyList();
        }

        if (straights.stream().noneMatch(ranks -> ranks.containsAll(cardRanks))) {
            return emptyList();
        }

        Set<Card> straightSet = new TreeSet<>(reverseOrder());
        straightSet.addAll(cards);

        return straightSet;
    }
}

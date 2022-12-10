package com.agutsul.poker.rule;

import com.agutsul.poker.Card;
import com.agutsul.poker.Rank;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static com.agutsul.poker.enums.Ranks.*;
import static java.util.Collections.emptyList;
import static java.util.Comparator.reverseOrder;
import static java.util.EnumSet.range;
import static java.util.stream.Collectors.toSet;

final class StraightRankCardFunction implements CardFunction {

    private static final List<Set<? extends Rank>> STRAIGHTS = List.of(
            range(TWO,   SIX),
            range(THREE, SEVEN),
            range(FOUR,  EIGHT),
            range(FIVE,  NINE),
            range(SIX,   TEN),
            range(SEVEN, JACK),
            range(EIGHT, QUEEN),
            range(NINE,  KING),
            range(TEN,   ACE)
    );

    private final List<Set<? extends Rank>> straights;

    StraightRankCardFunction() {
        this(STRAIGHTS);
    }

    StraightRankCardFunction(List<Set<? extends Rank>> straights) {
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

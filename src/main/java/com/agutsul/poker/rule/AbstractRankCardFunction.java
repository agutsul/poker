package com.agutsul.poker.rule;

import com.agutsul.poker.Card;
import com.agutsul.poker.Rank;
import com.agutsul.poker.comparator.RankComparator;
import com.agutsul.poker.comparator.SuitComparator;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.emptyList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

abstract class AbstractRankCardFunction implements CardFunction {

    private static final RankComparator RANK_COMPARATOR = new RankComparator();
    private static final SuitComparator SUIT_COMPARATOR = new SuitComparator();

    private final int frequency;

    AbstractRankCardFunction(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public Collection<Card> apply(Collection<Card> cards) {
        Map<Rank, Set<Card>> cardsByRank = cards.stream()
                .collect(groupingBy(Card::getRank, toSet()));

        if (cards.size() == cardsByRank.size()) {
            return emptyList();
        }

        List<Set<Card>> matchedFrequency = cardsByRank.values().stream()
                .filter(cardSet -> cardSet.size() == frequency)
                .collect(toList());

        if (matchedFrequency.isEmpty()) {
            return emptyList();
        }

        Collection<Card> matchedCards = findMatched(matchedFrequency);
        return matchedCards.stream()
                .sorted(
                        comparing(Card::getRank, RANK_COMPARATOR).reversed()
                                .thenComparing(Card::getSuit, SUIT_COMPARATOR)
                )
                .collect(toList());
    }

    protected abstract Collection<Card> findMatched(List<Set<Card>> matchedFrequency);
}

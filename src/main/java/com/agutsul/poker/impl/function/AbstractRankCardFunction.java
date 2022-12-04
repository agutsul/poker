package com.agutsul.poker.impl.function;

import com.agutsul.poker.Card;
import com.agutsul.poker.Rank;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.*;

public abstract class AbstractRankCardFunction implements CardFunction {

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

        return applyMatched(matchedFrequency);
    }

    protected abstract Collection<Card> applyMatched(List<Set<Card>> matchedFrequency);
}

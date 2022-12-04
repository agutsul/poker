package com.agutsul.poker.impl.function;

import com.agutsul.poker.Card;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;
import static java.util.Comparator.reverseOrder;

public final class PairRankCardFunction extends AbstractRankCardFunction {

    private final int expectedPairs;

    public PairRankCardFunction(int expectedPairs) {
        super(2);
        this.expectedPairs = expectedPairs;
    }

    @Override
    protected Collection<Card> applyMatched(List<Set<Card>> matchedFrequency) {
        if (matchedFrequency.size() < expectedPairs) {
            return emptyList();
        }

        return matchedFrequency.subList(0, expectedPairs).stream()
                .flatMap(Collection::stream)
                .sorted(reverseOrder())
                .collect(toList());
    }
}

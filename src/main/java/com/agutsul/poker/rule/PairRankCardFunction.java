package com.agutsul.poker.rule;

import com.agutsul.poker.Card;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;
import static java.util.Comparator.reverseOrder;

final class PairRankCardFunction extends AbstractRankCardFunction {

    private final int pairs;

    PairRankCardFunction(int pairs) {
        super(2);
        this.pairs = pairs;
    }

    @Override
    protected Collection<Card> applyMatched(List<Set<Card>> matchedFrequency) {
        if (matchedFrequency.size() < pairs) {
            return emptyList();
        }

        return matchedFrequency.subList(0, pairs).stream()
                .flatMap(Collection::stream)
                .sorted(reverseOrder())
                .collect(toList());
    }
}

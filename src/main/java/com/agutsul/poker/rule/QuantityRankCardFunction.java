package com.agutsul.poker.rule;

import com.agutsul.poker.Card;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

final class QuantityRankCardFunction extends AbstractRankCardFunction {

    QuantityRankCardFunction(int quantity) {
        super(quantity);
    }

    @Override
    protected Collection<Card> applyMatched(List<Set<Card>> matchedFrequency) {
        return matchedFrequency.stream()
                .flatMap(Collection::stream)
                .collect(toList());
    }
}

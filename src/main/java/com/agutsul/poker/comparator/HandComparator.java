package com.agutsul.poker.comparator;

import com.agutsul.poker.Card;
import com.agutsul.poker.Hand;

import java.util.Collection;
import java.util.Comparator;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

public final class HandComparator implements Comparator<Hand> {

    private static final RuleComparator RULE_COMPARATOR = new RuleComparator();
    private static final CardsComparator CARDS_COMPARATOR = new CardsComparator();

    @Override
    public int compare(Hand hand1, Hand hand2) {
        int ruleComparison = RULE_COMPARATOR.compare(
                hand1.getRule(),
                hand2.getRule()
        );

        if (ruleComparison != 0) {
            return ruleComparison;
        }

        // highest card inside matched combination
        int comparison = CARDS_COMPARATOR.compare(
                hand1.getMatchedCards(),
                hand2.getMatchedCards()
        );

        if (comparison != 0) {
            return comparison;
        }

        // highest card outside matched combination
        return CARDS_COMPARATOR.compare(
                getNonMatchedCards(hand1),
                getNonMatchedCards(hand2)
        );
    }

    private static Collection<Card> getNonMatchedCards(Hand hand) {
        return getNonMatchedCards(hand.getCards(), hand.getMatchedCards());
    }

    private static Collection<Card> getNonMatchedCards(Collection<Card> cards,
                                                       Collection<Card> skipCards) {
        return cards.stream()
                .filter(card -> !skipCards.contains(card))
                .sorted(reverseOrder())
                .collect(toList());
    }
}

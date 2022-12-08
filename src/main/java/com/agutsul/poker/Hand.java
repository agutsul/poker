package com.agutsul.poker;

import com.agutsul.poker.rule.Rule;

import java.util.*;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Hand implements Comparable<Hand> {
    private static final HandComparator HAND_COMPARATOR = new HandComparator();

    private final Rule rule;
    private final Collection<Card> cards;
    private final Collection<Card> matchedCards;

    public Hand(Rule rule, Collection<Card> cards, Collection<Card> matchedCards) {
        this.rule = rule;
        this.cards = cards;
        this.matchedCards = matchedCards;
    }

    public Rule getRule() {
        return rule;
    }

    public Collection<Card> getMatchedCards() {
        return matchedCards;
    }

    public Collection<Card> getCards() {
        return cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Hand hand = (Hand) o;
        return Objects.equals(rule, hand.getRule())
                && Objects.equals(matchedCards, hand.getMatchedCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(rule, matchedCards);
    }

    @Override
    public String toString() {
        return String.format("%s: [%s]", rule,
                matchedCards.stream().map(Card::toString).collect(joining(" ")));
    }

    @Override
    public int compareTo(Hand hand) {
        return HAND_COMPARATOR.compare(this, hand);
    }

    private static class HandComparator implements Comparator<Hand> {

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
            List<Card> nonMatchedCards = cards.stream()
                    .filter(card -> !skipCards.contains(card))
                    .sorted(reverseOrder())
                    .collect(toList());

            return nonMatchedCards;
        }

        private static class RuleComparator implements Comparator<Rule> {

            @Override
            public int compare(Rule rule1, Rule rule2) {
                return Integer.compare(rule1.value(), rule2.value());
            }
        }

        private static class CardsComparator implements Comparator<Collection<Card>> {

            @Override
            public int compare(Collection<Card> col1, Collection<Card> col2) {
                List<Card> cards1 = new ArrayList<>(col1);
                List<Card> cards2 = new ArrayList<>(col2);

                for (int i = 0; i < cards1.size(); i++) {
                    Card card1 = cards1.get(i);
                    Card card2 = cards2.get(i);

                    int comparison = card1.compareTo(card2);
                    if (comparison != 0) {
                        return comparison;
                    }
                }

                return 0;
            }
        }
    }
}

package com.agutsul.poker;

import com.agutsul.poker.enums.Ranks;
import com.agutsul.poker.enums.Suits;

import java.util.Comparator;
import java.util.Objects;

public class Card implements Comparable<Card> {

    private static final RankComparator RANK_COMPARATOR = new RankComparator();

    private final Suit suit;
    private final Rank rank;

    public Card(Rank rank, Suit suit) {
        this.rank = Objects.requireNonNull(rank);
        this.suit = Objects.requireNonNull(suit);
    }

    public Card(String code) {
        this(Character.toString(code.charAt(0)),
                Character.toString(code.charAt(1)));
    }

    private Card(String rank, String suit) {
        this(Ranks.rankOf(rank), Suits.suitOf(suit));
    }

    public Suit getSuit() {
        return suit;
    }
    public Rank getRank() {
        return rank;
    }
    @Override
    public String toString() {
        return String.format("%s%s", rank, suit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit.equals(card.getSuit()) && rank.equals(card.getRank());
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public int compareTo(Card card) {
        return RANK_COMPARATOR.compare(rank, card.getRank());
    }

    private static class RankComparator implements Comparator<Rank> {
        @Override
        public int compare(Rank rank1, Rank rank2) {
            return Integer.compare(rank1.value(), rank2.value());
        }
    }
}

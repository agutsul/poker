package com.agutsul.poker;

public interface Card extends Comparable<Card> {
    Suit getSuit();
    Rank getRank();
}

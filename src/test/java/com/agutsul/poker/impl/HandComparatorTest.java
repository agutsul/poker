package com.agutsul.poker.impl;

import com.agutsul.poker.Hand;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static java.util.Collections.*;

import static org.mockito.Mockito.*;

class HandComparatorTest {

    @Test
    void testNotEqualsHands() {
        Hand hand1 = mock(Hand.class);
        Hand hand2 = mock(Hand.class);

        when(hand1.compareTo(eq(hand2))).thenReturn(1);

        HandComparator comparator = new HandComparator();
        assertEquals(1, comparator.compare(hand1, hand2));
    }

    @Test
    void testHandMatchedCards() {
        Hand hand1 = mock(Hand.class);
        when(hand1.getMatchedCards())
                .thenReturn(singleton(new CardImpl(Ranks.SIX, Suits.CLUBS)));

        Hand hand2 = mock(Hand.class);
        when(hand2.getMatchedCards())
                .thenReturn(singleton(new CardImpl(Ranks.FIVE, Suits.SPADES)));

        when(hand1.compareTo(eq(hand2))).thenReturn(0);

        HandComparator comparator = new HandComparator();
        assertEquals(1, comparator.compare(hand1, hand2));
    }

    @Test
    void testHandNonMatchedCards() {
        Hand hand1 = mock(Hand.class);
        when(hand1.getMatchedCards())
                .thenReturn(singleton(new CardImpl(Ranks.SIX, Suits.CLUBS)));
        when(hand1.getNonMatchedCards())
                .thenReturn(singleton(new CardImpl(Ranks.SEVEN, Suits.CLUBS)));

        Hand hand2 = mock(Hand.class);
        when(hand2.getMatchedCards())
                .thenReturn(singleton(new CardImpl(Ranks.SIX, Suits.SPADES)));
        when(hand2.getNonMatchedCards())
                .thenReturn(singleton(new CardImpl(Ranks.SEVEN, Suits.SPADES)));

        when(hand1.compareTo(eq(hand2))).thenReturn(0);

        HandComparator comparator = new HandComparator();
        assertEquals(0, comparator.compare(hand1, hand2));
    }
}

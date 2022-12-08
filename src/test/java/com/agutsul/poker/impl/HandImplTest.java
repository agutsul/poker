package com.agutsul.poker.impl;

import com.agutsul.poker.Hand;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

class HandImplTest {

    @Test
    void testHandEqualsSameHand() {
        Hand hand = new HandImpl(Rules.ONE_PAIR,
                List.of(new CardImpl(Ranks.EIGHT, Suits.SPADES),
                        new CardImpl(Ranks.QUEEN, Suits.SPADES),
                        new CardImpl(Ranks.TWO, Suits.HEARTS),
                        new CardImpl(Ranks.FIVE, Suits.SPADES),
                        new CardImpl(Ranks.FIVE, Suits.CLUBS)
                ),
                List.of(new CardImpl(Ranks.FIVE, Suits.SPADES),
                        new CardImpl(Ranks.FIVE, Suits.CLUBS)
                )
        );

        assertTrue(hand.equals(hand));
        assertEquals(Rules.ONE_PAIR, hand.getRule());
    }

    @Test
    void testHandEqualsOtherObject() {
        Hand hand = new HandImpl(Rules.ONE_PAIR,
                List.of(new CardImpl(Ranks.EIGHT, Suits.SPADES),
                        new CardImpl(Ranks.QUEEN, Suits.SPADES),
                        new CardImpl(Ranks.TWO, Suits.HEARTS),
                        new CardImpl(Ranks.FIVE, Suits.SPADES),
                        new CardImpl(Ranks.FIVE, Suits.CLUBS)
                ),
                List.of(new CardImpl(Ranks.FIVE, Suits.SPADES),
                        new CardImpl(Ranks.FIVE, Suits.CLUBS)
                )
        );

        assertFalse(hand.equals(new Object()));
    }

    @Test
    void testHandEqualsWithDifferentHand() {
        Hand hand1 = new HandImpl(Rules.ONE_PAIR,
                List.of(new CardImpl(Ranks.EIGHT, Suits.SPADES),
                        new CardImpl(Ranks.QUEEN, Suits.SPADES),
                        new CardImpl(Ranks.TWO, Suits.HEARTS),
                        new CardImpl(Ranks.FIVE, Suits.SPADES),
                        new CardImpl(Ranks.FIVE, Suits.CLUBS)
                ),
                List.of(new CardImpl(Ranks.FIVE, Suits.SPADES),
                        new CardImpl(Ranks.FIVE, Suits.CLUBS)
                )
        );

        Hand hand2 = new HandImpl(Rules.ONE_PAIR,
                List.of(new CardImpl(Ranks.TWO, Suits.SPADES),
                        new CardImpl(Ranks.THREE, Suits.SPADES),
                        new CardImpl(Ranks.ACE, Suits.HEARTS),
                        new CardImpl(Ranks.FIVE, Suits.HEARTS),
                        new CardImpl(Ranks.FIVE, Suits.DIAMONDS)
                ),
                List.of(new CardImpl(Ranks.FIVE, Suits.HEARTS),
                        new CardImpl(Ranks.FIVE, Suits.DIAMONDS)
                )
        );

        assertFalse(hand1.equals(hand2));
    }

    @Test
    void testToString() {
        Hand hand = new HandImpl(Rules.ONE_PAIR,
                List.of(new CardImpl(Ranks.EIGHT, Suits.SPADES),
                        new CardImpl(Ranks.QUEEN, Suits.SPADES),
                        new CardImpl(Ranks.TWO, Suits.HEARTS),
                        new CardImpl(Ranks.FIVE, Suits.SPADES),
                        new CardImpl(Ranks.FIVE, Suits.CLUBS)
                ),
                List.of(new CardImpl(Ranks.FIVE, Suits.SPADES),
                        new CardImpl(Ranks.FIVE, Suits.CLUBS)
                )
        );

        assertEquals("One Pair: [5♠ 5♣]", hand.toString());
    }

    @Test
    void testHandCompareTo() {
        Hand hand = new HandImpl(Rules.ONE_PAIR,
                List.of(new CardImpl(Ranks.EIGHT, Suits.SPADES),
                        new CardImpl(Ranks.QUEEN, Suits.SPADES),
                        new CardImpl(Ranks.TWO, Suits.HEARTS),
                        new CardImpl(Ranks.FIVE, Suits.SPADES),
                        new CardImpl(Ranks.FIVE, Suits.CLUBS)
                ),
                List.of(new CardImpl(Ranks.FIVE, Suits.SPADES),
                        new CardImpl(Ranks.FIVE, Suits.CLUBS)
                )
        );

        assertEquals(0, hand.compareTo(hand));
    }
}

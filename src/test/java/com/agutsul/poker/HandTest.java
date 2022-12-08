package com.agutsul.poker;

import com.agutsul.poker.enums.Ranks;
import com.agutsul.poker.enums.Suits;
import com.agutsul.poker.rule.Rules;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void testHandEqualsSameHand() {
        Hand hand = new Hand(Rules.ONE_PAIR,
                List.of(new Card(Ranks.EIGHT, Suits.SPADES),
                        new Card(Ranks.QUEEN, Suits.SPADES),
                        new Card(Ranks.TWO, Suits.HEARTS),
                        new Card(Ranks.FIVE, Suits.SPADES),
                        new Card(Ranks.FIVE, Suits.CLUBS)
                ),
                List.of(new Card(Ranks.FIVE, Suits.SPADES),
                        new Card(Ranks.FIVE, Suits.CLUBS)
                )
        );

        assertTrue(hand.equals(hand));
        assertEquals(Rules.ONE_PAIR, hand.getRule());
    }

    @Test
    void testHandEqualsOtherObject() {
        Hand hand = new Hand(Rules.ONE_PAIR,
                List.of(new Card(Ranks.EIGHT, Suits.SPADES),
                        new Card(Ranks.QUEEN, Suits.SPADES),
                        new Card(Ranks.TWO, Suits.HEARTS),
                        new Card(Ranks.FIVE, Suits.SPADES),
                        new Card(Ranks.FIVE, Suits.CLUBS)
                ),
                List.of(new Card(Ranks.FIVE, Suits.SPADES),
                        new Card(Ranks.FIVE, Suits.CLUBS)
                )
        );

        assertFalse(hand.equals(new Object()));
    }

    @Test
    void testHandEqualsWithDifferentHand() {
        Hand hand1 = new Hand(Rules.ONE_PAIR,
                List.of(new Card(Ranks.EIGHT, Suits.SPADES),
                        new Card(Ranks.QUEEN, Suits.SPADES),
                        new Card(Ranks.TWO, Suits.HEARTS),
                        new Card(Ranks.FIVE, Suits.SPADES),
                        new Card(Ranks.FIVE, Suits.CLUBS)
                ),
                List.of(new Card(Ranks.FIVE, Suits.SPADES),
                        new Card(Ranks.FIVE, Suits.CLUBS)
                )
        );

        Hand hand2 = new Hand(Rules.ONE_PAIR,
                List.of(new Card(Ranks.TWO, Suits.SPADES),
                        new Card(Ranks.THREE, Suits.SPADES),
                        new Card(Ranks.ACE, Suits.HEARTS),
                        new Card(Ranks.FIVE, Suits.HEARTS),
                        new Card(Ranks.FIVE, Suits.DIAMONDS)
                ),
                List.of(new Card(Ranks.FIVE, Suits.HEARTS),
                        new Card(Ranks.FIVE, Suits.DIAMONDS)
                )
        );

        assertFalse(hand1.equals(hand2));
    }

    @Test
    void testToString() {
        Hand hand = new Hand(Rules.ONE_PAIR,
                List.of(new Card(Ranks.EIGHT, Suits.SPADES),
                        new Card(Ranks.QUEEN, Suits.SPADES),
                        new Card(Ranks.TWO, Suits.HEARTS),
                        new Card(Ranks.FIVE, Suits.SPADES),
                        new Card(Ranks.FIVE, Suits.CLUBS)
                ),
                List.of(new Card(Ranks.FIVE, Suits.SPADES),
                        new Card(Ranks.FIVE, Suits.CLUBS)
                )
        );

        assertEquals("One Pair: [5♠ 5♣]", hand.toString());
    }

    @Test
    void testHandCompareTo() {
        Hand hand = new Hand(Rules.ONE_PAIR,
                List.of(new Card(Ranks.EIGHT, Suits.SPADES),
                        new Card(Ranks.QUEEN, Suits.SPADES),
                        new Card(Ranks.TWO, Suits.HEARTS),
                        new Card(Ranks.FIVE, Suits.SPADES),
                        new Card(Ranks.FIVE, Suits.CLUBS)
                ),
                List.of(new Card(Ranks.FIVE, Suits.SPADES),
                        new Card(Ranks.FIVE, Suits.CLUBS)
                )
        );

        assertEquals(0, hand.compareTo(hand));
    }
}

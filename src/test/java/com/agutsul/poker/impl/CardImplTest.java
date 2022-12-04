package com.agutsul.poker.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.agutsul.poker.Card;
import org.junit.jupiter.api.Test;

class CardImplTest {

    @Test
    void testCardCreationWithNullRank() {
        assertThrows(
                NullPointerException.class,
                () -> new CardImpl(null, Suits.CLUBS)
        );
    }

    @Test
    void testCardCreationWithNullSuit() {
        assertThrows(
                NullPointerException.class,
                () -> new CardImpl(Ranks.KING, null)
        );
    }

    @Test
    void testCardCreationWithCode() {
        Card card = new CardImpl("2D");
        assertNotNull(card);
        assertEquals(Ranks.TWO, card.getRank());
        assertEquals(Suits.DIAMONDS, card.getSuit());

        Card card2 = new CardImpl("TC");
        assertNotNull(card2);
        assertEquals(Ranks.TEN, card2.getRank());
        assertEquals(Suits.CLUBS, card2.getSuit());

        Card card3 = new CardImpl("AH");
        assertNotNull(card3);
        assertEquals(Ranks.ACE, card3.getRank());
        assertEquals(Suits.HEARTS, card3.getSuit());
    }

    @Test
    void testCardCreationWithNullCode() {
        assertThrows(
                NullPointerException.class,
                () -> new CardImpl(null)
        );
    }

    @Test
    void testCardCreationWithIncorrectCode() {
        assertThrows(
                NullPointerException.class,
                () -> new CardImpl("K2")
        );

        assertThrows(
                StringIndexOutOfBoundsException.class,
                () -> new CardImpl("Z")
        );
    }

    @Test
    void testCardToString() {
        Card card1 = new CardImpl(Ranks.ACE, Suits.DIAMONDS);
        assertEquals("A♦", card1.toString());

        Card card2 = new CardImpl(Ranks.TEN, Suits.CLUBS);
        assertEquals("T♣", card2.toString());

        Card card3 = new CardImpl(Ranks.TWO, Suits.SPADES);
        assertEquals("2♠", card3.toString());

        Card card4 = new CardImpl(Ranks.JACK, Suits.HEARTS);
        assertEquals("J❤", card4.toString());
    }

    @Test
    void testCardEqualForSameCard() {
        Card card = new CardImpl(Ranks.FIVE, Suits.HEARTS);
        assertTrue(card.equals(card));

        Card card2 = new CardImpl(Ranks.FIVE, Suits.HEARTS);
        assertTrue(card.equals(card2));
    }

    @Test
    void testCardEqualsForDifferentCards() {
        Card card1 = new CardImpl(Ranks.FIVE, Suits.HEARTS);
        Card card2 = new CardImpl(Ranks.FIVE, Suits.DIAMONDS);
        assertFalse(card1.equals(card2));
    }

    @Test
    void testCardEqualsForDifferentObject() {
        Card card = new CardImpl(Ranks.FIVE, Suits.HEARTS);
        assertFalse(card.equals(new Object()));
    }

    @Test
    void testCardCompareToCard() {
        Card card = new CardImpl(Ranks.FIVE, Suits.HEARTS);
        Card card2 = new CardImpl(Ranks.FIVE, Suits.HEARTS);

        assertEquals(0, card.compareTo(card));
        assertEquals(0, card.compareTo(card2));

        Card card3 = new CardImpl(Ranks.FIVE, Suits.DIAMONDS);
        assertEquals(0, card.compareTo(card3));

        Card card4 = new CardImpl(Ranks.FOUR, Suits.SPADES);
        assertEquals(1, card.compareTo(card4));

        Card card5 = new CardImpl(Ranks.SIX, Suits.CLUBS);
        assertEquals(-1, card.compareTo(card5));
    }
}

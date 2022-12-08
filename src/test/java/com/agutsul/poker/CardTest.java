package com.agutsul.poker;

import com.agutsul.poker.enums.Ranks;
import com.agutsul.poker.enums.Suits;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void testCardCreationWithNullRank() {
        assertThrows(
                NullPointerException.class,
                () -> new Card(null, Suits.CLUBS)
        );
    }

    @Test
    void testCardCreationWithNullSuit() {
        assertThrows(
                NullPointerException.class,
                () -> new Card(Ranks.KING, null)
        );
    }

    @Test
    void testCardCreationWithCode() {
        Card card = new Card("2D");
        assertNotNull(card);
        assertEquals(Ranks.TWO, card.getRank());
        assertEquals(Suits.DIAMONDS, card.getSuit());

        Card card2 = new Card("TC");
        assertNotNull(card2);
        assertEquals(Ranks.TEN, card2.getRank());
        assertEquals(Suits.CLUBS, card2.getSuit());

        Card card3 = new Card("AH");
        assertNotNull(card3);
        assertEquals(Ranks.ACE, card3.getRank());
        assertEquals(Suits.HEARTS, card3.getSuit());
    }

    @Test
    void testCardCreationWithNullCode() {
        assertThrows(
                NullPointerException.class,
                () -> new Card(null)
        );
    }

    @Test
    void testCardCreationWithIncorrectCode() {
        assertThrows(
                NullPointerException.class,
                () -> new Card("K2")
        );

        assertThrows(
                StringIndexOutOfBoundsException.class,
                () -> new Card("Z")
        );
    }

    @Test
    void testCardToString() {
        Card card1 = new Card(Ranks.ACE, Suits.DIAMONDS);
        assertEquals("A♦", card1.toString());

        Card card2 = new Card(Ranks.TEN, Suits.CLUBS);
        assertEquals("T♣", card2.toString());

        Card card3 = new Card(Ranks.TWO, Suits.SPADES);
        assertEquals("2♠", card3.toString());

        Card card4 = new Card(Ranks.JACK, Suits.HEARTS);
        assertEquals("J❤", card4.toString());
    }

    @Test
    void testCardEqualForSameCard() {
        Card card = new Card(Ranks.FIVE, Suits.HEARTS);
        assertTrue(card.equals(card));

        Card card2 = new Card(Ranks.FIVE, Suits.HEARTS);
        assertTrue(card.equals(card2));
    }

    @Test
    void testCardEqualsForDifferentCards() {
        Card card1 = new Card(Ranks.FIVE, Suits.HEARTS);
        Card card2 = new Card(Ranks.FIVE, Suits.DIAMONDS);
        assertFalse(card1.equals(card2));
    }

    @Test
    void testCardEqualsForDifferentObject() {
        Card card = new Card(Ranks.FIVE, Suits.HEARTS);
        assertFalse(card.equals(new Object()));
    }

    @Test
    void testCardCompareToCard() {
        Card card = new Card(Ranks.FIVE, Suits.HEARTS);
        Card card2 = new Card(Ranks.FIVE, Suits.HEARTS);

        assertEquals(0, card.compareTo(card));
        assertEquals(0, card.compareTo(card2));

        Card card3 = new Card(Ranks.FIVE, Suits.DIAMONDS);
        assertEquals(0, card.compareTo(card3));

        Card card4 = new Card(Ranks.FOUR, Suits.SPADES);
        assertEquals(1, card.compareTo(card4));

        Card card5 = new Card(Ranks.SIX, Suits.CLUBS);
        assertEquals(-1, card.compareTo(card5));
    }
}

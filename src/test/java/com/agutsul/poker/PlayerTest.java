package com.agutsul.poker;

import com.agutsul.poker.enums.Ranks;
import com.agutsul.poker.enums.Suits;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PlayerTest {

    @Test
    void testPlayerCreation() {
        Player player = new Player("any", createCards());
        assertNotNull(player);
        assertNotNull(player.getCards());
        assertEquals("any", player.getName());
    }

    @Test
    void testPlayerToString() {
        Player player = new Player("any", createCards());
        assertEquals("any: [3♠, 5♣, 8♠, Q♠, 2❤] - Highest Card: [Q♠]", player.toString());
    }

    @Test
    void testPlayerGetHand() {
        Player player = new Player("any", createCards());
        Hand hand1 = player.getHand();
        assertNotNull(hand1);

        Hand hand2 = player.getHand();
        assertNotNull(hand2);
        assertEquals(hand1, hand2);
    }

    private List<Card> createCards() {
        return List.of(
                new Card(Ranks.THREE, Suits.SPADES),
                new Card(Ranks.FIVE, Suits.CLUBS),
                new Card(Ranks.EIGHT, Suits.SPADES),
                new Card(Ranks.QUEEN, Suits.SPADES),
                new Card(Ranks.TWO, Suits.HEARTS)
        );
    }
}

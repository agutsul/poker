package com.agutsul.poker.impl;

import com.agutsul.poker.Card;
import com.agutsul.poker.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerImplTest {

    @Test
    void testPlayerCreation() {
        Player player = new PlayerImpl("any", createCards());
        assertNotNull(player);
        assertNotNull(player.getCards());
        assertEquals("any", player.getName());
    }

    @Test
    void testPlayerToString() {
        Player player = new PlayerImpl("any", createCards());
        assertEquals("any: [Q♠, 8♠, 5♣, 3♠, 2❤]", player.toString());
    }

    private List<Card> createCards() {
        return List.of(
                new CardImpl(Ranks.THREE, Suits.SPADES),
                new CardImpl(Ranks.FIVE, Suits.CLUBS),
                new CardImpl(Ranks.EIGHT, Suits.SPADES),
                new CardImpl(Ranks.QUEEN, Suits.SPADES),
                new CardImpl(Ranks.TWO, Suits.HEARTS)
        );
    }
}

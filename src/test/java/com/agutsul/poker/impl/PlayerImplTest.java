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
        assertTrue(player.getHand().isEmpty());
    }

    @Test
    void testPlayerToString() {
        Player player = new PlayerImpl("any", createCards());
        assertEquals("any: [Q♠, 8♠, 5♣, 3♠, 2❤]", player.toString());
    }

    @Test
    void testPlayerCompareToPlayer() {
        Player player1 = new PlayerImpl("any1", createCards());
        Player player2 = new PlayerImpl("any2", List.of(
                new CardImpl(Ranks.FOUR, Suits.SPADES),
                new CardImpl(Ranks.FOUR, Suits.CLUBS),
                new CardImpl(Ranks.KING, Suits.SPADES),
                new CardImpl(Ranks.JACK, Suits.SPADES),
                new CardImpl(Ranks.JACK, Suits.HEARTS)
        ));

        player1.play();
        player2.play();

        assertEquals(-1, player1.compareTo(player2));

        Player player3 = new PlayerImpl("any3", List.of(
                new CardImpl(Ranks.FOUR, Suits.SPADES),
                new CardImpl(Ranks.THREE, Suits.CLUBS),
                new CardImpl(Ranks.JACK, Suits.CLUBS),
                new CardImpl(Ranks.JACK, Suits.SPADES),
                new CardImpl(Ranks.JACK, Suits.HEARTS)
        ));
        player3.play();

        assertEquals(-1, player1.compareTo(player3));

        Player player4 = new PlayerImpl("any4", List.of(
                new CardImpl(Ranks.FOUR, Suits.DIAMONDS),
                new CardImpl(Ranks.THREE, Suits.DIAMONDS),
                new CardImpl(Ranks.JACK, Suits.DIAMONDS),
                new CardImpl(Ranks.EIGHT, Suits.DIAMONDS),
                new CardImpl(Ranks.QUEEN, Suits.DIAMONDS)
        ));
        player4.play();

        assertEquals(-1, player1.compareTo(player4));
    }

    @Test
    void testPlayerPlaying() {
        Player player = new PlayerImpl("any", createCards());

        assertTrue(player.getHand().isEmpty());
        player.play();

        assertTrue(player.getHand().isPresent());
        assertEquals(Rules.HIGH_CARD, player.getHand().get().getRule());
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

package com.agutsul.poker.impl;

import com.agutsul.poker.Game;
import com.agutsul.poker.Hand;
import com.agutsul.poker.Player;
import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameImplTest {

    @Test
    void testCreateGameWithInvalidString() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new GameImpl(123, "any")
        );
    }

    @Test
    void testCreateGameWithIncorrectString() {
        assertThrows(
                NullPointerException.class,
                () -> new GameImpl(123, "2H 2D 4C 5D 6S 2C 3D 2S 6S 5F")
        );
    }

    @Test
    void testCreateGameWithCorrectString() {
        Game game = new GameImpl(123, "2H 2D 4C 5D 6S 2C 3D 2S 6S 5H");
        assertNotNull(game);
        assertEquals(123, game.getId());
        assertNotNull(game.getPlayer1());
        assertNotNull(game.getPlayer2());
        assertNotNull(game.getCards());
        assertEquals(10, game.getCards().size());
    }

    @Test
    void testGameToString() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);

        when(player1.compareTo(eq(player2))).thenReturn(1);

        Game game = new GameImpl(123, "2H 2D 4C 5D 6S 2C 3D 2S 6S 5H");
        assertNotNull(game);
        assertEquals("Game#123\tplayer1: [6♠, 5♦, 4♣, 2❤, 2♦]\tplayer2: [6♠, 5❤, 3♦, 2♣, 2♠]",
                game.toString());
    }

    @Test
    void testGameRunWithUnknownWinner() {
        Player player1 = mock(Player.class);
        when(player1.getHand()).thenReturn(mock(Hand.class));

        Player player2 = mock(Player.class);
        when(player2.getHand()).thenReturn(mock(Hand.class));

        when(player1.compareTo(eq(player2))).thenReturn(0);

        Game game = new GameImpl(1, emptyList(), player1, player2);
        game.run();

        Throwable throwable = assertThrows(
                IllegalStateException.class,
                game::getWinner
        );

        assertEquals("Unknown winner", throwable.getMessage());
    }

    @Test
    void testGameRunWithWinner() {
        Player player1 = mock(Player.class);
        when(player1.getHand()).thenReturn(mock(Hand.class));

        Player player2 = mock(Player.class);
        when(player2.getHand()).thenReturn(mock(Hand.class));

        when(player1.compareTo(eq(player2))).thenReturn(1);

        Game game = new GameImpl(1, emptyList(), player1, player2);
        game.run();

        Player winner = game.getWinner();
        assertNotNull(winner);

        assertEquals(player1, winner);
    }

}

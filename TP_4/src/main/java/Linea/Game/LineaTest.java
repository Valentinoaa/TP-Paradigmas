package Linea.Game;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class LineaTest {

    Linea game;

    @BeforeEach
    public void setUp(){
        game = new Linea( 4, 4, 'C');
    }

    @Test
    public void test01NewLinea() {
        game = new Linea( 4, 4, 'C');
        assertEquals( 4, game.boardColumns());
        assertEquals( 0, game.columnChips( 0 ));
        assertEquals( 0, game.columnChips( 1 ));
        assertEquals( 0, game.columnChips( 2 ));
        assertEquals( 0, game.columnChips( 3 ));
    }

    @Test
    public void test02RedStarts(){
        game = new Linea( 4, 4, 'C');
        assertTrue(game.itsRedsTurn());
        assertFalse(game.itsBluesTurn());
    }

    @Test
    public void test03BlueCantPlayInRedTurn(){
        game = new Linea( 4, 4, 'C');
        assertThrows( RuntimeException.class, () -> game.playBlueAt( 0 ));
        assertTrue(game.itsRedsTurn());
        assertFalse(game.itsBluesTurn());
    }

    @Test
    public void test04RedPlays(){
        game = new Linea( 4, 4, 'C');
        game.playRedAt( 0 );
        assertEquals( 1, game.columnChips( 0 ));
        assertEquals( 0, game.columnChips( 1 ));
        assertEquals( 0, game.columnChips( 2 ));
        assertEquals( 0, game.columnChips( 3 ));
        assertTrue(game.lastChipInColumnIsRed( 0 ));
        assertTrue(game.itsBluesTurn());
    }

    @Test
    public void test05RedCantPlayTwice(){
        game = new Linea( 4, 4, 'C');
        game.playRedAt( 0 );
        assertThrows( RuntimeException.class, () -> game.playRedAt( 0 ));
        assertEquals( 1, game.columnChips( 0 ));
        assertTrue(game.lastChipInColumnIsRed( 0 ));
        assertTrue(game.itsBluesTurn());
    }

    @Test
    public void test06MultipleChipsInColumn(){
        game = new Linea( 4, 4, 'C');
        game.playRedAt( 0 );
        game.playBlueAt( 0 );
        game.playRedAt( 0 );
        game.playBlueAt( 0 );
        assertEquals( 4, game.columnChips( 0 ));
        assertTrue(game.lastChipInColumnIsBlue( 0 ));
        assertTrue(game.itsRedsTurn());
    }

    @Test
    public void test07RedColumnWins(){
        game = new Linea( 4, 4, 'C');
        game.playRedAt( 0 );
        game.playBlueAt( 1 );
        game.playRedAt( 0 );
        game.playBlueAt( 1 );
        game.playRedAt( 0 );
        game.playBlueAt( 1 );
        game.playRedAt( 0 );
        assertTrue(game.finished());
        assertThrows( RuntimeException.class, () -> game.playBlueAt( 1 ));
    }

    @Test
    public void test08BlueRowWins(){
        game = new Linea( 4, 4, 'C');
        game.playRedAt( 0 );
        game.playBlueAt( 1 );
    }


}

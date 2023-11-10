package Linea;

import Linea.turn.Turn;
import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.testng.Assert.*;


public class LineaTest {

    Linea game;

    @Test
    public void test00IsGameModeSetCorrectly(){
        game = new Linea( 4, 4, 'C');
        assertEquals( 'C', game.getGameMode());
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
        assertThrowsLike( () -> game.playBlueAt( 0 ), Turn.NO_ES_TURNO_DE_AZUL);
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
        assertThrowsLike( () -> game.playRedAt( 0 ), Turn.NO_ES_TURNO_DE_ROJO);
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
        assertThrowsLike( () -> game.playBlueAt( 1 ), Turn.YA_TERMINO_EL_JUEGO);
    }

    @Test
    public void test08BlueRowWins(){
        game = new Linea( 5, 5, 'C');
        game.playRedAt( 0 );
        game.playBlueAt( 1 );
        game.playRedAt( 0 );
        game.playBlueAt( 2 );
        game.playRedAt( 1 );
        game.playBlueAt( 3 );
        game.playRedAt( 2 );
        game.playBlueAt(4);
        assertTrue(game.finished());
        assertThrowsLike( () -> game.playRedAt( 3 ), Turn.YA_TERMINO_EL_JUEGO);

    }

    @Test
    public void test09RedDiagonalWins(){
        game = new Linea( 5, 5, 'C');
        playIn(List.of(0, 1, 1, 2, 2, 3, 2, 3, 3, 4));
        assertTrue(game.finished());
    }

    private void assertThrowsLike(Executable executable, String message ) {

        assertEquals( message,
                Assertions.assertThrows( Exception.class, executable).getMessage() );
    }

    private void playIn(List<Integer> columns) {
        boolean red = true;
        for (Integer column : columns) {
            if (red) {
                game.playRedAt(column);
                red = false;
            } else {
                game.playBlueAt(column);
                red = true;
            }
        }
    }

}

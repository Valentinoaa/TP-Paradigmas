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
        assertEquals( 0, game.columnChips( 1 ));
        assertEquals( 0, game.columnChips( 2 ));
        assertEquals( 0, game.columnChips( 3 ));
        assertEquals( 0, game.columnChips( 4 ));
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
        assertThrowsLike( () -> game.playBlueAt( 1 ), Turn.NO_ES_TURNO_DE_AZUL);
        assertTrue(game.itsRedsTurn());
        assertFalse(game.itsBluesTurn());
    }

    @Test
    public void test04RedPlays(){
        game = new Linea( 4, 4, 'C');
        game.playRedAt( 1 );
        assertEquals( 1, game.columnChips( 1 ));
        assertEquals( 0, game.columnChips( 2 ));
        assertEquals( 0, game.columnChips( 3 ));
        assertEquals( 0, game.columnChips( 4 ));
        assertTrue(game.lastChipInColumnIsRed( 1 ));
        assertTrue(game.itsBluesTurn());
    }

    @Test
    public void test05RedCantPlayTwice(){
        game = new Linea( 4, 4, 'C');
        game.playRedAt( 1 );
        assertThrowsLike( () -> game.playRedAt( 1 ), Turn.NO_ES_TURNO_DE_ROJO);
        assertEquals( 1, game.columnChips( 1 ));
        assertTrue(game.lastChipInColumnIsRed( 1 ));
        assertTrue(game.itsBluesTurn());
    }

    @Test
    public void test06MultipleChipsInColumn(){
        game = new Linea( 4, 4, 'C');
        game.playRedAt( 1);
        game.playBlueAt( 1 );
        game.playRedAt( 1 );
        game.playBlueAt( 1 );
        assertEquals( 4, game.columnChips( 1 ));
        assertTrue(game.lastChipInColumnIsBlue( 1 ));
        assertTrue(game.itsRedsTurn());
    }

    @Test
    public void test07RedColumnWins(){
        game = new Linea( 4, 4, 'A');
        playIn(List.of(1, 2, 1, 2, 1, 2, 1));
        assertTrue(game.finished());
        assertThrowsLike( () -> game.playBlueAt( 2 ), Turn.YA_TERMINO_EL_JUEGO);
        // Está mal acceder a la variable turn creo
    }

    @Test
    public void test08BlueRowWins(){
        game = new Linea( 5, 5, 'A');
        playIn(List.of(1, 2, 1, 3, 1, 4, 1));
        assertTrue(game.finished());
        assertThrowsLike( () -> game.playRedAt( 3 ), Turn.YA_TERMINO_EL_JUEGO);

    }

    @Test
    public void test09RedDiagonalWins(){
        game = new Linea( 5, 5, 'B');
        playIn(List.of(1, 2, 2, 3, 3, 4, 3, 4, 4, 1, 4));
        game.show();
        assertTrue(game.finished());
    }

    @Test
    public void test10MoreDiagonalChecks() {
        game = new Linea( 5, 5, 'B');
        playIn(List.of(1, 1, 1, 1, 2, 4, 2, 2, 3, 3));
        assertTrue(game.finished());
    }

    @Test
    public void test12Draw(){
        game = new Linea( 3, 3, 'C');
        playIn(List.of(1, 2, 3, 1, 2, 3, 1, 2));
        assertThrowsLike( () -> game.playRedAt( 2 ), Linea.TIE);
        assertTrue(game.finished());
    }

    @Test
    public void test13FullBoard(){
        game = new Linea(4, 4, 'C');
        playIn(List.of(1, 2, 3, 4, 1, 2, 3, 4, 4, 3, 2, 1, 4, 3, 2));
        // MMM medio raro esto, el empate deberia saltar cuando meto la ficha??
        assertThrowsLike( () -> game.playRedAt( 0 ), Linea.TIE);
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

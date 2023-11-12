package Linea;

import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.testng.Assert.*;


public class LineaTest {

    private Linea game;

    @Test
    public void test00IsGameModeSetCorrectly(){
        game = new Linea( 4, 4, 'C');
        assertEquals( 'C', game.getGameMode());
    }

    @Test
    public void test01IsGameModeSetCorrectly(){
        assertThrowsLike( () -> game = new Linea( 4, 4, 'D'), GameMode.INVALID_MODE);
    }

    @Test
    public void test02BoardStarsEmpty() {
        game = new Linea( 4, 4, 'C');
        assertTrue(game.isEmpty());
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
    public void testCantPlayChipOutsideTheBoard(){
        game = new Linea(2, 2, 'C');
        assertThrowsLike(() -> game.playRedAt(3), Linea.INVALID_COLUMN);
    }

    @Test
    public void testCantPlaceChipAtColumnZero(){
        game = new Linea(4, 4, 'C');
        assertThrowsLike(() -> game.playRedAt(0), Linea.INVALID_COLUMN);
    }

    @Test
    public void test04RedPlaysCorrectly(){
        game = new Linea( 4, 4, 'C');
        game.playRedAt( 1 );
        assertEquals( 1, game.columnChips( 1 ));
        assertEquals( 0, game.columnChips( 2 ));
        assertEquals( 0, game.columnChips( 3 ));
        assertEquals( 0, game.columnChips( 4 ));
        assertTrue(game.lastChipInColumnIs( 'R', 1 ));
        assertTrue(game.itsBluesTurn());
    }

    @Test
    public void test03BlueCantPlayInRedTurn(){
        game = new Linea( 4, 4, 'C');
        assertThrowsLike( () -> game.playBlueAt( 1 ), Turn.NOT_BLUES_TURN);
        assertTrue(game.itsRedsTurn());
        assertFalse(game.itsBluesTurn());
    }

    @Test
    public void test05RedCantPlayInBluesTurn(){
        game = new Linea( 4, 4, 'C');
        game.playRedAt( 1 );
        assertThrowsLike( () -> game.playRedAt( 1 ), Turn.NOT_REDS_TURN);
        assertEquals( 1, game.columnChips( 1 ));
        assertTrue(game.lastChipInColumnIs('R', 1 ));
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
        assertTrue(game.lastChipInColumnIs('B', 1 ));
        assertTrue(game.itsRedsTurn());
    }

    @Test
    public void testCantPlayOnFullColumn(){
        game = new Linea(4, 4, 'C');
        playIn(List.of(1, 1, 1, 1 ));
        assertThrowsLike(() -> game.playRedAt(1), Linea.INVALID_COLUMN);
    }

    @Test
    public void test07RedColumnWins(){
        game = new Linea( 4, 4, 'A');
        playIn(List.of(1, 2, 1, 2, 1, 2, 1));
        assertTrue(game.finished());
        assertThrowsLike( () -> game.playBlueAt( 2 ), "R wins!");
    }
    @Test
    public void test08BlueRowWins(){
        game = new Linea( 5, 5, 'A');
        playIn(List.of(1, 2, 2, 3, 1, 5, 1, 4));
        assertTrue(game.finished());
        assertThrowsLike( () -> game.playRedAt( 3 ), "B wins!");

    }
    @Test void test08DiagonalCantWinInRowsAndColsMode(){
        game = new Linea( 5, 5, 'A');
        playIn(List.of(1, 2, 2, 3, 3, 4, 3, 4, 4, 1, 4));
        assertFalse(game.finished());
    }
    @Test
    public void test08ColumnCantWinInDiagonalsMode (){
        game = new Linea( 4, 4, 'B');
        playIn(List.of(1, 2, 1, 2, 1, 2, 1));
        assertFalse(game.finished());
    }

    @Test
    public void test09RedDiagonalWins(){
        game = new Linea( 5, 5, 'B');
        playIn(List.of(1, 2, 2, 3, 3, 4, 3, 4, 4, 1, 4));
        game.show();
        assertTrue(game.finished());
    }

    @Test
    public void test10LeftDiagonalWins() {
        game = new Linea( 5, 5, 'B');
        playIn(List.of(1, 1, 1, 1, 2, 4, 2, 2, 3, 3));
        assertTrue(game.finished());
    }
    @Test
    public void test14Draw(){
        game = new Linea( 2, 2, 'C');
        playIn(List.of(1, 2, 1, 2));
        assertTrue(game.finished());
        assertThrowsLike( () -> game.playRedAt( 1 ), GameMode.DRAW);
    }

    @Test
    public void test12Draw(){
        game = new Linea( 3, 3, 'C');
        playIn(List.of(1, 2, 3, 1, 2, 3, 1, 2, 3));
        assertThrowsLike( () -> game.playBlueAt( 3 ), GameMode.DRAW);
        assertTrue(game.finished());

    }

    @Test
    public void test13FullBoard(){
        game = new Linea(4, 4, 'C');
        playIn(List.of(1, 2, 3, 4, 1, 2, 3, 4, 4, 3, 2, 1, 4, 3, 2, 1));
        assertThrowsLike( () -> game.playRedAt( 1 ), GameMode.DRAW);
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

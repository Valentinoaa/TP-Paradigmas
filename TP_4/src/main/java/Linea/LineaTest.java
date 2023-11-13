package Linea;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class LineaTest {

    private Linea game;

    @Test
    public void test00IsGameModeSetCorrectly(){
        game = new Linea( 4, 4, 'C');
        assertEquals( 'C', game.getGameMode());
    }

    @Test
    public void test01IsGameModeSetCorrectly(){
        assertThrowsLike( () -> game = new Linea( 4, 4, 'D'),
                GameMode.INVALID_MODE);
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
    public void test03ShowEmptyBoard(){
        game = new Linea( 4, 4, 'C');
        assertEquals(game.show(),
                "|  -  -  -  -  |\n" +
                        "|  -  -  -  -  |\n" +
                        "|  -  -  -  -  |\n" +
                        "|  -  -  -  -  |\n" +
                        "|  ^  ^  ^  ^  |\n"
            );
    }

    @Test
    public void test04ShowAsymmetricBoard(){
        game = new Linea( 4, 6, 'C');
        assertEquals(game.show(),
                "|  -  -  -  -  |\n" +
                        "|  -  -  -  -  |\n" +
                        "|  -  -  -  -  |\n" +
                        "|  -  -  -  -  |\n" +
                        "|  -  -  -  -  |\n" +
                        "|  -  -  -  -  |\n" +
                        "|  ^  ^  ^  ^  |\n"
        );
    }

    @Test
    public void test05RedStarts(){
        game = new Linea( 4, 4, 'C');
        assertTrue(game.itsRedsTurn());
        assertFalse(game.itsBluesTurn());
    }

    @Test
    public void test06CantPlayChipOutsideTheBoard(){
        game = new Linea(2, 2, 'C');
        assertThrowsLike(() -> game.playRedAt(3), Linea.INVALID_COLUMN);
    }

    @Test
    public void test07CantPlaceChipAtColumnZero(){
        game = new Linea(4, 4, 'C');
        assertThrowsLike(() -> game.playRedAt(0), Linea.INVALID_COLUMN);
    }

    @Test
    public void test08RedPlaysCorrectly(){
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
    public void test09RedChipDisplaysCorrectly(){
        game = new Linea( 4, 4, 'C');
        game.playRedAt( 1 );
        assertEquals(game.show(),
                "|  -  -  -  -  |\n" +
                "|  -  -  -  -  |\n" +
                "|  -  -  -  -  |\n" +
                "|  R  -  -  -  |\n" +
                "|  ^  ^  ^  ^  |\n");

    }

    @Test
    public void test10BlueCantPlayInRedTurn(){
        game = new Linea( 4, 4, 'C');
        assertThrowsLike( () -> game.playBlueAt( 1 ), Turn.NOT_BLUES_TURN);
        assertTrue(game.itsRedsTurn());
        assertFalse(game.itsBluesTurn());
    }

    @Test
    public void test11RedCantPlayInBluesTurn(){
        game = new Linea( 4, 4, 'C');
        game.playRedAt( 1 );
        assertThrowsLike( () -> game.playRedAt( 1 ), Turn.NOT_REDS_TURN);
        assertEquals( 1, game.columnChips( 1 ));
        assertTrue(game.lastChipInColumnIs('R', 1 ));
        assertTrue(game.itsBluesTurn());
    }

    @Test
    public void test12MultipleChipsInColumn(){
        game = new Linea( 4, 4, 'C');
        playIn(List.of(1, 1, 1, 1 ));
        assertEquals( 4, game.columnChips( 1 ));
        assertTrue(game.lastChipInColumnIs('B', 1 ));
        assertTrue(game.itsRedsTurn());
    }

    @Test
    public void test13ShowMultipleChips(){
        game = new Linea( 4, 4, 'C');
        playIn(List.of(1, 2, 1, 1, 3, 4 ));
        assertEquals(game.show(),
                "|  -  -  -  -  |\n" +
                        "|  B  -  -  -  |\n" +
                        "|  R  -  -  -  |\n" +
                        "|  R  B  R  B  |\n" +
                        "|  ^  ^  ^  ^  |\n");
    }

    @Test
    public void test14ShowChipsInAsymmetricBoard(){
        game = new Linea( 5, 3, 'C');
        playIn(List.of(1, 2, 1, 1, 3, 4, 5, 2, 3 ));
        assertEquals(game.show(),
                "|  B  -  -  -  -  |\n" +
                        "|  R  B  R  -  -  |\n" +
                        "|  R  B  R  B  R  |\n" +
                        "|  ^  ^  ^  ^  ^  |\n");

    }

    @Test
    public void test15CantPlayOnFullColumn(){
        game = new Linea(4, 4, 'C');
        playIn(List.of(1, 1, 1, 1 ));
        assertThrowsLike(() -> game.playRedAt(1), Linea.INVALID_COLUMN);
    }

    @Test
    public void test16RedColumnWins(){
        game = new Linea( 4, 4, 'A');
        playIn(List.of(1, 2, 1, 2, 1, 2, 1));
        assertTrue(game.finished());
        assertThrowsLike( () -> game.playBlueAt( 2 ), "R wins!");
    }
    @Test
    public void test17BlueRowWins(){
        game = new Linea( 5, 5, 'A');
        playIn(List.of(1, 2, 2, 3, 1, 5, 1, 4));
        assertTrue(game.finished());
        assertThrowsLike( () -> game.playRedAt( 3 ), "B wins!");

    }
    @Test
    public void test18DiagonalCantWinInRowsAndColsMode(){
        game = new Linea( 5, 5, 'A');
        playIn(List.of(1, 2, 2, 3, 3, 4, 3, 4, 4, 1, 4));
        assertFalse(game.finished());
    }
    @Test
    public void test19ColumnCantWinInDiagonalsMode (){
        game = new Linea( 4, 4, 'B');
        playIn(List.of(1, 2, 1, 2, 1, 2, 1));
        assertFalse(game.finished());
    }

    @Test
    public void test20RedDiagonalWins(){
        game = new Linea( 5, 5, 'B');
        playIn(List.of(1, 2, 2, 3, 3, 4, 3, 4, 4, 1, 4));
        game.show();
        assertTrue(game.finished());
    }

    @Test
    public void test21LeftDiagonalWins() {
        game = new Linea( 5, 5, 'B');
        playIn(List.of(1, 1, 1, 1, 2, 4, 2, 2, 3, 3));
        assertTrue(game.finished());
    }
    @Test
    public void test22DrawInRowsAndColsMode(){
        game = new Linea( 2, 2, 'A');
        playIn(List.of(1, 2, 1, 2));
        assertTrue(game.finished());
        assertThrowsLike( () -> game.playRedAt( 1 ), GameMode.DRAW);
    }

    @Test
    public void test23DrawInDiagonalsMode(){
        game = new Linea( 3, 3, 'B');
        playIn(List.of(1, 2, 3, 1, 2, 3, 1, 2, 3));
        assertThrowsLike( () -> game.playBlueAt( 3 ), GameMode.DRAW);
        assertTrue(game.finished());

    }

    @Test
    public void test24DrawInCompleteMode(){
        game = new Linea(4, 4, 'C');
        playIn(List.of(1, 2, 3, 4, 1, 2, 3, 4, 4, 3, 2, 1, 4, 3, 2, 1));
        assertThrowsLike( () -> game.playRedAt( 1 ), GameMode.DRAW);
    }


    private void assertThrowsLike(Executable executable, String message ) {
        assertEquals( message,
                Assertions.assertThrows( Exception.class, executable).getMessage() );
    }

    private void playIn(List<Integer> columns) {
        columns.forEach(column -> {
            if (game.itsRedsTurn()) {
                game.playRedAt(column);
            } else {
                game.playBlueAt(column);
            }
        });
    }
}

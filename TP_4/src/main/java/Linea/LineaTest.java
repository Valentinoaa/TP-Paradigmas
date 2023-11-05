package Linea;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

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
    public void test02PlayRed(){
        game = new Linea( 4, 4, 'C');

        assertEquals( 1, game.board.get( 0 ).size() );
        assertEquals( 0, game.board.get( 1 ).size() );
        assertEquals( 0, game.board.get( 2 ).size() );
        assertEquals( 0, game.board.get( 3 ).size() );
    }


}

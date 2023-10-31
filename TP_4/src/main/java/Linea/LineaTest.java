package Linea;

import org.junit.Before;
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
    public void testLinea() {
        assertEquals( 4, game.tablero.size() );
        assertEquals( 0, game.tablero.get( 0 ).size() );
        assertEquals( 0, game.tablero.get( 1 ).size() );
        assertEquals( 0, game.tablero.get( 2 ).size() );
        assertEquals( 0, game.tablero.get( 3 ).size() );
    }
}

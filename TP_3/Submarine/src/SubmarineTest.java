import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;


public class SubmarineTest {
    @Test
    public void testNewSubmarinePosition() {
        Submarine sub = new Submarine();
        assertEquals(sub.getDepth(), 0);
        assertEquals(sub.getX(), 0);
        assertEquals(sub.getY(), 0);
        assertEquals(sub.getOrientation(), 'N');
    }

    @Test
    public void testDescend() {
        Submarine sub = new Submarine();
        sub.move("D");
        assertEquals(sub.getDepth(), -1);
    }

    @Test
    public void testAscend() {
        Submarine sub = new Submarine();
        sub.move("DA");
        assertEquals(sub.getDepth(), 0);
    }


    @Test
    public void testMoveForward() {
        Submarine sub = new Submarine();
        sub.move("F");
        assertEquals(sub.getX(), 0);
        assertEquals(sub.getY(), 1);
    }
    @Test
    public void testMoveBackward() {
        Submarine sub = new Submarine();
        sub.move("B");
        assertEquals(sub.getX(), 0);
        assertEquals(sub.getY(), -1);
    }
    @Test
    public void testTurnLeft() {
        Submarine sub = new Submarine();
        sub.move("L");
        assertEquals(sub.getOrientation(), 'W');
    }

    @Test
    public void testTurnAndMoveForward() {
        Submarine sub = new Submarine();
        sub.move("LF");
        assertEquals(sub.getX(), -1);
        assertEquals(sub.getY(), 0);
    }


}

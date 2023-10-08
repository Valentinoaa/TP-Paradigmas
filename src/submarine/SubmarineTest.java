package submarine;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SubmarineTest {
    @Test public void testNewSubmarinePosition() {
        Submarine sub = new Submarine();
        assertEquals(sub.getDepth(), 0);
        assertEquals(sub.position_x(), 0);
        assertEquals(sub.position_y(), 0);
    }

    @Test public void testOrientation() {
        Submarine sub = new Submarine();
        assertEquals(sub.getOrientation(), "N");
    }

    @Test public void testSubmarineDoesntMoveWithNoIndications() {
        Submarine sub = new Submarine();
        sub.move("");
        assertEquals(sub.position_x(), 0);
        assertEquals(sub.position_y(), 0);
    }


}

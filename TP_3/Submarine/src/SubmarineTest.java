import org.junit.Test;

import org.junit.jupiter.api.function.Executable;
import variables.coordinates.Point;
import variables.coordinates.cardinals.*;
import variables.depth.states.Deep;

import static org.junit.jupiter.api.Assertions.*;


public class SubmarineTest {
    @Test
    public void testNewSubmarinePosition() {
        Submarine sub = new Submarine();
        assertEquals(sub.getDepth(), 0);
        assertEquals(sub.getX(), 0);
        assertEquals(sub.getY(), 0);
        assertEquals(sub.getOrientation(), 'N');
        assertTrue(sub.isCapsule());
    }

    @Test
   public void test02InvalidCommand() {
      Submarine sub = new Submarine(new Point(0, 0), new North());
      sub.move("x");  // no hay error del tipo "x is not a valid command"
      assertEquals(sub.getDepth(), 0);
        assertEquals(sub.getX(), 0);
        assertEquals(sub.getY(), 0);
    }

    @Test
    public void test03SubmarineDoesntMoveWithVoidCommand(){
        Submarine sub = new Submarine(new Point(0, 0), new North());
        sub.move("");
        assertEquals(sub.getDepth(), 0);
        assertEquals(sub.getX(), 0);
        assertEquals(sub.getY(), 0);
    }

    @Test
    public void test04Descend() {
        Submarine sub = new Submarine(new Point(0, 0), new North());
        sub.move("DDDD");
        assertEquals(sub.getDepth(), -4);
    }

    @Test
    public void test05Ascend() {
        Submarine sub = new Submarine(new Point(0, 0), new North());
        sub.move("DDDDA");
        assertEquals(sub.getDepth(), -3);
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
    public void test09TurnRight() {
        Submarine sub = new Submarine(new Point(0, 0), new North());
        sub.move("R");
        assertEquals(sub.getOrientation(), 'E');
    }

    @Test
    public void test10ReleaseCapsule(){
        Submarine sub = new Submarine(new Point(0, 0), new North());
        sub.move("M");
        assertFalse(sub.isCapsule());
    }


    @Test
    public void testTurnAndMoveForward() {
        Submarine sub = new Submarine();
        sub.move("LF");
        assertEquals(sub.getX(), -1);
        assertEquals(sub.getY(), 0);
    }

    @Test
    public void test360DegreesTurn() {
        Submarine sub = new Submarine();
        sub.move("LLLLRL");
        assertEquals(sub.getOrientation(), 'N');
    }


    @Test
    public void test13CantReleaseCapsule() {
        Submarine sub = new Submarine(new Point(0, 0), new North());
        sub.move("DDDD");
        assertThrowsLike(() -> sub.move("M") , Deep.cannotReleaseCapsuleFromDeepState);
    }

    private void assertThrowsLike( Executable executable, String message ) {

        assertEquals( message,
                assertThrows( Exception.class, executable).getMessage() );
    }

}

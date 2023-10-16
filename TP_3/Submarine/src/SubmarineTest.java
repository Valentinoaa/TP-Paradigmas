import org.junit.Test;

import org.junit.jupiter.api.function.Executable;
import variables.coordinates.Point;
import variables.coordinates.cardinals.*;
import variables.depth.states.Deep;

import static org.junit.jupiter.api.Assertions.*;


public class SubmarineTest {
    @Test
    public void test01NewSubmarinePosition() {
        Submarine sub = new Submarine(new Point(1, 1), new North());
        assertEquals(sub.getDepth(), 0);
        assertEquals(sub.getX(), 1);
        assertEquals(sub.getY(), 1);
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
    public void test06MoveForward() {
        Submarine sub = new Submarine(new Point(0, 0), new North());
        sub.move("F");
        assertEquals(sub.getX(), 0);
        assertEquals(sub.getY(), 1);
    }
    @Test
    public void test07MoveBackward() {
        Submarine sub = new Submarine(new Point(0, 0), new North());
        sub.move("B");
        assertEquals(sub.getX(), 0);
        assertEquals(sub.getY(), -1);
    }
    @Test
    public void test08TurnLeft() {
        Submarine sub = new Submarine(new Point(0, 0), new North());
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
    public void test11TurnAndMoveForward() {
        Submarine sub = new Submarine(new Point(0, 0), new North());
        sub.move("LF");
        assertEquals(sub.getX(), -1);
        assertEquals(sub.getY(), 0);
    }

    @Test
    public void test12SubmarineTurns360Degrees() {
        Submarine sub = new Submarine(new Point(0, 0), new North());
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

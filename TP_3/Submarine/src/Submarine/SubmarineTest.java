package Submarine;

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
        assertTrue(sub.getPoint().equals(new Point(1, 1)));
        assertEquals(sub.getOrientation(), 'N');
    }

    @Test
   public void test02InvalidCommand() {
      Submarine sub = submarineAtOriginFacingNorth();
      assertEquals(sub.getDepth(), 0);
      assertTrue(sub.getPoint().equals(new Point(0, 0)));
      assertEquals(sub.getOrientation(), 'N');
    }

    @Test
    public void test03SubmarineDoesntMoveWithVoidCommand(){
        Submarine sub = submarineAtOriginFacingNorth();
        sub.move("");
        assertEquals(sub.getDepth(), 0);
        assertTrue(sub.getPoint().equals(new Point(0, 0)));
        assertEquals(sub.getOrientation(), 'N');
    }

    @Test
    public void test04Descend() {
        Submarine sub = submarineAtOriginFacingNorth();
        sub.move("DDDD");
        assertEquals(sub.getDepth(), -4);
    }

    @Test
    public void test05Ascend() {
        Submarine sub = submarineAtOriginFacingNorth();
        sub.move("DDDDA");
        assertEquals(sub.getDepth(), -3);
    }


    @Test
    public void test06MoveForward() {
        Submarine sub = submarineAtOriginFacingNorth();
        sub.move("F");
        assertTrue(sub.getPoint().equals(new Point(0, 1)));

    }

    @Test
    public void test07SubmarineCanReleaseCapsuleAtSurface() {
        Submarine sub = submarineAtOriginFacingNorth();
        sub.move("M");
    }

    @Test
    public void test08TurnLeft() {
        Submarine sub = submarineAtOriginFacingNorth();
        sub.move("L");
        assertEquals(sub.getOrientation(), 'W');
    }

    @Test
    public void test09TurnRight() {
        Submarine sub = submarineAtOriginFacingNorth();
        sub.move("R");
        assertEquals(sub.getOrientation(), 'E');
    }

    @Test
    public void test10TurnAndMoveForward() {
        Submarine sub = submarineAtOriginFacingNorth();
        sub.move("LF");
        assertTrue(sub.getPoint().equals(new Point(-1, 0)));

    }

    @Test
    public void test11SubmarineTurns360Degrees() {
        Submarine sub = submarineAtOriginFacingNorth();
        sub.move("LLLLRL");
        assertEquals(sub.getOrientation(), 'N');
    }


    @Test
    public void test12CantReleaseCapsule() {
        Submarine sub = submarineAtOriginFacingNorth();
        sub.move("DDDD");
        assertThrowsLike(() -> sub.move("M"));
    }

    @Test
    public void test13SubmarineMovesRightWhenFacingEast() {
        Submarine sub = new Submarine(new Point(0, 0), new East());
        sub.move("F");
        assertTrue(sub.getPoint().equals(new Point(1, 0)));

    }

    @Test
    public void test14SubmarineMovesLeftWhenFacingWest() {
        Submarine sub = new Submarine(new Point(0, 0), new West());
        sub.move("F");
        assertTrue(sub.getPoint().equals(new Point(-1, 0)));

    }

    @Test
    public void test15SubmarineMovesBackwardWhenFacingSouth() {
        Submarine sub = new Submarine(new Point(0, 0), new South());
        sub.move("F");
        assertTrue(sub.getPoint().equals(new Point(0, -1)));

    }

    @Test
    public void test16SubmarineCanReleaseCapsuleAtShallowDepth() {
        Submarine sub = submarineAtOriginFacingNorth();
        sub.move("DM");
        assertEquals(sub.getDepth(), -1);
        assertTrue(sub.getPoint().equals(new Point(0, 0)));
        assertEquals(sub.getOrientation(), 'N');
    }

    private void assertThrowsLike( Executable executable ) {

        assertEquals(Deep.cannotReleaseCapsuleFromDeepState,
                assertThrows( Exception.class, executable).getMessage() );
    }

    private static Submarine submarineAtOriginFacingNorth() {
        return new Submarine(new Point(0, 0), new North());
    }

}

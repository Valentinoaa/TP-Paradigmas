package Submarine;

import org.junit.Before;
import org.junit.Test;

import org.junit.jupiter.api.function.Executable;
import variables.coordinates.Coordinates;
import variables.coordinates.Point;
import variables.coordinates.cardinals.Cardinal;
import variables.coordinates.cardinals.East;
import variables.coordinates.cardinals.North;
import variables.coordinates.cardinals.South;
import variables.coordinates.cardinals.West;
import variables.depth.states.Deep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SubmarineTest {

    Submarine sub;
    @Before
    public void SetUp(){
        sub = submarineAtOriginFacingNorth();
    }

    @Test
    public void test01NewSubmarinePosition() {
        sub = new Submarine(new Point(3, 2), new South());
        isSubmarineAt(new Point(3, 2), new South(), 0);
    }

    @Test
   public void test02InvalidCommand() {
        sub.move("x");  // no hay error del tipo "x is not a valid command"
        isSubmarineAt(new Point(0, 0), new North(), 0);
    }

    @Test
    public void test03SubmarineDoesntMoveWithVoidCommand(){
        sub.move("");
        isSubmarineAt(new Point(0, 0), new North(), 0);
    }

    @Test
    public void test04Descend() {
        sub.move("DDDD");
        isSubmarineAt(new Point(0, 0), new North(), -4);
    }

    @Test
    public void test05Ascend() {
        sub.move("DDDDA");
        isSubmarineAt(new Point(0, 0), new North(), -3);
    }


    @Test
    public void test06MoveForward() {
        sub.move("F");
        isSubmarineAt(new Point(0, 1), new North(), 0);
    }

    @Test
    public void test07SubmarineCanReleaseCapsuleAtSurface() {
        sub.move("M");
        isSubmarineAt(new Point(0, 0), new North(), 0);
    }

    @Test
    public void test08TurnLeft() {
        sub.move("L");
        isSubmarineAt(new Point(0, 0), new West(), 0);
    }

    @Test
    public void test09TurnRight() {
        sub.move("R");
        isSubmarineAt(new Point(0, 0), new East(), 0);
    }

    @Test
    public void test10TurnAndMoveForward() {
        sub.move("LF");
        isSubmarineAt(new Point(-1, 0), new West(), 0);
    }

    @Test
    public void test11SubmarineTurns360Degrees() {
        sub.move("LLLLRL");
        isSubmarineAt(new Point(0, 0), new North(), 0);
    }


    @Test
    public void test12CantReleaseCapsule() {
        sub.move("DDDD");
        assertThrowsLike(() -> sub.move("M"), Deep.cannotReleaseCapsuleFromDeepState);
        isSubmarineAt(new Point(0, 0), new North(), -4);
    }

    @Test
    public void test13SubmarineMovesRightWhenFacingEast() {
        sub = new Submarine(new Point(0, 0), new East());
        sub.move("F");
        isSubmarineAt(new Point(1, 0), new East(), 0);
    }

    @Test
    public void test14SubmarineMovesLeftWhenFacingWest() {
        sub = new Submarine(new Point(0, 0), new West());
        sub.move("F");
        isSubmarineAt(new Point(-1, 0), new West(), 0);
    }

    @Test
    public void test15SubmarineMovesBackwardWhenFacingSouth() {
        sub = new Submarine(new Point(0, 0), new South());
        sub.move("F");
        isSubmarineAt(new Point(0, -1), new South(), 0);
    }

    @Test
    public void test16SubmarineCanReleaseCapsuleAtShallowDepth() {
        sub.move("DM");
        isSubmarineAt(new Point(0, 0), new North(), -1);
    }

    @Test
    public void test17CommandsAreNotCaseSensitive(){
        sub.move("fF");
        isSubmarineAt(new Point(0, 2), new North(), 0);
    }

    @Test
    public void test18SubmarineCantGoFurtherThanDepthZero(){
        sub.move("aaaaaaaaaaa");
        isSubmarineAt(new Point(0, 0), new North(), 0);
    }

    @Test
    public void test19SubmarineCanRecieveCommandsInChar(){
        sub.move('d');
        isSubmarineAt(new Point(0, 0), new North(), -1);
    }

    private void assertThrowsLike( Executable executable, String message ) {

        assertEquals( message,
                assertThrows( Exception.class, executable).getMessage() );
    }

    private Submarine submarineAtOriginFacingNorth() {
        return new Submarine(new Point(0, 0), new North());
    }

    private void isSubmarineAt(Point point, Cardinal cardinal, int depth) {
        assertTrue(sub.areCoordinatesEqual(new Coordinates(point, cardinal), depth));
    }

}
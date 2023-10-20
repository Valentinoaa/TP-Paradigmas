package Submarine;

import org.junit.Before;
import org.junit.Test;

import org.junit.jupiter.api.function.Executable;
import variables.position.Position;
import variables.position.Point;
import variables.position.cardinals.Cardinal;
import variables.position.cardinals.East;
import variables.position.cardinals.North;
import variables.position.cardinals.South;
import variables.position.cardinals.West;
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
        sub.move("dddd");
        isSubmarineAt(new Point(0, 0), new North(), -4);
    }

    @Test
    public void test05Ascend() {
        sub.move("dddda");
        isSubmarineAt(new Point(0, 0), new North(), -3);
    }


    @Test
    public void test06MoveForward() {
        sub.move("f");
        isSubmarineAt(new Point(0, 1), new North(), 0);
    }

    @Test
    public void test07SubmarineCanReleaseCapsuleAtSurface() {
        sub.move("m");
        isSubmarineAt(new Point(0, 0), new North(), 0);
    }

    @Test
    public void test08TurnLeft() {
        sub.move("l");
        isSubmarineAt(new Point(0, 0), new West(), 0);
    }

    @Test
    public void test09TurnRight() {
        sub.move("r");
        isSubmarineAt(new Point(0, 0), new East(), 0);
    }

    @Test
    public void test10TurnAndMoveForward() {
        sub.move("lf");
        isSubmarineAt(new Point(-1, 0), new West(), 0);
    }

    @Test
    public void test11SubmarineTurns360Degrees() {
        sub.move("llllrl");
        isSubmarineAt(new Point(0, 0), new North(), 0);
    }


    @Test
    public void test12CantReleaseCapsule() {
        sub.move("dddd");
        assertThrowsLike(() -> sub.move("m"), Deep.cannotReleaseCapsuleFromDeepState);
        isSubmarineAt(new Point(0, 0), new North(), -4);
    }

    @Test
    public void test13SubmarineMovesRightWhenFacingEast() {
        sub = new Submarine(new Point(0, 0), new East());
        sub.move("f");
        isSubmarineAt(new Point(1, 0), new East(), 0);
    }

    @Test
    public void test14SubmarineMovesLeftWhenFacingWest() {
        sub = new Submarine(new Point(0, 0), new West());
        sub.move("f");
        isSubmarineAt(new Point(-1, 0), new West(), 0);
    }

    @Test
    public void test15SubmarineMovesBackwardWhenFacingSouth() {
        sub = new Submarine(new Point(0, 0), new South());
        sub.move("f");
        isSubmarineAt(new Point(0, -1), new South(), 0);
    }

    @Test
    public void test16SubmarineCanReleaseCapsuleAtShallowDepth() {
        sub.move("dm");
        isSubmarineAt(new Point(0, 0), new North(), -1);
    }

    @Test
    public void test17SubmarineCantGoFurtherThanDepthZero(){
        sub.move("aaaaaaaaaaa");
        isSubmarineAt(new Point(0, 0), new North(), 0);
    }

    @Test
    public void test18SubmarineCanRecieveCommandsInChar(){
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
        assertTrue(sub.areCoordinatesEqual(new Position(point, cardinal), depth));
    }

}

package Submarine;

import variables.coordinates.Coordinates;
import variables.coordinates.Point;
import variables.coordinates.cardinals.Cardinal;
import variables.depth.DepthState;
import variables.depth.states.Surface;
import commands.Commands;

public class Submarine {
    private DepthState z = new Surface();
    private Coordinates coords;

    public Submarine(Point point, Cardinal cardinal) {
        coords = new Coordinates(point, cardinal);
    }

//    public int getDepth() {
//        return z.getDepth();
//    }
//
//    public int getX() {
//        return coords.getX();
//    }
//
//    public int getY() {
//        return coords.getY();
//    }
//
//    public char getOrientation(){
//        return coords.getOrientation();
//    }

    public void move(Character direction){
        this.move(direction.toString());
    }
    public void move(String directions){
        directions.chars()
                .forEach(direction -> {
                    char directionChar = (char) direction;
                    Commands.availableCommands.stream()
                            .filter(command -> command.equalsType(directionChar))
                            .forEach(command -> command.runAction(this));

        });
    }

    public boolean areCoordinatesEqual(Coordinates coordinates, Integer depth){
        return this.coords.areCoordinatesEqual(coordinates) && this.z.getDepth() == depth;
    }


    public void descend(){
        z = z.descend();
    }

    public void ascend(){
        z = z.ascend();
    }

    public void forward(){
        coords.forward();
    }

    public void right(){
        coords.right();
    }

    public void left(){
        coords.left();
    }

    public void releaseCapsule(){
        z.releaseCapsule();
    }

}

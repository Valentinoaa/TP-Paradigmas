package Submarine;

import variables.coordinates.*;
import variables.coordinates.cardinals.Cardinal;
import variables.depth.DepthState;
import variables.depth.states.Surface;
import commands.Commands;

public class Submarine {
    public DepthState z = new Surface();
    public Coordinates coords;

    public Submarine(Point point, Cardinal cardinal) {
        coords = new Coordinates(point, cardinal);
    }

    public int getDepth() {
        return z.getDepth();
    }

    public int getX() {
        return coords.getX();
    }

    public int getY() {
        return coords.getY();
    }

    public char getOrientation(){
        return coords.getOrientation();
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

}

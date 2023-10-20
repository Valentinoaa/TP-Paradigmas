package Submarine;

import variables.position.Position;
import variables.position.Point;
import variables.position.cardinals.Cardinal;
import variables.depth.DepthState;
import variables.depth.states.Surface;
import commands.Commands;

public class Submarine {
    private DepthState z = new Surface();
    private Position position;

    public Submarine(Point point, Cardinal cardinal) {
        position = new Position(point, cardinal);
    }

    public void move(String instructions){
        instructions.chars().forEach(instruction -> this.move((char) instruction));
    }

    public void move(char instruction){
        Commands.commandFor(instruction).forEach(commands -> commands.runAction(this));
    }

    public boolean areCoordinatesEqual(Position position, Integer depth){
        return this.position.areCoordinatesEqual(position) && this.z.getDepth() == depth;
    }

    public void descend(){
        z = z.descend();
    }

    public void ascend(){
        z = z.ascend();
    }

    public void forward(){
        position.Forward();
    }

    public void right(){
        position.Right();
    }

    public void left(){
        position.Left();
    }

    public void releaseCapsule(){
        z.releaseCapsule();
    }


}

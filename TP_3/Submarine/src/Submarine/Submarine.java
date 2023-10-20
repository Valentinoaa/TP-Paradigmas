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

    public Point getPoint() {
        return coords.axis;
    }

    public char getOrientation(){
        return coords.getOrientation();
    }

    public void move(String instructions){
        instructions.chars().forEach(instruction -> this.move((char) instruction));
    }

    public void move(char instruction){
        Commands.commandFor(instruction).runAction(this);
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

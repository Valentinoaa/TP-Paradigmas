package Submarine;

public class Submarine {
    private DepthState depth = new Surface();
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
        return position.coordinatesEquals(position) && this.depth.getDepth() == depth;
    }

    public void descend(){
        depth = depth.descend();
    }

    public void ascend(){
        depth = depth.ascend();
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
        depth.releaseCapsule();
    }


}

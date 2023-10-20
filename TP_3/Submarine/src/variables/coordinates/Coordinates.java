package variables.coordinates;

import variables.coordinates.cardinals.Cardinal;

public class Coordinates {
    public Point axis;
    public Cardinal orientation;

    public Coordinates(Point point, Cardinal cardinal){
        axis = point;
        this.orientation = cardinal;

    }

    public Point getPoint() {
        return axis;
    }
    public char getOrientation(){
        return orientation.toChar();
    }

    public void forward(){
        axis.add(orientation.forward());
    }

    public void left(){
        orientation = orientation.left();
    }

    public void right(){
        orientation = orientation.right();
    }



}

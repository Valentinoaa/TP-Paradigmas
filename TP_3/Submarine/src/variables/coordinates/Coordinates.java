package variables.coordinates;

import variables.coordinates.cardinals.Cardinal;

public class Coordinates {
    public Point axis;
    public Cardinal orientation;

    public Coordinates(Point point, Cardinal cardinal){
        axis = point;
        this.orientation = cardinal;

    }

    public int getX(){
        return axis.getX();
    }

    public int getY(){
        return axis.getY();
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

    public boolean areCoordinatesEqual(Coordinates coordinates){
        return this.axis.equals(coordinates.axis) && this.orientation.equals(coordinates.orientation);
    }



}

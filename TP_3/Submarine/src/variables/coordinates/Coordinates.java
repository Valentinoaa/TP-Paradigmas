package variables.coordinates;

import variables.coordinates.cardinals.Cardinal;

public class Coordinates {
    public Point axis;
    public Orientation compass = new Orientation();

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

    public void Forward(){
        axis.add(orientation.forward());
    }

    public void Backward(){
        axis.add(orientation.backward());
    }

    public void Left(){
        orientation = orientation.previous();
    }

    public void Right(){
        orientation = orientation.next();
    }



}

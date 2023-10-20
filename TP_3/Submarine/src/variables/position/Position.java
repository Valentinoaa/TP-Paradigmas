package variables.position;

import variables.position.cardinals.Cardinal;

public class Position {
    public Point axis;
    public Cardinal orientation;

    public Position(Point point, Cardinal cardinal){
        axis = point;
        this.orientation = cardinal;

    }

    public void Forward(){
        axis.add(orientation.forward());
    }

    public void Left(){
        orientation = orientation.previous();
    }

    public void Right(){
        orientation = orientation.next();
    }

    public boolean areCoordinatesEqual(Position position){
        return this.axis.equals(position.axis) && this.orientation.equals(position.orientation);
    }



}

package variables.axis;

import variables.axis.cardinals.Cardinal;

public class Coordinates {
    public Point axis;
    public Orientation compass = new Orientation();

    public Coordinates(){
        axis = new Point(0, 0);
    }

    public int getX(){
        return axis.getX();
    }

    public int getY(){
        return axis.getY();
    }

    public char getOrientation(){
        return compass.getOrientation();
    }

    public void Forward(){
        axis.add(compass.forward());
    }

    public void Backward(){
        axis.add(compass.backward());
    }

    public void Left(){
        compass.turnLeft();
    }

    public void Right(){
        compass.turnRight();
    }



}

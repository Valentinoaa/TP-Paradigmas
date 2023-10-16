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

    public void Forward(){
        if (compass.getOrientation() == 'N'){
            axis.add(new Point(0, 1));
        }
        else if (compass.getOrientation() == 'E'){
            axis.add(new Point(1, 0));
        }
        else if (compass.getOrientation() == 'S'){
            axis.add(new Point(0, -1));
        }
        else if (compass.getOrientation() == 'W'){
            axis.add(new Point(-1, 0));
        }
    }

    public void Backward(){
        if (compass.getOrientation() == 'N'){
            axis.add(new Point(0, -1));
        }
        else if (compass.getOrientation() == 'E'){
            axis.add(new Point(-1, 0));
        }
        else if (compass.getOrientation() == 'S'){
            axis.add(new Point(0, 1));
        }
        else if (compass.getOrientation() == 'W'){
            axis.add(new Point(1, 0));
        }
    }

    public void Left(){
        compass.turnLeft();
    }



}

package variables.axis;
import variables.axis.cardinals.*;

public class Orientation {
    public Cardinal direction;

    public Orientation() {
        direction = new North();
    }

    public char getOrientation(){
        return direction.toChar();
    }

    public void turnLeft(){
        direction = direction.previous();
    }

    public void turnRight(){
        direction = direction.next();
    }

    public Point forward() { return direction.forward();
    }

    public Point backward() { return direction.backward();
    }
}

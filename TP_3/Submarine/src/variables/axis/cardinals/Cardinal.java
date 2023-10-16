package variables.axis.cardinals;
import variables.axis.Point;
public abstract class Cardinal {

    public abstract Cardinal previous();
    public abstract Cardinal next();
    public abstract char toChar();
    public abstract Point forward();
    public abstract Point backward();



}

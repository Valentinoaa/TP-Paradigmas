package variables.coordinates.cardinals;
import variables.coordinates.Point;
public abstract class Cardinal {

    public abstract Cardinal left();
    public abstract Cardinal right();
    public abstract char toChar();
    public abstract Point forward();
    public boolean equals(Cardinal cardinal){
        return this.toChar() == cardinal.toChar();
    }



}

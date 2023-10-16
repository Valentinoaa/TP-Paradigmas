package variables.axis.cardinals;

public abstract class Cardinal {

    public abstract Cardinal previous();
    public abstract Cardinal next();

    public abstract char toChar();

}

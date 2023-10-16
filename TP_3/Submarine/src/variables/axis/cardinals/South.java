package variables.axis.cardinals;

public class South extends Cardinal{
    @Override
    public Cardinal previous() {
        return new East();
    }

    @Override
    public Cardinal next() {
        return new West();
    }

    @Override
    public char toChar() {
        return 'S';
    }
}

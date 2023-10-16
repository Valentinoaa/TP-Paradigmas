package variables.axis.cardinals;

public class North extends Cardinal {
    public Cardinal previous() {
        return new West();
    }
    public Cardinal next() {
        return new East();
    }

    @Override
    public char toChar() {
        return 'N';
    }

}

package variables.axis.cardinals;

public class East extends Cardinal{
    @Override
    public Cardinal previous() {
        return new North();
    }

    @Override
    public Cardinal next() {
        return new South();
    }

    @Override
    public char toChar() {
        return 'E';
    }
}

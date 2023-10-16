package variables.axis.cardinals;

public class West extends Cardinal {
    @Override
    public Cardinal previous() {
        return new South();
    }

    @Override
    public Cardinal next() {
        return new North();
    }

    @Override
    public char toChar() {
        return 'W';
    }


}

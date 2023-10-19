package variables.coordinates.cardinals;

import variables.coordinates.Point;

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

    @Override
    public Point forward() {
        return new Point(-1, 0);
    }

}

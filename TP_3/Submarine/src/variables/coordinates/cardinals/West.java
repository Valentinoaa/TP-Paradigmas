package variables.coordinates.cardinals;

import variables.coordinates.Point;

public class West extends Cardinal {
    @Override
    public Cardinal left() {
        return new South();
    }

    @Override
    public Cardinal right() {
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

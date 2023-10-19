package variables.coordinates.cardinals;

import variables.coordinates.Point;

public class East extends Cardinal{
    @Override
    public Cardinal left() {
        return new North();
    }

    @Override
    public Cardinal right() {
        return new South();
    }

    @Override
    public char toChar() {
        return 'E';
    }

    @Override
    public Point forward() {
        return new Point(1, 0);
    }
}

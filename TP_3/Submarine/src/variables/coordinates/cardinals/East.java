package variables.coordinates.cardinals;

import variables.coordinates.Point;

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

    @Override
    public Point forward() {
        return new Point(1, 0);
    }

    @Override
    public Point backward() {
        return new Point(-1, 0);
    }
}

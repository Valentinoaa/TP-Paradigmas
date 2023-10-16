package variables.coordinates.cardinals;

import variables.coordinates.Point;

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

    @Override
    public Point forward() {
        return new Point(0, -1);
    }

    @Override
    public Point backward() {
        return new Point(0, 1);
    }
}

package variables.coordinates.cardinals;

import variables.coordinates.Point;

public class South extends Cardinal{
    @Override
    public Cardinal left() {
        return new East();
    }

    @Override
    public Cardinal right() {
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
}

package variables.coordinates.cardinals;

import variables.coordinates.Point;

public class North extends Cardinal {
    public Cardinal left() {
        return new West();
    }

    public Cardinal right() {
        return new East();
    }

    @Override
    public char toChar() {
        return 'N';
    }

    @Override
    public Point forward() {
        return new Point(0, 1);
    }

}

package variables.axis.cardinals;

import variables.axis.Point;

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

    @Override
    public Point forward() {
        return new Point(0, 1);
    }

    @Override
    public Point backward() {
        return new Point(0, -1);
    }

}

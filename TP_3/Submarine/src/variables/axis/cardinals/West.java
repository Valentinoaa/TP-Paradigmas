package variables.axis.cardinals;

import variables.axis.Point;

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

    @Override
    public Point backward() {
        return new Point(1, 0);
    }


}

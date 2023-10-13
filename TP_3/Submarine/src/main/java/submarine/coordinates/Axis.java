package submarine.coordinates;

public class Axis {
    public int x;
    public int y;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }

}

package variables.coordinates;

public class Point {
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public boolean equals(Point p){
        return this.x == p.getX() && this.y == p.getY();
    }

    public void add(Point p){
        this.x += p.getX();
        this.y += p.getY();
    }
}

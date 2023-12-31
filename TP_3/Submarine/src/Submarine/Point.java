package Submarine;

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

    public void add(Point p){
        this.x += p.getX();
        this.y += p.getY();
    }

    public boolean equals(Point point){
        return x == point.getX() && y == point.getY();
    }
}

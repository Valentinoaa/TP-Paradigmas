package submarine;

public class Submarine {

    public Coordinates coordinates;
    public Orientation orientation;

    public Submarine() {
        coordinates = new Coordinates();
    }

    public int getDepth() {
        return coordinates.getZ();
    }

    public int position_x() {
        return coordinates.getX();
    }

    public int position_y() {
        return coordinates.getY();
    }

    public String getOrientation(){
        return orientation;
    }

    public void move(String directions){
        if (directions.isEmpty()) {
            return;
        }
        for (int i = 0; i < directions.length(); i++) {
            char direction = directions.charAt(i);
            if (direction == 'L') {
                turnLeft();
            } else if (direction == 'R') {
                turnRight();
            } else if (direction == 'U') {
                moveUp();
            } else if (direction == 'D') {
                moveDown();
            } else if (direction == 'F') {
                moveForward();
            } else if (direction == 'B') {
                moveBackward();
            } else {
                throw new IllegalArgumentException("Invalid direction");
            }
        }
    }





}

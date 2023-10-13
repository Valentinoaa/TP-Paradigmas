package submarine;
import submarine.coordinates.Axis;
import submarine.coordinates.Orientation;
import submarine.movement.Commands;

public class Submarine {

    public Axis axis;
    public Orientation orientation;

    public Commands commands;


    public Submarine() {
        axis = new Axis();
        orientation = new Orientation();
    }

    public int position_x() {
        return axis.getX();
    }

    public int position_y() {
        return axis.getY();
    }

    public char getOrientation() {
        return orientation.getGPS();
    }

    public void move(String directions){
        if (directions.isEmpty()) {
            return;
        }
        for (int i = 0; i < directions.length(); i++) {
            char direction = directions.charAt(i);
            commands.availableCommands
                    .stream()
                    .filter(command -> command.equalsType(direction))
                    .forEach(command -> command.move());
        }
    }





}

import variables.axis.*;
import variables.depth.Depth;
import commands.*;
import java.util.ArrayList;

public class Submarine {
    public Depth z = new Depth();
    public Coordinates coords = new Coordinates();
    public ArrayList<Runnable> actions = new ArrayList<>();
    public ArrayList<Commands> availableCommands = new ArrayList<>();


    public Submarine() {
        actions.add(() -> z.descend());
        actions.add(() -> z.ascend());
        actions.add(() -> coords.Forward());
        actions.add(() -> coords.Backward());
        actions.add(() -> coords.Left());
        availableCommands.add(new Descend());
        availableCommands.add(new Ascend());
        availableCommands.add(new Forward());
        availableCommands.add(new Backward());
        availableCommands.add(new Left());
    }


    public int getDepth() {
        return z.getDepth();
    }

    public int getX() {
        return coords.getX();
    }

    public int getY() {
        return coords.getY();
    }

    public char getOrientation(){
        return coords.compass.getOrientation();
    }

    public void move(String directions){

        if (directions.isEmpty()) {
            return;
        }
        for (int i = 0; i < directions.length(); i++) {
            char direction = directions.charAt(i);

            availableCommands
                    .stream()
                    .filter(command -> command.equalsType(direction))
                    .forEach(command -> actions.get(availableCommands.indexOf(command)).run());
        }
    }




}

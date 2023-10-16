import variables.axis.*;
import variables.capsule.*;
import variables.depth.Depth;
import commands.*;
import java.util.ArrayList;

public class Submarine {
    public Depth z = new Depth();
    public Coordinates coords = new Coordinates();
    public Capsule capsule = new Capsule();
    public ArrayList<Runnable> actions = new ArrayList<>();
    public ArrayList<Commands> availableCommands = new ArrayList<>();


    public Submarine() {
        actions.add(() -> z.descend());
        actions.add(() -> z.ascend());
        actions.add(() -> coords.Forward());
        actions.add(() -> coords.Backward());
        actions.add(() -> coords.Left());
        actions.add(() -> coords.Right());
        actions.add(() -> capsule.release());
        availableCommands.add(new Descend());
        availableCommands.add(new Ascend());
        availableCommands.add(new Forward());
        availableCommands.add(new Backward());
        availableCommands.add(new Left());
        availableCommands.add(new Right());
        availableCommands.add(new ReleaseCapsule());

    }

    public boolean isCapsule(){
        return capsule.value;
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
        return coords.getOrientation();
    }

    public void move(String directions){

        for (int i = 0; i < directions.length(); i++) {
            char direction = directions.charAt(i);

            availableCommands
                    .stream()
                    .filter(command -> command.equalsType(direction))
                    .forEach(command -> actions.get(availableCommands.indexOf(command)).run());
        }
    }




}

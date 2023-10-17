import variables.coordinates.*;
import variables.capsule.*;
import variables.coordinates.cardinals.Cardinal;
import variables.depth.DepthState;
import commands.*;
import variables.depth.states.Surface;

import java.util.ArrayList;

public class Submarine {
    public DepthState z = new Surface();
    public Coordinates coords;
    public Capsule capsule = new Capsule();
    public ArrayList<Runnable> actions = new ArrayList<>();
    public ArrayList<Commands> availableCommands = new ArrayList<>();


    public Submarine(Point point, Cardinal cardinal) {
        coords = new Coordinates(point, cardinal);

        actions.add(() -> z = z.descend());
        actions.add(() -> z = z.ascend());
        actions.add(() -> coords.Forward());
        actions.add(() -> coords.Left());
        actions.add(() -> coords.Right());
        // Dudoso 🤔🤔🤔 👇
        actions.add(() -> z.releaseCapsule());
        availableCommands.add(new Descend());
        availableCommands.add(new Ascend());
        availableCommands.add(new Forward());
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
        directions.chars()
                .forEach(direction -> {
                    char directionChar = (char) direction;
                    availableCommands.stream()
                            .filter(command -> command.equalsType(directionChar))
                            .forEach(command -> actions.get(availableCommands.indexOf(command)).run());
        });
    }

}

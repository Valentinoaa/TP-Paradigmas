package commands;

import Submarine.Submarine;
import java.util.Arrays;
import java.util.List;

public abstract class Commands {

    public static List<Commands> availableCommands = Arrays.asList(
            new Ascend(),
            new Descend(),
            new Forward(),
            new Left(),
            new Right(),
            new ReleaseCapsule());

    public static Commands commandFor(Character instruction){
        return availableCommands.stream()
                .filter(command -> command.equalsType(instruction))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid command"));
    }
    char type;
    public boolean equalsType(char instruction){
        return type == instruction;
    }

    public abstract void runAction(Submarine submarine);


}

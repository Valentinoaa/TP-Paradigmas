package Submarine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public abstract class Commands {

    public static List<Commands> availableCommands = Arrays.asList(
            new Ascend(),
            new Descend(),
            new Forward(),
            new Left(),
            new Right(),
            new ReleaseCapsule());

    public static Stream<Commands> commandFor(Character instruction){
        return availableCommands.stream()
                .filter(command -> command.equalsType(instruction));

    }

    public abstract boolean equalsType(char instruction);

    public abstract void runAction(Submarine submarine);


}
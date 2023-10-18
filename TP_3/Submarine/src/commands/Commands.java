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


    public abstract boolean equalsType(char instruction);

    public abstract void runAction(Submarine submarine);


}

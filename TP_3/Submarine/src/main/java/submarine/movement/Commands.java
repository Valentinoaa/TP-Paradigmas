package submarine.movement;
import java.util.ArrayList;

public abstract class Commands {
    public abstract boolean equalsType(char direction);
    public abstract void move();
    public ArrayList<Commands> availableCommands = new ArrayList<Commands>(){{
        add(new Forward());
    }};


}

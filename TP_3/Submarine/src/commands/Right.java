package commands;

import Submarine.Submarine;

public class Right extends Commands{
    @Override
    public boolean equalsType(char instruction) {
        return instruction == 'R';
    }

    @Override
    public void runAction(Submarine submarine){
        submarine.right();
    }
}

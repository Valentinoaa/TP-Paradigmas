package commands;

import Submarine.Submarine;

public class Left extends Commands{

    @Override
    public boolean equalsType(char instruction) {
        return instruction == 'l';
    }

    @Override
    public void runAction(Submarine submarine){
        submarine.coords.Left();
    }
}

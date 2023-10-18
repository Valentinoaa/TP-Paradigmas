package commands;

import Submarine.Submarine;

public class Forward extends Commands{

    @Override
    public boolean equalsType(char instruction) {
        return instruction == 'F';
    }

    @Override
    public void runAction(Submarine submarine){
        submarine.coords.Forward();
    }

}

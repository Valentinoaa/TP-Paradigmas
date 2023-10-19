package commands;

import Submarine.Submarine;

public class Ascend extends Commands {

    @Override
    public boolean equalsType(char instruction) {
        return instruction == 'A';
    }

    @Override
    public void runAction(Submarine submarine){
        submarine.ascend();
    }

}

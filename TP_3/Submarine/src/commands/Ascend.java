package commands;

import Submarine.Submarine;

public class Ascend extends Commands {

    @Override
    public boolean equalsType(char instruction) {
        return instruction == 'a';
    }

    @Override
    public void runAction(Submarine submarine){
        submarine.z = submarine.z.ascend();
    }

}

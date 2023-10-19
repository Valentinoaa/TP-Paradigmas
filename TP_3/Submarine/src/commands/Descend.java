package commands;

import Submarine.Submarine;

public class Descend extends Commands{

    public boolean equalsType(char instruction){
        return instruction == 'D';
    }

    @Override
    public void runAction(Submarine submarine) {
        submarine.descend();
    }
}

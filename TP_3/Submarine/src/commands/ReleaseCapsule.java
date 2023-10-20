package commands;

import Submarine.Submarine;

public class ReleaseCapsule extends Commands{
    @Override
    public boolean equalsType(char instruction) {
        return instruction == 'm';
    }

    @Override
    public void runAction(Submarine submarine){
        submarine.releaseCapsule();
    }
}
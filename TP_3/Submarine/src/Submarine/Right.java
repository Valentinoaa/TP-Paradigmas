package Submarine;

public class Right extends Commands{
    @Override
    public boolean equalsType(char instruction) {
        return instruction == 'r';
    }

    @Override
    public void runAction(Submarine submarine){
        submarine.right();
    }
}

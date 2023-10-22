package Submarine;

public class Forward extends Commands{

    @Override
    public boolean equalsType(char instruction) {
        return instruction == 'f';
    }

    @Override
    public void runAction(Submarine submarine){
        submarine.forward();
    }

}

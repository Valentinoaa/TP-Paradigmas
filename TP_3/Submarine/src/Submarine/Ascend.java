package Submarine;

public class Ascend extends Commands {

    @Override
    public boolean equalsType(char instruction) {
        return instruction == 'a';
    }

    @Override
    public void runAction(Submarine submarine){
        submarine.ascend();
    }

}

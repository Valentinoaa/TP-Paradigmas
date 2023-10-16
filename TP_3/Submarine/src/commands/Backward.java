package commands;

public class Backward extends Commands{

    @Override
    public boolean equalsType(char instruction) {
        return instruction == 'B';
    }
}

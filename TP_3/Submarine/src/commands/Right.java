package commands;

public class Right extends Commands{
    @Override
    public boolean equalsType(char instruction) {
        return instruction == 'R';
    }
}

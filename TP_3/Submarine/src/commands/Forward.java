package commands;

public class Forward extends Commands{

    @Override
    public boolean equalsType(char instruction) {
        return instruction == 'F';
    }

}

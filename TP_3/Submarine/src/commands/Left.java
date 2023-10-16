package commands;

public class Left extends Commands{

    @Override
    public boolean equalsType(char instruction) {
        return instruction == 'L';
    }
}

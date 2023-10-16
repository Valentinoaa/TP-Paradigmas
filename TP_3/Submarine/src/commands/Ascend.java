package commands;

public class Ascend extends Commands {
    char type = 'A';

    @Override
    public boolean equalsType(char instruction) {
        return type == instruction;
    }

}

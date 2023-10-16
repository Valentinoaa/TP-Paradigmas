package commands;

public class Ascend extends Commands {

    @Override
    public boolean equalsType(char instruction) {
        return type == instruction;
    }

}

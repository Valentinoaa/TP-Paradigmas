package commands;

public class Descend extends Commands{
    char type = 'D';

    public boolean equalsType(char instruction){
        return type == instruction;
    }
}

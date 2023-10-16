package commands;

public class ReleaseCapsule extends Commands{
    @Override
    public boolean equalsType(char instruction) {
        return instruction == 'M';
    }
}

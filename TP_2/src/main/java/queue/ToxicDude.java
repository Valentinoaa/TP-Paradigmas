package queue;

public class ToxicDude extends Dude{
    @Override
    public Object take() {
        throw new Error("Queue is empty");
    }

    @Override
    public Object head() {
        return new Error("Queue is empty");
    }
    @Override
    public boolean isempty() {
        return true;
    }
    @Override
    public int Size() {
        return 0;
    }
}

//  [ Good (1), Toxic()]
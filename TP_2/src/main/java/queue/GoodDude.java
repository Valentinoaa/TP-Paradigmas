package queue;

public class GoodDude extends Dude{
    public Object info;
    public  Dude previous;

    GoodDude (Object info, Dude previous){
        this.info = info;
        this.previous = previous;
    }
    @Override
    public Object take() {
        return this.previous;
    }

    @Override
    public Object head() {
        return this.info;
    }

    @Override
    public boolean isempty() {
        return false;
    }

    @Override
    public int Size() {
        return 1 + this.previous.Size();
    }
}
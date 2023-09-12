package queue;

public class GoodDude extends Dude{
    GoodDude (Object info, Dude previous){
        this.info = info;
        this.previous = previous;
    }
    @Override
    public Dude add(Object  cargo ){
        return new GoodDude(info, previous.add(cargo));
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
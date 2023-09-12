package queue;

public abstract class Dude {

    public Dude add(Object  cargo ){
        return new GoodDude(cargo, this);
    }
    public abstract Object take();
    public abstract Object head();
    public abstract boolean isempty();
    public abstract int Size();


}

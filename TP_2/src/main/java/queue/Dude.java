package queue;

public abstract class Dude {
    public Object info;
    public  Dude previous;

    public abstract Dude add(Object cargo);
    public abstract Object take();
    public abstract Object head();
    public abstract boolean isempty();
    public abstract int Size();

}

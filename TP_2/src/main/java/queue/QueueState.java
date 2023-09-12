package queue;

public abstract class QueueState {
    public Object info;
    public QueueState previous;

    public abstract QueueState add(Object cargo);
    public abstract Object take();
    public abstract Object head();
    public abstract boolean isempty();
    public abstract int Size();

}

package queue;

public abstract class ElementState {
    public Object info;
    public ElementState previous;

    public abstract ElementState add(Object cargo);
    public abstract Object take();
    public abstract Object head();
    public abstract boolean isempty();
    public abstract int Size();

}

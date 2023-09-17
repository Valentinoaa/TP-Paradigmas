package queue;

public class NotEmptyElement extends ElementState {
    NotEmptyElement(Object info, ElementState previous){
        this.info = info;
        this.previous = previous;
    }
    @Override
    public ElementState add(Object  cargo ){
        return new NotEmptyElement(info, previous.add(cargo));
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
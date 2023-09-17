package queue;

public class EmptyElement extends ElementState {
    public static final String queueIsEmpty = "Queue is empty";

    @Override
    public ElementState add(Object  cargo ){
        return new NotEmptyElement(cargo, this);
    }
    @Override
    public Object take() {
        throwEmptyQueueError();
        return null;
    }
    @Override
    public Object head() {
        throwEmptyQueueError();
        return null;
    }
    @Override
    public boolean isempty() {
        return true;
    }
    @Override
    public int Size() {
        return 0;
    }
    private static void throwEmptyQueueError() {
        throw new Error(queueIsEmpty);
    }
}


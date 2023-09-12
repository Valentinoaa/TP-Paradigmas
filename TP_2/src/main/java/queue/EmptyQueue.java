package queue;

public class EmptyQueue extends QueueState {
    public static final String QUEUE_IS_EMPTY = "Queue is empty";
    @Override
    public QueueState add(Object  cargo ){
        return new NotEmptyQueue(cargo, this);
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

    private static void throwEmptyQueueError() {
        throw new Error(QUEUE_IS_EMPTY);
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

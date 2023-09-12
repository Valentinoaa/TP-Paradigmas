package queue;

public class ToxicDude extends Dude{
    public static final String QUEUE_IS_EMPTY = "Queue is empty";
    @Override
    public Dude add(Object  cargo ){
        return new GoodDude(cargo, this);
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

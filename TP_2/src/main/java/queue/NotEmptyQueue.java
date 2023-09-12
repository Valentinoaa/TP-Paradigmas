package queue;

public class NotEmptyQueue extends QueueState {
    NotEmptyQueue(Object info, QueueState previous){
        this.info = info;
        this.previous = previous;
    }
    @Override
    public QueueState add(Object  cargo ){
        return new NotEmptyQueue(info, previous.add(cargo));
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
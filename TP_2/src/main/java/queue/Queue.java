package queue;

public class Queue {
	public QueueState first = new EmptyQueue();

	public boolean isEmpty() {
		return first.isempty();
	}

	public Queue add( Object  cargo ) {
		first = first.add(cargo);
		return this;
	}

	public Object take() {
		Object info = first.head();
		first = (QueueState) first.take();
		return info;
	}

	public Object head() {
    	return first.head();
	}

	public int size() {
		return first.Size();
	}

}

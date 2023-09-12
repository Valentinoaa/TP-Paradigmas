package queue;

public class Queue {
	public static final String QUEUE_IS_EMPTY = "Queue is empty";
	public Dude first = new ToxicDude();

	public boolean isEmpty() {
		return first.isempty();
	}

	public Queue add( Object  cargo ) {
		first = first.add(cargo);
		return this;
	}

	public Object take() {
		Object info = first.head();
		first = (Dude) first.take();
		return info;
	}

	public Object head() {
    	return first.head();
	}

	public int size() {
		return first.Size();
	}

}

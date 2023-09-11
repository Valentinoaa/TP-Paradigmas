package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	public static final String QUEUE_IS_EMPTY = "Queue is empty";
	public List<Object> list = new ArrayList<>();

  public boolean isEmpty() {
		return list.isEmpty();
	}

	public Queue add( Object  cargo ) {
		list.add(cargo);
		return this;
	}

	public Object take() {
		checkIfCargoIsEmpty();

		return list.remove(0);
	}

	public Object head() {
		checkIfCargoIsEmpty();
    	return list.get(0);
	}

	public int size() {
		return list.size();
	}

	private void checkIfCargoIsEmpty() {
		if (list.isEmpty()) {
			throw new Error(QUEUE_IS_EMPTY);
		}
	}
}

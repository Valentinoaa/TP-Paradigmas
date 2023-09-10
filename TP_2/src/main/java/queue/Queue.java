package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {

	public List<Object> list = new ArrayList<>();

  public boolean isEmpty() {
		// TODO Auto-generated method stub

		return list.isEmpty();
	}

	public Queue add( Object  cargo ) {
		// TODO Auto-generated method stub
		list.add(cargo);
		return this;
	}

	public Object take() {
    // TODO Auto-generated method stub
		Object first = list.get(0);

		return list.get(0);
		return null;
	}

	public Object head() {
		// TODO Auto-generated method stub
		list.
    return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}

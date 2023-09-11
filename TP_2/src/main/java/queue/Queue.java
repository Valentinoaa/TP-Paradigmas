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
		list.remove(0);

		return first;
	}

	public Object head() {
		// TODO Auto-generated method stub
    return list.get(0);
	}

	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

}

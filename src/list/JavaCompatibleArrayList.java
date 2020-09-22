package list;

import java.util.AbstractList;
import java.util.RandomAccess;

public class JavaCompatibleArrayList<T> extends AbstractList<T> implements RandomAccess {

	private List.ArrayList<T> list = null;

	public JavaCompatibleArrayList(List.ArrayList<T> list) {
		this.list = list;
	}

	@Override
	public boolean add(T value) {
		return list.add(value);
	}

	@Override
	public boolean remove(Object value) {
		return list.remove((T) value);
	}

	@Override
	public T get(int index) {

		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}

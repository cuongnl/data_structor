package list;

import java.util.Arrays;
import java.util.Collection;

import interfaces.IList;

public abstract class List<T> implements IList<T> {
	
	public static class ArrayList<T> extends List<T> {
		
		private static final int MININUM_SIZE = 1024;
		
		private int size = 0;
		private T[] array = (T[]) new Object[MININUM_SIZE];

		@Override
		public boolean add(T value) {
			return ;
		}
		
		private boolean addValue(int index, T value) {
			if(size >= array.length) {
				grow();
			}
			if(index == size) {
				array[size] = value;
			}else {
				System.arraycopy(array, index, array, index+1, size-index);
				array[index] = value;
			}
			size++;
			return true;
		}
		
		private void grow() {
			int growSize = size + (size << 1);
			array = Arrays.copyOf(array, growSize);
		}

		@Override
		public boolean remove(T value) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean clear() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean contains(T value) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean validate() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public java.util.List<T> toList() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Collection<T> toCollection() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}

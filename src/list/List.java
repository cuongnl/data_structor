package list;

import java.util.Arrays;
import java.util.Collection;

import core.DataUtils;
import interfaces.IList;

public abstract class List<T> implements IList<T> {

	public static class ArrayList<T> extends List<T> {

		private static final int MININUM_SIZE = 1024;

		private int size = 0;
		private T[] array = (T[]) new Object[MININUM_SIZE];

		@Override
		public boolean add(T value) {
			return addValue(size, value);
		}

		/**
		 * add data arrayList by index
		 */
		private boolean addValue(int index, T value) {

			// handle double size
			if (size >= array.length) {
				grow();
			}

			// assign value
			if (index == size) {
				array[size] = value;
			} else {
				System.arraycopy(array, index, array, index + 1, size - index);
				array[index] = value;
			}
			size++;
			return true;
		}

		/**
		 * double size of arrayList use << operator, 50%
		 */
		private void grow() {
			int growSize = size + (size << 1);
			array = Arrays.copyOf(array, growSize);
		}

		@Override
		public boolean remove(T value) {
			T object = null;
			for (int index = 0; index < size; index++) {
				object = array[index];
				if (DataUtils.safeEqual(value, object)) {
					removeValueByIndex(index);
					return true;
				}
			}
			return false;
		}

		private void removeValueByIndex(int index) {
			if (index < 0 || index >= size) {
				return;
			}

			if (index != --size) {
				System.arraycopy(array, index + 1, array, index, size - index);
			}
			array[size] = null;

			int shrinkSize = array.length >> 1;
			if (shrinkSize >= MININUM_SIZE && size < shrinkSize) {
				shrink();
			}
		}

		private void shrink() {
			int shrinkSize = array.length;
			array = Arrays.copyOf(array, shrinkSize);
		}

		@Override
		public void clear() {
			size = 0;
		}

		@Override
		public boolean contains(T value) {
			T object = null;
			for (int index = 0; index < size; index++) {
				object = array[index];
				if (DataUtils.safeEqual(value, object)) {
					return true;
				}
			}

			return false;
		}

		@Override
		public int size() {
			return size;
		}

		@Override
		public boolean validate() {
			// TODO Auto-generated method stub
			return false;
		}

		public java.util.List<T> toList() {
			return (new JavaCompatibleArrayList<>(this));
		}

		@Override
		public Collection<T> toCollection() {
			return (new JavaCompatibleArrayList<>(this));
		}

	}
	
	public static class SimplyLinkedList<T> extends List<T>{
		private int size = 0;
		private Node<T> nodeHead = null;
		private Node<T> nodeTail = null;

		@Override
		public boolean add(T value) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean remove(T value) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
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

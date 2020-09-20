package queue;

import java.util.Collection;

import interfaces.IQueue;

@SuppressWarnings("unchecked")
public interface Queue<T> extends IQueue<T> {
	
	public static class ArrayQueue<T> implements Queue<T> {
		private static final int MINIMUM_SIZE = 1024;
		
		private T[] array = (T[]) new Object[MINIMUM_SIZE];
		
		
		@Override
		public boolean offer(T value) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T poll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public T peek() {
			// TODO Auto-generated method stub
			return null;
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
		public boolean containers(T value) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public java.util.Queue<T> toQueue() {
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

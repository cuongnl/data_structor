package interfaces;

import java.util.Collection;
import java.util.Queue;

public interface IQueue<T> {

	public boolean offer(T value);

	public T poll();

	public T peek();

	public boolean remove(T value);

	public void clear();

	public boolean containers(T value);

	public int size();

	public Queue<T> toQueue();

	public Collection<T> toCollection();
}

package interfaces;

import binarySearchTree.Node;

public interface ITree<T extends Comparable<T>> {

	public boolean add(T value);

	public T remove(T value);

	public void clear();

	public boolean container(T value);

	public int size();
}

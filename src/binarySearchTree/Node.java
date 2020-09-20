package binarySearchTree;

public class Node<T extends Comparable<T>> {

	protected T id = null;
	protected Node<T> parent = null;
	protected Node<T> lesser = null;
	protected Node<T> greater = null;

	// constructor
	protected Node(T id, Node<T> parent) {
		this.id = id;
		this.parent = parent;
	}

}

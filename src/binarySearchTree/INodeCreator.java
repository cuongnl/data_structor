package binarySearchTree;

public interface INodeCreator<T extends Comparable<T>> {
	public Node<T> createNewNode(T id, Node<T> parent);
}

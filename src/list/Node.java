package list;

public class Node<T> {
	private T value;
	private Node<T> next;

	private Node() {
	};

	private Node(T value) {
		this.value = value;
	};

}

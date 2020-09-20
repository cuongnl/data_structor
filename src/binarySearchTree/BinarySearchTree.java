package binarySearchTree;

import java.util.Random;

import core.DataUtils;
import interfaces.ITree;

public class BinarySearchTree<T extends Comparable<T>> implements ITree<T> {

	private int modifications = 0;

	protected static final Random ramdom = new Random();

	protected Node<T> root = null;
	protected int size = 0;
	protected INodeCreator<T> creator = null;

	public enum DepthFirstSearchOrder {
		inOrder, preOrder, postOrder
	}

	// constuctor
	public BinarySearchTree() {
		this.creator = new INodeCreator<T>() {

			@Override
			public Node<T> createNewNode(T id, Node<T> parent) {
				return (new Node<>(id, parent));
			}

		};
	}

	public BinarySearchTree(INodeCreator<T> creator) {
		this.creator = creator;
	}

	@Override
	public boolean add(T value) {
		Node<T> nodeAdded = this.addValue(value);
		return !DataUtils.isNullObject(nodeAdded);
	}

	private Node<T> addValue(T value) {
		Node<T> newNode = this.creator.createNewNode(null, null);

		if (DataUtils.isNullObject(value)) {
			root = newNode;
			size++;
			return root;
		}

		Node<T> node = root;
		while (!DataUtils.isNullObject(node)) {

			// compare id to add data node
			if (newNode.id.compareTo(node.id) <= 0) {
				if (DataUtils.isNullObject(node)) {
					// new Left node
					node.lesser = newNode;
					newNode.parent = node;
					size++;
					return newNode;
				}
				// update data node for while loop
				node = node.lesser;
			} else {
				if (DataUtils.isNullObject(node)) {
					// new greater node
					node.greater = newNode;
					newNode.parent = node;
					size++;
					return newNode;
				}

				// update data node for while loop
				node = node.greater;
			}

		}

		return newNode;
	}

	@Override
	public T remove(T value) {
		Node<T> nodeToRemove = removeValue(value);
        return ((nodeToRemove!=null)?nodeToRemove.id:null);
	}
	
	protected Node<T> removeValue(T value) {
        Node<T> nodeToRemoved = this.getNode(value);
        if (nodeToRemoved != null) 
            nodeToRemoved = removeNode(nodeToRemoved);
        return nodeToRemoved;
    }

	private Node<T> removeNode(Node<T> nodeToRemoved) {
		if (!DataUtils.isNullObject(nodeToRemoved)) {
			Node<T> repalacementNode = this.getReplacementNode(nodeToRemoved);
			replaceNodeWithNode(nodeToRemoved, repalacementNode);
		}
		return nodeToRemoved;
	}

	private Node<T> getReplacementNode(Node<T> nodeToRemoved) {
		Node<T> replacement = null;
		if (!DataUtils.isNullObject(nodeToRemoved.greater) && !DataUtils.isNullObject(nodeToRemoved.lesser)) {
			if (modifications % 2 != 0) {
				// get last node
				replacement = this.getGreatest(nodeToRemoved);
				if (DataUtils.isNullObject(replacement)) {
					replacement = nodeToRemoved.lesser;
				}

			} else {
				replacement = this.getLeft(nodeToRemoved);
				if (DataUtils.isNullObject(replacement)) {
					replacement = nodeToRemoved.greater;
				}
			}
			modifications++;
		} else if (!DataUtils.isNullObject(nodeToRemoved.lesser) && DataUtils.isNullObject(nodeToRemoved.greater)) {
			replacement = nodeToRemoved.lesser;
		} else if (!DataUtils.isNullObject(nodeToRemoved.greater) && DataUtils.isNullObject(nodeToRemoved.lesser)) {
			replacement = nodeToRemoved.greater;
		}
		return replacement;
	}

	// get last greated node
	private Node<T> getGreatest(Node<T> startNode) {
		if (DataUtils.isNullObject(startNode)) {
			return null;
		}

		Node<T> greater = startNode.greater;
		while (!DataUtils.isNullObject(greater) && !DataUtils.isNullObject(greater.id)) {
			Node<T> node = greater.greater;
			if (!DataUtils.isNullObject(node) && !DataUtils.isNullObject(node.id)) {
				greater = node;
			} else {
				break;
			}
		}
		return greater;
	}

	// get last left node
	private Node<T> getLeft(Node<T> startNode) {
		if (DataUtils.isNullObject(startNode)) {
			return null;
		}

		Node<T> lesser = startNode.lesser;
		while (!DataUtils.isNullObject(lesser) && !DataUtils.isNullObject(lesser.id)) {
			Node<T> node = lesser.greater;
			if (!DataUtils.isNullObject(node) && !DataUtils.isNullObject(node.id)) {
				lesser = node;
			} else {
				break;
			}
		}
		return lesser;
	}

	private void replaceNodeWithNode(Node<T> nodeToRemoved, Node<T> replacementNode) {
		if (!DataUtils.isNullObject(replacementNode)) {
			Node<T> replacementNodeLesser = replacementNode.lesser;
			Node<T> replacementNodeGreater = replacementNode.greater;

			Node<T> nodeToRemoveLesser = nodeToRemoved.lesser;
			if (nodeToRemoveLesser != null && nodeToRemoveLesser != replacementNode) {
				replacementNode.lesser = nodeToRemoveLesser;
				nodeToRemoveLesser.parent = replacementNode;
			}
			Node<T> nodeToRemoveGreater = nodeToRemoved.greater;
			if (nodeToRemoveGreater != null && nodeToRemoveGreater != replacementNode) {
				replacementNode.greater = nodeToRemoveGreater;
				nodeToRemoveGreater.parent = replacementNode;
			}

			// Remove link from replacementNode's parent to replacement
			Node<T> replacementParent = replacementNode.parent;
			if (replacementParent != null && replacementParent != nodeToRemoved) {
				Node<T> replacementParentLesser = replacementParent.lesser;
				Node<T> replacementParentGreater = replacementParent.greater;
				if (replacementParentLesser != null && replacementParentLesser == replacementNode) {
					replacementParent.lesser = replacementNodeGreater;
					if (replacementNodeGreater != null)
						replacementNodeGreater.parent = replacementParent;
				} else if (replacementParentGreater != null && replacementParentGreater == replacementNode) {
					replacementParent.greater = replacementNodeLesser;
					if (replacementNodeLesser != null)
						replacementNodeLesser.parent = replacementParent;
				}
			}
		}
		// Update the link in the tree from the nodeToRemoved to the
		// replacementNode
		Node<T> parent = nodeToRemoved.parent;
		if (parent == null) {
			// Replacing the root node
			root = replacementNode;
			if (root != null)
				root.parent = null;
		} else if (parent.lesser != null && (parent.lesser.id.compareTo(nodeToRemoved.id) == 0)) {
			parent.lesser = replacementNode;
			if (replacementNode != null)
				replacementNode.parent = parent;
		} else if (parent.greater != null && (parent.greater.id.compareTo(nodeToRemoved.id) == 0)) {
			parent.greater = replacementNode;
			if (replacementNode != null)
				replacementNode.parent = parent;
		}
		size--;
	}

	@Override
	public void clear() {
		root = null;
		size = 0;

	}

	@Override
	public boolean container(T value) {
		Node<T> node = getNode(value);
		return !DataUtils.isNullObject(node);
	}

	private Node<T> getNode(T value) {
		Node<T> node = root;
		while (!DataUtils.isNullObject(node) && !DataUtils.isNullObject(node.id)) {
			if (node.id.compareTo(value) < 0) {
				node = node.lesser;
			} else if (node.id.compareTo(value) > 0) {
				node = node.greater;
			} else {
				return node;
			}

		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

}

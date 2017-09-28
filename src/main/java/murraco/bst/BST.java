package murraco.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>> {

	TreeNode<E> root;
	int size;

	public BST() {
		root = null;
		size = 0;
	}

	public BST(E value) {
		root = new TreeNode<E>(value);
		size = 1;
	}

	public TreeNode<E> get(E value) {
		return get(root, value);
	}

	/**
	 * Searches for a node with the given value (O log n).
	 * 
	 * @param root
	 *            Root node of the searching tree
	 * @param value
	 *            Searching value
	 * @return The node if it exists, otherwise null
	 */
	private TreeNode<E> get(TreeNode<E> root, E value) {
		if (root == null) {
			return null;
		} else if (root.getValue() == value) {
			return root;
		}
		int compare = value.compareTo(root.getValue());
		if (compare < 0) {
			return get(root.getLeft(), value);
		} else {
			return get(root.getRight(), value);
		}
	}

	public TreeNode<E> insert(E value) {
		return insert(root, value);
	}

	/**
	 * Inserts a new node with the given value (O log n).
	 * 
	 * @param root
	 *            Root node of the tree
	 * @param value
	 *            Value of the new node
	 * @return The tree itself if the value doesn't exist, otherwise null
	 */
	private TreeNode<E> insert(TreeNode<E> root, E value) {
		if (root == null) {
			size++;
			return new TreeNode<E>(value);
		}
		int compare = value.compareTo(root.getValue());
		if (compare < 0) {
			root.setLeft(insert(root.getLeft(), value));
		} else if (compare > 0) {
			root.setRight(insert(root.getRight(), value));
		} else {
			return null;
		}
		return root;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Queue<E> queue = new LinkedList<E>();
		treeToPreOrderQueue(root, queue);
		while (!queue.isEmpty()) {
			sb.append(queue.poll());
			if (queue.size() > 0) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}

	/**
	 * Copy all the values of the given queue into the given tree O(n).
	 * 
	 * @param root
	 *            Root node of the tree
	 * @param queue
	 *            Queue with values
	 */
	private void treeToPreOrderQueue(TreeNode<E> root, Queue<E> queue) {
		if (root == null) {
			return;
		}
		queue.offer(root.getValue());
		treeToPreOrderQueue(root.getLeft(), queue);
		treeToPreOrderQueue(root.getRight(), queue);
	}

}

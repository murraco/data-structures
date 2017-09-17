package data.structures.bst;

public class TreeNode<E extends Comparable<E>> {

	TreeNode<E> left, right;
	E value;

	public TreeNode(E value) {
		left = right = null;
		this.value = value;
	}

	public E getValue() {
		return value;
	}

	public TreeNode<E> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<E> node) {
		left = node;
	}

	public TreeNode<E> getRight() {
		return right;
	}

	public void setRight(TreeNode<E> node) {
		right = node;
	}

	@Override
	public String toString() {
		return value.toString();
	}

}
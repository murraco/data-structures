package bds.linkedlist;

public class Node<E extends Comparable<E>> {

	E value;
	Node<E> next;

	public Node(E value) {
		this.value = value;
		next = null;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> node) {
		this.next = node;
	}

	@Override
	public String toString() {
		return value.toString();
	}
	
}

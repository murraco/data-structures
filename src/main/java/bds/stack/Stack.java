package bds.stack;

import bds.linkedlist.Node;

public class Stack<E extends Comparable<E>> {

	Node<E> top;
	int size;

	public Stack() {
		top = null;
		size = 0;
	}

	/**
	 * Adds a new value to the stack O(1)
	 * 
	 * @param value
	 *            Value we want to add
	 */
	public void push(E value) {
		Node<E> node = new Node<E>(value);
		node.setNext(top);
		top = node;
		size++;
	}

	/**
	 * Returns the top without removing it from the stack O(1)
	 * 
	 * @return The top of the stack if it's not empty, otherwise null
	 */
	public Node<E> top() {
		return (isEmpty()) ? null : top;
	}

	/**
	 * Returns the top and removes it from the stack O(1)
	 * 
	 * @return The top of the stack if it's not empty, otherwise null
	 */
	public Node<E> pop() {
		Node<E> result = null;
		if (!isEmpty()) {
			result = top;
			top = top.getNext();
			size--;
		}
		return result;
	}

	public void clear() {
		top = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<E> runner = top;
		while (runner != null) {
			sb.append(runner.getValue());
			if (runner.getNext() != null) {
				sb.append(", ");
			}
			runner = runner.getNext();
		}
		return sb.toString();
	}

}

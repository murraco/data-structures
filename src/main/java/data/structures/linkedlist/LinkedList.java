package data.structures.linkedlist;

public class LinkedList<E extends Comparable<E>> {

	Node<E> head, tail;
	int size;

	public LinkedList() {
		head = tail = null;
		size = 0;
	}

	/**
	 * Gets the element of the list at the given position O(n)
	 * 
	 * @param i
	 *            The position of the element we're trying to get
	 * @return The node if it exists, otherwise null
	 */
	public Node<E> get(int i) {
		if (i < 0 || i >= size()) {
			return null;
		}
		if (i == 0) {
			return head;
		} else if (i == size() - 1) {
			return tail;
		} else {
			Node<E> runner = head;
			while (i > 0) {
				runner = runner.getNext();
				i--;
			}
			return runner;
		}
	}

	/**
	 * Inserts a new value in the list at the given position O(n)
	 * 
	 * @param value
	 *            The value of the new node we're inserting
	 * @param i
	 *            The position in which we want to insert the new node
	 * @return True if the insertion was successful, otherwise false
	 */
	public boolean add(int i, E value) {
		if (i < 0 || i > size()) {
			return false;
		}
		Node<E> node = new Node<E>(value);
		if (i == 0) {
			if (isEmpty()) {
				head = tail = node;
			} else {
				node.setNext(head);
				head = node;
			}
		} else {
			Node<E> runner = head;
			while (i > 1) {
				runner = runner.getNext();
				i--;
			}
			node.setNext(runner.getNext());
			runner.setNext(node);
			if (tail == runner) {
				tail = node;
			}
		}
		size++;
		return true;
	}

	/**
	 * Removes an element from the list at the given position O(n)
	 * 
	 * @param i
	 *            Position of the element we want to remove
	 */
	public void remove(int i) {
		if (i < 0 || i >= size()) {
			return;
		}
		if (i == 0) {
			if (head == tail) {
				head = tail = null;
			} else {
				head = head.next;
			}
		} else {
			Node<E> runner = head;
			Node<E> previous = null;
			while (i > 0) {
				previous = runner;
				runner = runner.getNext();
				i--;
			}
			previous.setNext(runner.getNext());
			if (runner == tail) {
				tail = previous;
			}
		}
		size--;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<E> runner = head;
		while (runner != null) {
			sb.append(runner);
			if (runner.getNext() != null) {
				sb.append(", ");
			}
			runner = runner.getNext();
		}
		return sb.toString();
	}

}

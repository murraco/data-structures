package bds.linkedlist;

public class LinkedList<E extends Comparable<E>> {

	Node<E> head, tail;
	int size;

	public LinkedList() {
		head = tail = null;
		size = 0;
	}

	public Node<E> getFirst() {
		return head;
	}

	public Node<E> getLast() {
		return tail;
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
		Node<E> runner = head;
		while (i > 0) {
			runner = runner.getNext();
			i--;
		}
		return runner;
	}

	public void addFirst(E value) {
		Node<E> node = new Node<E>(value);
		if (isEmpty()) {
			head = tail = node;
		} else {
			node.setNext(head);
			head = node;
		}
		size++;
	}

	public void addLast(E value) {
		Node<E> node = new Node<E>(value);
		if (isEmpty()) {
			head = tail = node;
		} else {
			tail.setNext(node);
			tail = node;
		}
		size++;
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
	public boolean add(E value, int i) {
		if (i < 0 || i > size()) {
			return false;
		}
		if (i == 0) {
			addFirst(value);
		} else if (i == size()) {
			addLast(value);
		} else {
			Node<E> runner = head;
			while (i > 1) {
				runner = runner.getNext();
				i--;
			}
			Node<E> node = new Node<E>(value);
			node.setNext(runner.getNext());
			runner.setNext(node);
			size++;
		}
		return true;
	}

	public void removeFirst() {
		if (!isEmpty()) {
			if (head == tail) {
				head = tail = null;
			} else {
				head = head.getNext();
			}
			size--;
		}
	}

	public void removeLast() {
		if (!isEmpty()) {
			if (head == tail) {
				head = tail = null;
			} else {
				Node<E> runner = head;
				Node<E> previous = null;
				while (runner.getNext() != null) {
					previous = runner;
					runner = runner.getNext();
				}
				previous.setNext(null);
				tail = previous;
			}
			size--;
		}
	}

	/**
	 * Removes an element from the list at the given position O(n)
	 * 
	 * @param i
	 *            Position of the element we want to remove
	 */
	public void remove(int i) {
		if (i > -1 && i < size()) {
			if (i == 0) {
				removeFirst();
			} else if (i == size - 1) {
				removeLast();
			} else {
				Node<E> runner = head;
				Node<E> previous = null;
				while (i > 0) {
					previous = runner;
					runner = runner.getNext();
					i--;
				}
				previous.setNext(runner.getNext());
				size--;
			}
		}
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

package ds.arraylist;

import java.util.Arrays;

public class ArrayList<E extends Comparable<E>> {

	int size;
	Object items[];

	static final int DEFAULT_CAPACITY = 16;

	public ArrayList() {
		size = 0;
		items = new Object[DEFAULT_CAPACITY];
	}

	private void ensureCapacity() {
		items = Arrays.copyOf(items, items.length * 2);
	}

	public boolean add(int i, E value) {
		if (i < 0 || i > size) {
			return false;
		}
		if (size == items.length) {
			ensureCapacity();
		}
		System.arraycopy(items, i, items, i + 1, size - i);
		items[i] = value;
		size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	public E get(int i) {
		if (i >= size || i < 0) {
			return null;
		}
		return (E) items[i];
	}

	/**
	 * Removes an element from the array list at the given position O(n)
	 * 
	 * @param i
	 *            Position of the element we want to remove
	 */
	public void remove(int i) {
		if (i > size || i < 0) {
			return;
		}
		if (i != size - 1) {
			System.arraycopy(items, i + 1, items, i, size - i);
		}
		size--;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			sb.append(items[i]);
			if (i != size - 1) {
				sb.append(", ");
			}
		}
		return sb.toString() + ']';
	}

}

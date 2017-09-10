package bds.heap;

import java.util.ArrayList;

public abstract class Heap<E extends Comparable<E>> {

	ArrayList<E> items;

	public Heap() {
		items = new ArrayList<E>();
	}

	public E peek() {
		if (!isEmpty()) {
			return items.get(0);
		} else {
			return null;
		}
	}

	public void insert(E value) {
		items.add(value);
		shiftUp();
	}

	public abstract void shiftUp();

	public E remove() {
		if (items.size() == 1) {
			return items.remove(0);
		} else if (!isEmpty()) {
			E ans = items.get(0);
			items.set(0, items.remove(items.size() - 1));
			shiftDown();
			return ans;
		} else {
			return null;
		}
	}

	public abstract void shiftDown();

	public int size() {
		return items.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public String toString() {
		return items.toString();
	}

}

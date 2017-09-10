package bds.heap;

public class MaxHeap<E extends Comparable<E>> extends Heap<E> {

	public void shiftUp() {
		int k = items.size() - 1;
		while (k > 0) {
			int p = (k - 1) / 2;
			E temp = items.get(k);
			E parent = items.get(p);
			if (parent.compareTo(temp) < 0) {
				// Switch
				items.set(k, parent);
				items.set(p, temp);
				// Mode up one level
				k = p;
			} else {
				break;
			}
		}
	}

	public void shiftDown() {
		int k = 0;
		int l = 2 * k + 1;
		while (l < items.size()) {
			int r = l + 1;
			int index = l;
			if (r < items.size() && items.get(l).compareTo(items.get(r)) < 0) {
				index = r;
			}
			if (items.get(k).compareTo(items.get(index)) < 0) {
				// Switch
				E temp = items.get(k);
				items.set(k, items.get(index));
				items.set(index, temp);
				// Move down one level
				k = index;
				l = 2 * k + 1;
			} else {
				break;
			}
		}
	}

}

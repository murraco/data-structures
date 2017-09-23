package murraco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import murraco.arraylist.ArrayList;
import murraco.bst.BST;
import murraco.heap.Heap;
import murraco.heap.MaxHeap;
import murraco.heap.MinHeap;
import murraco.linkedlist.LinkedList;
import murraco.queue.Queue;
import murraco.stack.Stack;
import murraco.trie.Trie;

public class DataStructuresTest {

	@Test
	public void testArrayList() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(0, 6);
		arrayList.add(0, 5);
		arrayList.add(0, 4);
		arrayList.add(0, 3);
		arrayList.add(0, 2);
		arrayList.add(0, 1);
		arrayList.add(arrayList.size(), 0);

		assertEquals("[1, 2, 3, 4, 5, 6, 0]", arrayList.toString());
		assertEquals(1, arrayList.get(0).intValue());
		assertEquals(0, arrayList.get(arrayList.size() - 1).intValue());

		arrayList.add(arrayList.size(), 7);
		arrayList.add(arrayList.size(), 8);

		assertEquals("[1, 2, 3, 4, 5, 6, 0, 7, 8]", arrayList.toString());

		while (!arrayList.isEmpty()) {
			arrayList.remove(0);
		}

		assertEquals("[]", arrayList.toString());
	}

	@Test
	public void testBSTree() {
		BST<String> tree = new BST<String>("F");
		tree.insert("B");
		tree.insert("A");
		tree.insert("D");
		tree.insert("C");
		tree.insert("E");
		tree.insert("G");
		tree.insert("I");
		tree.insert("H");

		assertEquals("F, B, A, D, C, E, G, I, H", tree.toString());
	}

	@Test
	public void testMaxHeap() {
		Heap<Integer> hp = new MaxHeap<Integer>();

		int[] numbers = new int[] { 1, 3, 5, 4, 2 };
		for (int num : numbers) {
			hp.insert(num);
		}

		assertEquals("[5, 4, 3, 1, 2]", hp.toString());

		assertTrue(hp.remove() == 5);
		assertTrue(hp.remove() == 4);

		assertFalse(hp.peek() == 1);
		assertFalse(hp.peek() == 2);
	}

	@Test
	public void textMinHeap() {
		Heap<Integer> hp = new MinHeap<Integer>();

		int[] numbers = new int[] { 1, 3, 5, 4, 2 };
		for (int num : numbers) {
			hp.insert(num);
		}

		assertEquals("[1, 2, 5, 4, 3]", hp.toString());

		assertTrue(hp.remove() == 1);
		assertTrue(hp.remove() == 2);

		assertFalse(hp.peek() == 5);
		assertFalse(hp.peek() == 4);
	}

	@Test
	public void testLinkedList() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(0, 6);
		list.add(0, 5);
		list.add(0, 4);
		list.add(0, 3);
		list.add(0, 2);
		list.add(0, 1);
		list.add(list.size(), 0);

		assertEquals("1, 2, 3, 4, 5, 6, 0", list.toString());
		assertEquals(1, list.get(0).getValue().intValue());
		assertEquals(0, list.get(list.size() - 1).getValue().intValue());

		list.remove(list.size() - 1);

		assertEquals("1, 2, 3, 4, 5, 6", list.toString());
	}

	@Test
	public void testQueue() {
		Queue<Integer> queue = new Queue<Integer>();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
		}

		assertEquals("0, 1, 2, 3, 4, 5, 6, 7, 8, 9", queue.toString());
		assertEquals(0, queue.dequeue().getValue().intValue());
		assertEquals(1, queue.dequeue().getValue().intValue());
		assertEquals(2, queue.dequeue().getValue().intValue());
		assertEquals(3, queue.dequeue().getValue().intValue());
		assertEquals(4, queue.dequeue().getValue().intValue());
		assertEquals(5, queue.dequeue().getValue().intValue());
		assertEquals(6, queue.dequeue().getValue().intValue());
		assertEquals(7, queue.dequeue().getValue().intValue());
		assertEquals(8, queue.dequeue().getValue().intValue());
		assertEquals(9, queue.dequeue().getValue().intValue());
		assertTrue(queue.isEmpty());
	}

	@Test
	public void testStack() {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}

		assertEquals("9, 8, 7, 6, 5, 4, 3, 2, 1, 0", stack.toString());
		assertEquals(9, stack.pop().getValue().intValue());
		assertEquals(8, stack.pop().getValue().intValue());
		assertEquals(7, stack.pop().getValue().intValue());
		assertEquals(6, stack.pop().getValue().intValue());
		assertEquals(5, stack.pop().getValue().intValue());
		assertEquals(4, stack.pop().getValue().intValue());
		assertEquals(3, stack.pop().getValue().intValue());
		assertEquals(2, stack.pop().getValue().intValue());
		assertEquals(1, stack.pop().getValue().intValue());
		assertEquals(0, stack.pop().getValue().intValue());
		assertTrue(stack.isEmpty());
	}

	@Test
	public void testTrie() {
		Trie trie = new Trie();
		trie.add("s");
		trie.add("sim");
		trie.add("simpsons");
		trie.add("samsung");
		trie.add("sampson");
		trie.add("Double Vision");

		assertFalse(trie.contains("samsun"));
		assertFalse(trie.contains("Double"));

		assertTrue(trie.contains("samsung"));
		assertTrue(trie.contains("Double Vision"));
	}

}

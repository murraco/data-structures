package bds.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bds.arraylist.ArrayList;
import bds.bst.BST;
import bds.heap.Heap;
import bds.heap.MaxHeap;
import bds.heap.MinHeap;
import bds.linkedlist.LinkedList;
import bds.queue.Queue;
import bds.stack.Stack;
import bds.trie.Trie;

public class JUnitTest {

	@Test
	public void testArrayList() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		arrayList.addFirst(6);
		arrayList.addFirst(5);
		arrayList.addFirst(4);
		arrayList.addFirst(3);
		arrayList.addFirst(2);
		arrayList.addFirst(1);
		arrayList.addFirst(0);
		assertEquals("[0, 1, 2, 3, 4, 5, 6]", arrayList.toString());
		assertEquals(0, arrayList.getFirst().intValue());
		assertEquals(6, arrayList.getLast().intValue());

		arrayList.addLast(7);
		arrayList.addLast(8);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8]", arrayList.toString());

		arrayList.add(0, 1);
		assertEquals("[0, 0, 1, 2, 3, 4, 5, 6, 7, 8]", arrayList.toString());

		arrayList.add(7, 7);
		assertEquals("[0, 0, 1, 2, 3, 4, 5, 7, 6, 7, 8]", arrayList.toString());

		assertEquals(11, arrayList.size());

		arrayList.removeLast();
		arrayList.removeFirst();
		assertEquals("[0, 1, 2, 3, 4, 5, 7, 6, 7]", arrayList.toString());

		arrayList.remove(0);
		arrayList.remove(arrayList.size() - 1);
		assertEquals("[1, 2, 3, 4, 5, 7, 6]", arrayList.toString());

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

		list.addFirst(6);
		list.addFirst(5);
		list.addFirst(4);
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);
		list.addFirst(0);
		assertEquals("0, 1, 2, 3, 4, 5, 6", list.toString());
		assertEquals(0, list.getFirst().getValue().intValue());
		assertEquals(6, list.getLast().getValue().intValue());

		list.removeLast();
		assertEquals("0, 1, 2, 3, 4, 5", list.toString());

		list.addLast(7);
		list.addLast(8);
		System.out.println(list.toString());
		assertEquals("0, 1, 2, 3, 4, 5, 7, 8", list.toString());

		list.add(0, 1);
		assertEquals("0, 0, 1, 2, 3, 4, 5, 7, 8", list.toString());

		list.add(7, 7);
		assertEquals("0, 0, 1, 2, 3, 4, 5, 7, 7, 8", list.toString());

		assertEquals(10, list.size());
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

package murraco.queue;

import murraco.linkedlist.Node;

public class Queue<E extends Comparable<E>> {

  Node<E> head, tail;
  int size;

  public Queue() {
    head = tail = null;
    size = 0;
  }

  /**
   * Adds a new value to the queue O(1).
   * 
   * @param value Value of the element we want to add
   */
  public void enqueue(E value) {
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
   * Returns the head without removing it from the queue O(1).
   * 
   * @return The head of the queue if it's not empty, otherwise null
   */
  public Node<E> peek() {
    if (!isEmpty()) {
      return head;
    }
    return null;
  }

  /**
   * Returns the head and removes it from the queue O(1).
   * 
   * @return The head of the queue if it's not empty, otherwise null
   */
  public Node<E> dequeue() {
    if (!isEmpty()) {
      Node<E> result = head;
      if (head == tail) {
        head = tail = null;
      } else {
        head = head.getNext();
      }
      size--;
      return result;
    }
    return null;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return (size == 0);
  }

  public void clear() {
    head = tail = null;
    size = 0;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node<E> runner = head;
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

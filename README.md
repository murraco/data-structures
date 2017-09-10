# Data Structures

![](https://img.shields.io/badge/build-success-brightgreen.svg)
![](https://img.shields.io/badge/test-pass-brightgreen.svg)

# Structures

![](https://img.shields.io/badge/arraylist-✓-blue.svg)
![](https://img.shields.io/badge/linkedlist-✓-blue.svg)
![](https://img.shields.io/badge/stack-✓-blue.svg)
![](https://img.shields.io/badge/queue-✓-blue.svg)
![](https://img.shields.io/badge/bst-✓-blue.svg)
![](https://img.shields.io/badge/heap-✓-blue.svg)
![](https://img.shields.io/badge/trie-✓-blue.svg)

## ArrayList

**add/remove:** `O(n)` - **search:** `O(1)`

An array is nothing but a sequential collection of the same type of elements, accessed by their index values. Naturally, an array list also behaves in a similar manner with the difference that's a re-sizable data structure. Array lists are created with an initial size. When this size is exceeded, the collection is automatically enlarged. When objects are removed, the array may be shrunk. Array lists are fast for accessing a specific element but can be slow to add to either end, and especially slow to delete in the middle.

## LinkedList

**add/remove:** `O(1)` - **search:** `O(n)`

A linked list is made up of node objects that hold objects of the same type in a linear order. The size of a linked list can shrink and grow; it doesn't have a predetermined size like an array does. A linked list node object contains a generic object and a node of the same type as itself. A linked list node can link to another node object of the same type. Nodes in a linked list connect to other nodes by holding a reference point of the other node. The basic operations of a linked list are insert and delete. Changing the reference pointers of the nodes is how inserting and deleting a node is accomplished.

## Stack

**push/pop/top:** `O(1)` - **search:** `O(n)`

A stack is a **lifo** (last in, first out) structure. A stack has only one point where data enters or leaves, and this point is referred to as the top. We can't insert or remove elements into or from the middle of the stack. A stack can be implemented using a linked list by defining the insert and delete routines so that nodes are always inserted and deleted from the head (top) of the linked list. When data is inserted to the stack it is called push, as in pushing data onto the stack. When data is deleted from the stack it is called pop, as in popping data off of the stack.

## Queue

**enqueue/dequeue/peek:** `O(1)` - **search:** `O(n)`

A queue is a **fifo** (first in, first out) structure. When an object is inserted into the queue it's referred to as enqueue. When an object is deleted from the queue it;s referred to as dequeue. Objects in a queue can only be inserted to the front and deleted from the back. A queue can be implemented using a linked list by defining the insert and delete routines. All enqueue's must insert to the head (front) of the linked list. All dequeue's must delete from the tail (back) of the linked list.

## BST (Binary Search Tree)

**insert/remove/search:** average `O(log n)` - worst `O(n)`

Binary search tree, is a node-based binary tree data structure which has the following properties:
- The left subtree of a node contains only nodes with keys less than the node’s key.
- The right subtree of a node contains only nodes with keys greater than the node’s key.
- The left and right subtree each must also be a binary search tree.
- There must be no duplicate nodes.

## Heap

**peek:** `O(1)` - **insert/remove:** `O(log n)`- **search:** `O(n)`

A binary heap is a complete binary tree which satisfies the heap ordering property. The ordering can be one of two types:
- The **min-heap** property: the value of each node is greater than or equal to the value of its parent, with the minimum-value element at the root.
- The **max-heap** property: the value of each node is less than or equal to the value of its parent, with the maximum-value element at the root.

## Trie

`w: number of words`

`l: word average length`

**creation:** `O(w*l)` - **insert/search:** `O(l)`

A trie is an efficient information retrieval data structure. Using a trie, search complexities can be brought to optimal limit (key length). If we store keys in a binary search tree, a well balanced binary search tree will need time proportional to `m * log n`, where m is maximum string length and n is number of keys in the tree. Using a trie, we can search the key in `O(m)` time. However penalty is on the trie storage requirements.

Every node of a trie consists of multiple branches. Each branch represents a possible character of keys. We need to mark the last node of every key as leaf node. A trie node field value will be used to distinguish the node as leaf node.

# Contribution

- Report issues
- Open pull request with improvements
- Spread the word
- Reach out to me directly at <mauriurraco@gmail.com>

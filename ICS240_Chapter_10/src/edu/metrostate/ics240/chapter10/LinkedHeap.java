/**
 * File: LinkedHeap.java
 */
package edu.metrostate.ics240.chapter10;

import java.util.LinkedList;

/**
 *
 * @author Vincent J Palodichuk <A HREF="mailto:hu0011wy@metrostate.edu">
 *         (e-mail me) </A>
 *
 * @version 07/30/2017
 *
 */
public abstract class LinkedHeap<T extends Comparable<T>> implements Heap<T> {
	protected BinaryTreeLinkedNode<T> root, lastNode;
	protected int numberOfNodes;
	protected LinkedList<BinaryTreeLinkedNode<T>> nextParent;
	
	/**
	 * 
	 * @param <T>
	 * @param items
	 */
	public static <T extends Comparable<T>> void minHeapify(BinaryTreeNode<T> root) {
		if (root == null) {
			throw new IllegalArgumentException("LinkedHeap.minHeapify(BinaryTreeLinkedNode<T> root): root cannot be null.");
		}
		
		minSiftDown(root, null);
	}

	/**
	 * 
	 * @param <T>
	 * @param items
	 * @param heapify
	 */
	public static <T extends Comparable<T>> void minHeapSort(BinaryTreeLinkedNode<T> startNode, BinaryTreeLinkedNode<T> endNode, boolean heapify) {
		if (startNode == null) {
			throw new IllegalArgumentException(
					"LinkedHeap.minHeapSort(BinaryTreeLinkedNode<T> node, boolean heapify): node cannot be null.");
		}
		
		while (startNode != endNode) {
			swap(startNode, endNode);
			minSiftDown(startNode, (BinaryTreeLinkedNode<T>)endNode.getParent());
			endNode = endNode.getPrevious();
		}
	}
	
	/**
	 * 
	 * @param startNode
	 * @param endNode
	 */
	protected static <T extends Comparable<T>> void minSiftDown(BinaryTreeNode<T> startNode,
			BinaryTreeNode<T> endNode) {
		// We need to ensure that we maintain the heap
		BinaryTreeNode<T> parent = startNode;

		while (parent != endNode) {
			BinaryTreeNode<T> leftChild = (BinaryTreeNode<T>) parent.getLeft();
			BinaryTreeNode<T> rightChild = (BinaryTreeNode<T>) parent.getRight();
			BinaryTreeNode<T> smallest = parent;

			if (leftChild != null && leftChild.compareTo(parent) < 0) {
				smallest = leftChild;
			}

			if (rightChild != null && rightChild.compareTo(smallest) < 0) {
				smallest = rightChild;
			}

			if (smallest != parent) {
				swap(parent, smallest);
				parent = smallest;
			} else {
				break; // Stop the loop as we are done!
			}
		}
	}
	/**
	 * 
	 * @param items
	 * @param startIndex
	 * @param endIndex
	 */
	protected static <T extends Comparable<T>> void minSiftUp(BinaryTreeLinkedNode<T> startNode,
			BinaryTreeLinkedNode<T> endNode) {
		// We need to ensure that we maintain the heap
		BinaryTreeLinkedNode<T> child = startNode;
		BinaryTreeLinkedNode<T> parent = (BinaryTreeLinkedNode<T>) child.getParent();

		while (child != endNode && parent != null && child.compareTo(parent) < 0) {
			swap(parent, child);
			child = parent;
			parent = (BinaryTreeLinkedNode<T>) child.getParent();
		}
	}

	/**
	 * 
	 * @param items
	 * @param i
	 * @param j
	 */
	protected static <T extends Comparable<T>> void swap(BinaryTreeNode<T> i, BinaryTreeNode<T> j) {
		T temp = i.getValue();
		i.setValue(j.getValue());
		j.setValue(temp);
	}

	public LinkedHeap() {
		root = null;
		lastNode = null;
		nextParent = null;
		numberOfNodes = 0;
	}

	public LinkedHeap(BinaryTreeLinkedNode<T> heap) {
		this();
		root = heap;
		numberOfNodes = BinaryTreeLinkedNode.treeSize(heap);
	}

	public LinkedHeap(T[] items) {
		this();

		heapify(items);

		for (T item : items) {
			add(item);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.metrostate.ics240.chapter10.Heap#add(java.lang.Comparable)
	 */
	@Override
	public boolean add(T element) {
		if (root == null) {
			root = new BinaryTreeLinkedNode<>(element, null, null, null);
			lastNode = root;
			numberOfNodes++;
			nextParent = new LinkedList<>();
			nextParent.add(root);
		} else {
			BinaryTreeLinkedNode<T> parent = nextParent.peek();
			lastNode = new BinaryTreeLinkedNode<>(element, parent, null, null, lastNode);
			nextParent.add(lastNode);
			numberOfNodes++;

			if (parent.getLeft() == null) {
				parent.setLeft(lastNode);
			} else {
				parent.setRight(lastNode);
				nextParent.poll(); // Remove this parent from the queue.
			}

			siftUp(lastNode, root);
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.metrostate.ics240.chapter10.Heap#clear()
	 */
	@Override
	public void clear() {
		root = null;
		numberOfNodes = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.metrostate.ics240.chapter10.Heap#clone()
	 */
	@Override
	public Heap<T> clone() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	abstract public void heapify();

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.metrostate.ics240.chapter10.Heap#rebuildHeap()
	 */
	abstract public void heapify(T[] items);

	/**
	 * 
	 */
	abstract public void heapSort();

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.metrostate.ics240.chapter10.Heap#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return root == null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.metrostate.ics240.chapter10.Heap#peek()
	 */
	@Override
	public T peek() {
		return root == null ? null : root.getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.metrostate.ics240.chapter10.Heap#remove()
	 */
	@Override
	public T remove() {
		T answer = null;

		if (root != null) {
			answer = root.getValue();
			// Move the last item to the root
			root.setValue(lastNode.getValue());

			BinaryTreeLinkedNode<T> parent = (BinaryTreeLinkedNode<T>) lastNode.getParent();

			if (parent == null) {
				root = null;
				nextParent.clear();
				nextParent = null;
				numberOfNodes = 0;
				lastNode = null;
			} else {
				numberOfNodes--;
				// Queue<BinaryTreeLinkedNode<T>> tempQueue = new
				// LinkedList<BinaryTreeLinkedNode<T>>();
				// tempQueue.add(parent);
				BinaryTreeLinkedNode<T> previous = lastNode.getPrevious();
				lastNode.setPrevious(null);
				lastNode.setParent(null);
				nextParent.removeLast();
				//nextParent.remove(lastNode);

				if (parent.getLeft() == lastNode) {
					// nextParent.poll();
					parent.setLeft(null);

				} else {
					nextParent.offerFirst(parent);
					parent.setRight(null);
				}

				lastNode = previous;
				// tempQueue.addAll(nextParent);
				// nextParent = tempQueue;
			}

			if (numberOfNodes > 1) {
				siftDown(root, lastNode);
			}
		}
		return answer;
	}

	/**
	 * @param node
	 */
	abstract protected void siftDown(BinaryTreeLinkedNode<T> startNode, BinaryTreeLinkedNode<T> endNode);

	/**
	 * @param node
	 */
	abstract protected void siftUp(BinaryTreeLinkedNode<T> startNode, BinaryTreeLinkedNode<T> endNode);

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.metrostate.ics240.chapter10.Heap#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numberOfNodes;
	}

}

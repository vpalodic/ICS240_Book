/**
 * File: LinkedMinHeap.java
 */
package edu.metrostate.ics240.chapter10;

/**
 *
 * @author Vincent J Palodichuk
 * 	<A HREF="mailto:hu0011wy@metrostate.edu"> (e-mail me) </A>
 *
 * @version 07/31/2017
 *
 */
public class LinkedMinHeap<T extends Comparable<T>> extends LinkedHeap<T> {

	/**
	 * 
	 * @param <T>
	 * @param items
	 */
	public void heapify(T[] items) {
		ArrayHeap.minHeapify(items);
	}
	
	/**
	 * 
	 */
	public void heapify() {		
		for (BinaryTreeLinkedNode<T> parent = lastNode; parent != null; parent = parent.getPrevious()) {
			minHeapify(parent);
		}
	}
	
	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.ArrayHeap#reheapificationDownward()
	 */
	@Override
	protected void siftDown(BinaryTreeLinkedNode<T> startNode, BinaryTreeLinkedNode<T> endNode) {
		minSiftDown(startNode, endNode);
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.ArrayHeap#reheapificationUpwards()
	 */
	@Override
	protected void siftUp(BinaryTreeLinkedNode<T> startNode, BinaryTreeLinkedNode<T> endNode) {
		minSiftUp(startNode, endNode);
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.ArrayHeap#heapSort()
	 */
	@Override
	public void heapSort() {
		minHeapSort(root, lastNode, false);
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.Heap#sort()
	 */
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		minHeapSort(root, lastNode, false);
	}
}

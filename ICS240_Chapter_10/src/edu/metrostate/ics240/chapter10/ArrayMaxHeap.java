/**
 * File: ArrayMaxHeap.java
 */
package edu.metrostate.ics240.chapter10;

/**
 *
 * @author Vincent J Palodichuk
 * 	<A HREF="mailto:hu0011wy@metrostate.edu"> (e-mail me) </A>
 *
 * @version 07/28/2017
 *
 */
public class ArrayMaxHeap<T extends Comparable<T>> extends ArrayHeap<T> {
	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.ArrayHeap#ArrayHeap(int)
	 */
	public ArrayMaxHeap(int initialCapacity) {
		super(initialCapacity);
	}
	
	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.ArrayHeap#ArrayHeap(java.lang.Comparable[])
	 */
	public ArrayMaxHeap(T[] items) {
		super(items);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param items
	 */
	public static <T extends Comparable<T>> void heapify(T[] items) {
		maxHeapify(items);
	}
	
	/**
	 * 
	 */
	public void heapify() {
		maxHeapify(items, items.length);
	}
	
	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.ArrayHeap#reheapificationDownward()
	 */
	@Override
	protected void siftDown(int startIndex, int endIndex) {
		maxSiftDown(items, startIndex, endIndex);
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.ArrayHeap#reheapificationUpwards()
	 */
	@Override
	protected void siftUp(int startIndex, int endIndex) {
		maxSiftUp(items, startIndex, endIndex);
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.ArrayHeap#heapSort()
	 */
	@Override
	protected void heapSort() {
		maxHeapSort(items, items.length, false);
	}
}

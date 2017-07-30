/**
 * File: ArrayMinHeap.java
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
public class ArrayMinHeap<T extends Comparable<T>> extends ArrayHeap<T> {
	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.ArrayHeap#ArrayHeap(int)
	 */
	public ArrayMinHeap(int initialCapacity) {
		super(initialCapacity);
	}
	
	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.ArrayHeap#ArrayHeap(java.lang.Comparable[])
	 */
	public ArrayMinHeap(T[] items) {
		super(items);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param items
	 */
	public static <T extends Comparable<T>> void heapify(T[] items) {
		minHeapify(items);
	}
	
	/**
	 * 
	 */
	public void heapify() {
		minHeapify(items, items.length);
	}
	
	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.ArrayHeap#reheapificationDownward()
	 */
	@Override
	protected void siftDown(int startIndex, int endIndex) {
		minSiftDown(items, startIndex, endIndex);
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.ArrayHeap#reheapificationUpwards()
	 */
	@Override
	protected void siftUp(int startIndex, int endIndex) {
		minSiftUp(items, startIndex, endIndex);
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.ArrayHeap#heapSort()
	 */
	@Override
	protected void heapSort() {
		minHeapSort(items, items.length, false);
	}
}

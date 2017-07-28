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
	 * @param leftIndex
	 * @param rightIndex
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private int maxElementIndex(int leftIndex, int rightIndex) {
		int answer = -1;
		
		T leftChild = leftIndex < numberOfItems ? (T) items[leftIndex] : null;
		T rightChild = rightIndex < numberOfItems ? (T) items[rightIndex] : null;
		
		if (leftChild == null && rightChild == null) {
			return answer;
		} else if ((leftChild == null) ^ (rightChild == null)) {
			answer = leftChild == null ? rightIndex : leftIndex;
		} else {
			if (leftChild.compareTo(rightChild) > 0) {
				answer = leftIndex;
			} else {
				answer = rightIndex;
			}
		}
		
		return answer;
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.ArrayHeap#reheapificationDownward()
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected void reheapificationDownward() {
		int i = ROOT_INDEX;
		
		// We need to ensure that we maintain the heap
		int j = (i * 2) + 1; // left child index
		int k = (i * 2) + 2; // right child index
		
		T parent = (T) items[i];
		int childIndex = maxElementIndex(j, k);
		T child = null;
		
		boolean done = false;
		
		if (parent == null || childIndex < 0 || parent.compareTo(child = (T) items[childIndex]) >= 0) {
			done = true;
		}
		
		// We will loop until we reach the end of the tree
		// or if the parent has a higher priority than both children.
		while (!done) {
			items[i] = child;
			items[childIndex] = parent;
			
			i = childIndex;
			j = (i * 2) + 1; // left child index
			k = (i * 2) + 2; // right child index
			childIndex = maxElementIndex(j, k);
			
			if (childIndex < 0) {
				done = true;
			} else {
				parent = child;
				child = (T) items[childIndex];
				
				if (parent.compareTo(child) >= 0) {
					done = true;
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.ArrayHeap#reheapificationUpwards()
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected void reheapificationUpwards() {
		// We need to ensure that we maintain the heap
		int i = numberOfItems - 1;
		int j = (i - 1) / 2;
		
		T parent = (T) items[j];
		T element = (T) items[i];
		boolean done = false;
		
		if (i == ROOT_INDEX || element == null || element.compareTo(parent) <= 0) {
			done = true;
		}
		
		// We will loop until the new element is less than it's
		// parent or until we have reached the root of the heap.
		while (!done) {				
			items[j] = element;
			items[i] = parent;
			
			if (j == ROOT_INDEX) {
				done = true;
			} else {
				i = j;
				j = (i - 1) / 2;
				parent = (T) items[j];
			
				if (element.compareTo(parent) <= 0) {
					done = true;
				}
			}
		}
	}
}

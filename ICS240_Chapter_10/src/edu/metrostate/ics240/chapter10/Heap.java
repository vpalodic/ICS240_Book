/**
 * File: Heap.java
 */
package edu.metrostate.ics240.chapter10;

/**
 *
 * @author Vincent J Palodichuk
 * 	<A HREF="mailto:hu0011wy@metrostate.edu"> (e-mail me) </A>
 *
 * @version 07/27/2017
 *
 */
public interface Heap<T extends Comparable<T>> {
	/**
	 * 
	 * @param element
	 * @return
	 */
	public boolean add(T element);
	
	/**
	 * 
	 */
	public void clear();
	
	/**
	 * Generate a copy of this heap. 
	 * <p>
	 * <b>Note:</b>
	 * <ul>
	 * 	<li>
	 * 		Be sure to cast the return value to the proper <code>Heap&lt;T&gt;</code> type
	 *      before use.
	 * 	</li>
	 * </ul>
	 * @return
	 * 	The return value is a copy of this heap. Subsequent changes to the copy will not affect
	 * 	the original, nor vice versa.
	 * @throws OutOfMemoryError
	 * 	Indicates that there is insufficient memory for the new heap.
	 *  
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Heap<T> clone();
	
	/**
	 * Returns true if the heap is empty; otherwise, false is returned.
	 * @return
	 *  Returns true if the heap is empty; otherwise, false is returned.
	 */
	public boolean isEmpty();
	
	/**
	 * 
	 * @return
	 */
	public T peek();
	
	/**
	 * 
	 */
	public void heapify();
	
	/**
	 * 
	 */
	public void heapify(T[] items);
	
	/**
	 * 
	 * @return
	 */
	public T remove();
	
	/**
	 * 
	 * @return
	 */
	public int size();
	
	public void sort();
}

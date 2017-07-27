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
	public void add(T element);
	public void clear();
	public Heap<T> clone();
	public boolean isEmpty();
	public T peek();
	public T remove();
	public int size();
}

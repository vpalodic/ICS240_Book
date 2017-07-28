/**
 * File: PriorityQueue.java
 */
package edu.metrostate.ics240.chapter10;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 *
 * @author Vincent J Palodichuk
 * 	<A HREF="mailto:hu0011wy@metrostate.edu"> (e-mail me) </A>
 *
 * @version 07/28/2017
 *
 */
public class PriorityQueue<T extends Comparable<T>> extends ArrayMinHeap<T> implements Queue<T> {
	/**
	 * @param initialCapacity
	 */
	public PriorityQueue(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * @param items
	 */
	public PriorityQueue(T[] items) {
		super(items);
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#addAll(java.util.Collection)
	 */
	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		throw new UnsupportedOperationException("PriorityQueue<T>.addAll(Collection<? extends T> arg0): Method not implemented.");
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object arg0) {
		throw new UnsupportedOperationException("PriorityQueue<T>.contains(Object arg0): Method not implemented.");
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#containsAll(java.util.Collection)
	 */
	@Override
	public boolean containsAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("PriorityQueue<T>.containsAll(Collection<?> arg0): Method not implemented.");
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#iterator()
	 */
	@Override
	public Iterator<T> iterator() {
		throw new UnsupportedOperationException("PriorityQueue<T>.iterator(): Method not implemented.");
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object arg0) {
		throw new UnsupportedOperationException("PriorityQueue<T>.remove(Object arg0): Method not implemented.");
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#removeAll(java.util.Collection)
	 */
	@Override
	public boolean removeAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("PriorityQueue<T>.removeAllAll(Collection<?> arg0): Method not implemented.");
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#retainAll(java.util.Collection)
	 */
	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("PriorityQueue<T>.retainAll(Collection<?> arg0): Method not implemented.");
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#toArray()
	 */
	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException("PriorityQueue<T>.toArray(): Method not implemented.");
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#toArray(java.lang.Object[])
	 */
	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] arg0) {
		throw new UnsupportedOperationException("PriorityQueue<T>.toArray(T[] arg0): Method not implemented.");
	}

	/* (non-Javadoc)
	 * @see java.util.Queue#element()
	 */
	@Override
	public T element() {
		throw new UnsupportedOperationException("PriorityQueue<T>.element(): Method not implemented.");
	}

	/* (non-Javadoc)
	 * @see java.util.Queue#offer(java.lang.Object)
	 */
	@Override
	public boolean offer(T arg0) {
		throw new UnsupportedOperationException("PriorityQueue<T>.offer(T arg0): Method not implemented.");
	}

	/* (non-Javadoc)
	 * @see java.util.Queue#poll()
	 */
	@Override
	public T poll() {
		return remove();
	}
}

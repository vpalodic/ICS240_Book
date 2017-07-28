/**
 * File: ArrayHeap.java
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
public abstract class ArrayHeap<T extends Comparable<T>> implements Heap<T> {
	protected static final int DEFAULT_INITIAL_SIZE = 32;
	protected static final int ROOT_INDEX = 0;
	protected Object[] items;
	protected int numberOfItems;
	
	/**
	 * 
	 */
	public ArrayHeap() {
		this(DEFAULT_INITIAL_SIZE);
	}
	
	/**
	 * @param initialSize
	 */
	public ArrayHeap(int initialSize) {
		if (initialSize < 0) {
			throw new IllegalArgumentException("ArrayHeap<T>.ArrayHeap(int initialSize): initialSize cannot be less than 0.");
		}
		
		numberOfItems = 0;
		items = new Object[initialSize];
	}

	/**
	 * 
	 * @param items
	 */
	public ArrayHeap(T[] items) {
		if (items == null) {
			throw new IllegalArgumentException("ArrayHeap<T>.ArrayHeap(T[] items): items cannot be null!");
		}
		
		numberOfItems = 0;
		this.items = new Object[items.length];
		
		for (int i = 0; i < items.length; i++) {
			add(items[i]);
		}
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.Heap#add(java.lang.Comparable)
	 */
	@Override
	public boolean add(T element) {
		if (element == null) {
			throw new IllegalArgumentException("ArrayHeap<T>.add(T element): element cannot be null.");
		}
		
		if (numberOfItems == items.length) {
			// Double the capacity and add 1; this works even if manyItems is 0. However, in
			// case that manyItems * 2 + 1 is beyond integer.MAX_VALUE, there will be an
			// arithmetic overflow and the sequence will fail.
			ensureCapacity(numberOfItems * 2 + 1);
		}
		
		items[numberOfItems++] = element;
		
		if (numberOfItems > 1) {
			reheapificationUpwards();
		}
		
		return true;
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.Heap#clear()
	 */
	@Override
	public void clear() {
		numberOfItems = 0;
		trimToSize();
	}
	
	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.Heap#clone()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Heap<T> clone() {
		// Clone a Heap<T> object
		ArrayHeap<T> answer;
		
		try {
			answer = (ArrayHeap<T>) super.clone();
		} catch (CloneNotSupportedException exception) {
			// This exception should not occur. But if it does, it would indicate a programming
			// error that made super.clone unavailable. The most common cause would be
			// forgetting the "implements Cloneable" clause at the start of the class.
			throw new RuntimeException ("Heap<T>.clone(): This class does not implement Cloneable.");
		}
		
		// Deep-copy the array.
		answer.items = items.clone();
		
		return answer;
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.Heap#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		boolean answer = false;
		
		if (numberOfItems == 0) {
			answer = true;
		}
		
		return answer;
	}

	/**
	 * Change the current capacity of this heap.
	 * <p>
	 * <b>Postcondition:</b>
	 * <ul>
	 * 	<li>
	 * 		This heap's capacity has been changed to at least <code>minimumCapacity</code>. If the capacity was already
	 * 		at or greater than <code>minimumCapacity</code>, then the capacity is left unchanged.
	 * 	</li>
	 * </ul>
	 * @param minimumCapacity
	 * 	The new capacity of this heap.
	 * @throws OutOfMemoryError
	 * 	Indicates insufficient memory for altering the capacity.
	 */
	public void ensureCapacity(int minimumCapacity) {
		Object[] temp = null;
		
		if (items.length < minimumCapacity) {
			temp = new Object[minimumCapacity];
			System.arraycopy(items, 0, temp, 0, numberOfItems);
			items = temp;
		}
	}

	/**
	 * Return the current capacity of this heap.
	 * <p>
	 * <b>Note:</b>
	 * <ul>
	 * 	<li>
	 * 	 The add method works efficiently (without needing more memory)
	 * 	 until this capacity is reached.
	 * 	</li>
	 * </ul>
	 * @return
	 * 	Returns the current capacity of this heap.
	 */
	public int getCapacity() {
		return items.length;
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.Heap#peek()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T peek() {
		T answer = null;
		
		if (numberOfItems > 0) {
			answer = (T) items[ROOT_INDEX];
		}
		
		return answer;
	}

	abstract protected void reheapificationDownward();

	abstract protected void reheapificationUpwards();
	
	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.Heap#remove()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T remove() {
		T answer = null;
		
		if (numberOfItems > 0) {
			answer = (T) items[ROOT_INDEX];
			
			// Move the last item to the root
			items[ROOT_INDEX] = items[--numberOfItems];
			items[numberOfItems] = null;
			
			if (numberOfItems > 1) {
				reheapificationDownward();
			}
		}
		
		return answer;
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.Heap#size()
	 */
	@Override
	public int size() {
		return numberOfItems;
	}
	
	/**
	 * Reduce the current capacity of this heap to its actual size (i.e., the number
	 * of elements it contains).
	 * <p>  
	 * <b>Postcondition:</b>
	 * <ul>
	 * 	<li>
	 * 		This heap's capacity has been changed to its current size.
	 * 	</li>
	 * </ul>
	 * @throws OutOfMemoryError
	 * 	Indicates insufficient memory for altering the capacity.
	 */
	public void trimToSize() {
		Object[] temp = null;
		
		if (items.length != numberOfItems) {
			temp = new Object[numberOfItems];
			System.arraycopy(items, 0, temp, 0, numberOfItems);
			items = temp;
		}
	}
}

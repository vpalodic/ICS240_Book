/**
 * File: ArrayHeap.java
 */
package edu.metrostate.ics240.chapter10;

/**
 *
 * @author Vincent J Palodichuk <A HREF="mailto:hu0011wy@metrostate.edu">
 *         (e-mail me) </A>
 *
 * @version 07/27/2017
 *
 */
public abstract class ArrayHeap<T extends Comparable<T>> implements Heap<T> {
	protected static final int DEFAULT_INITIAL_SIZE = 32;
	protected static final int ROOT_INDEX = 0;

	//	Invariant of the ArrayHeap<T extends Comparable<T>> class:
	//		1.	The number of elements in the heap is in the instance variable numberOfItems.
	//		2.	For an empty heap, we do not care what is stored in the items array;
	//			for a non-empty heap, the elements in the heap are stored in items[0]
	//			through items[numberOfItems - 1], and we don't care what's in the rest of
	//			the items array.
	//		3.	The heap is a complete tree.
	//		4.	For a max heap, items[0] always contains an item with the greatest value.
	//		5. 	For a min heap, items[0] always contains an items with the least value.
	protected Object[] items;
	protected int numberOfItems;

	/**
	 * 
	 * @param items
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected static <T extends Comparable<T>> T getItem(Object[] items, int index) {
		return (T) items[index];
	}

	/**
	 * 
	 * @param parentIndex
	 * @return
	 */
	protected static int getLeftChildIndex(int parentIndex) {
		return (parentIndex * 2) + 1;
	}

	/**
	 * 
	 * @param childIndex
	 * @return
	 */
	protected static int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	/**
	 * 
	 * @param parentIndex
	 * @return
	 */
	protected static int getRightChildIndex(int parentIndex) {
		return (parentIndex * 2) + 2;
	}

	/**
	 * 
	 * @param items
	 * @param count
	 */
	protected static void maxHeapify(Object[] items, int count) {
		// Rebuild the heap from the bottom heap up!
		for (int i = getParentIndex(count - 1); i >= ROOT_INDEX; i--) {
			maxSiftDown(items, i, count);
		}
	}

	/**
	 * 
	 * @param <T>
	 * @param items
	 */
	public static <T extends Comparable<T>> void maxHeapify(T[] items) {
		if (items == null) {
			throw new IllegalArgumentException("ArrayHeap.maxHeapify(T[] items): items cannot be null.");
		}

		maxHeapify((Object[]) items, items.length);
	}

	/**
	 * 
	 * @param items
	 * @param count
	 * @param heapify
	 */
	protected static void maxHeapSort(Object[] items, int count, boolean heapify) {
		if (heapify) {
			maxHeapify(items, count);
		}
		
		int endIndex = count - 1;
		
		while (endIndex > ROOT_INDEX) {
			swap(items, endIndex, ROOT_INDEX);
			maxSiftDown(items, ROOT_INDEX, endIndex);
			endIndex--;
		}
	}
	
	/**
	 * 
	 * @param <T>
	 * @param items
	 * @param heapify
	 */
	public static <T extends Comparable<T>> void maxHeapSort(T[] items, boolean heapify) {
		if (items == null) {
			throw new IllegalArgumentException("ArrayHeap.maxHeapSort(T[] items): items cannot be null.");
		}

		maxHeapSort(items, items.length, heapify);
	}

	/**
	 * 
	 * @param items
	 * @param startIndex
	 * @param endIndex
	 */
	protected static <T extends Comparable<T>> void maxSiftDown(Object[] items, int startIndex, int endIndex) {
		// We need to ensure that we maintain the heap
		int parentIndex = startIndex;

		while (parentIndex <= endIndex) {
			int leftChildIndex = getLeftChildIndex(parentIndex);
			int rightChildIndex = getRightChildIndex(parentIndex);
			int largestIndex = parentIndex;

			if (leftChildIndex < endIndex
					&& getItem(items, leftChildIndex).compareTo(getItem(items, parentIndex)) > 0) {
				largestIndex = leftChildIndex;
			}

			if (rightChildIndex < endIndex
					&& getItem(items, rightChildIndex).compareTo(getItem(items, largestIndex)) > 0) {
				largestIndex = rightChildIndex;
			}

			if (largestIndex != parentIndex) {
				swap(items, largestIndex, parentIndex);
				parentIndex = largestIndex;
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
	protected static <T extends Comparable<T>> void maxSiftUp(Object[] items, int startIndex, int endIndex) {
		// We need to ensure that we maintain the heap
		int childIndex = endIndex;
		int parentIndex = getParentIndex(childIndex);

		while (childIndex > startIndex && getItem(items, childIndex).compareTo(getItem(items, parentIndex)) > 0) {
			swap(items, childIndex, parentIndex);
			childIndex = parentIndex;
			parentIndex = getParentIndex(childIndex);
		}
	}

	/**
	 * 
	 * @param items
	 * @param count
	 */
	protected static void minHeapify(Object[] items, int count) {
		// Rebuild the heap from the bottom heap up!
		for (int i = getParentIndex(count - 1); i >= ROOT_INDEX; i--) {
			minSiftDown(items, i, count);
		}
	}

	/**
	 * 
	 * @param <T>
	 * @param items
	 */
	public static <T extends Comparable<T>> void minHeapify(T[] items) {
		if (items == null) {
			throw new IllegalArgumentException("ArrayHeap.minHeapify(T[] items): items cannot be null.");
		}

		minHeapify((Object[]) items, items.length);
	}

	/**
	 * 
	 * @param items
	 * @param count
	 * @param heapify
	 */
	protected static void minHeapSort(Object[] items, int count, boolean heapify) {
		if (heapify) {
			minHeapify(items, count);
		}
		
		int endIndex = count - 1;
		
		while (endIndex > ROOT_INDEX) {
			swap(items, endIndex, ROOT_INDEX);
			minSiftDown(items, ROOT_INDEX, endIndex);
			endIndex--;
		}
	}
	
	/**
	 * 
	 * @param <T>
	 * @param items
	 * @param heapify
	 */
	public static <T extends Comparable<T>> void minHeapSort(T[] items, boolean heapify) {
		if (items == null) {
			throw new IllegalArgumentException("ArrayHeap.minHeapSort(T[] items): items cannot be null.");
		}

		minHeapSort(items, items.length, heapify);
	}

	/**
	 * 
	 * @param items
	 * @param startIndex
	 * @param endIndex
	 */
	protected static <T extends Comparable<T>> void minSiftDown(Object[] items, int startIndex, int endIndex) {
		// We need to ensure that we maintain the heap
		int parentIndex = startIndex;

		while (parentIndex <= endIndex) {
			int leftChildIndex = getLeftChildIndex(parentIndex);
			int rightChildIndex = getRightChildIndex(parentIndex);
			int smallestIndex = parentIndex;

			if (leftChildIndex < endIndex
					&& getItem(items, leftChildIndex).compareTo(getItem(items, parentIndex)) < 0) {
				smallestIndex = leftChildIndex;
			}

			if (rightChildIndex < endIndex
					&& getItem(items, rightChildIndex).compareTo(getItem(items, smallestIndex)) < 0) {
				smallestIndex = rightChildIndex;
			}

			if (smallestIndex != parentIndex) {
				swap(items, smallestIndex, parentIndex);
				parentIndex = smallestIndex;
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
	protected static <T extends Comparable<T>> void minSiftUp(Object[] items, int startIndex, int endIndex) {
		// We need to ensure that we maintain the heap
		int childIndex = endIndex;
		int parentIndex = getParentIndex(childIndex);

		while (childIndex > startIndex && getItem(items, childIndex).compareTo(getItem(items, parentIndex)) < 0) {
			swap(items, childIndex, parentIndex);
			childIndex = parentIndex;
			parentIndex = getParentIndex(childIndex);
		}
	}

	/**
	 * 
	 * @param items
	 * @param i
	 * @param j
	 */
	protected static <T> void swap(T[] items, int i, int j) {
		T temp = (T) items[i];
		items[i] = items[j];
		items[j] = temp;
	}

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
			throw new IllegalArgumentException(
					"ArrayHeap.ArrayHeap(int initialSize): initialSize cannot be less than 0.");
		}

		numberOfItems = 0;
		ensureCapacity(initialSize);
	}

	/**
	 * 
	 * @param items
	 */
	public ArrayHeap(T[] items) {
		if (items == null) {
			throw new IllegalArgumentException("ArrayHeap.ArrayHeap(T[] items): items cannot be null!");
		}

		numberOfItems = items.length;
		this.items = items.clone();

		heapify();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.metrostate.ics240.chapter10.Heap#add(java.lang.Comparable)
	 */
	@Override
	public boolean add(T item) {
		if (item == null) {
			throw new IllegalArgumentException("ArrayHeap<T>.add(T item): item cannot be null.");
		}

		if (numberOfItems == items.length) {
			// Double the capacity and add 1; this works even if manyItems is 0.
			// However, in
			// case that manyItems * 2 + 1 is beyond integer.MAX_VALUE, there
			// will be an
			// arithmetic overflow and the sequence will fail.
			ensureCapacity(numberOfItems * 2 + 1);
		}

		items[numberOfItems++] = item;

		if (numberOfItems > 1) {
			siftUp(ROOT_INDEX, numberOfItems - 1);
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
		numberOfItems = 0;
		items = null;
		ensureCapacity(DEFAULT_INITIAL_SIZE);
	}

	/*
	 * (non-Javadoc)
	 * 
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
			// This exception should not occur. But if it does, it would
			// indicate a programming
			// error that made super.clone unavailable. The most common cause
			// would be
			// forgetting the "implements Cloneable" clause at the start of the
			// class.
			throw new RuntimeException("ArrayHeap<T>.clone(): This class does not implement Cloneable.");
		}

		// Deep-copy the array.
		answer.items = items.clone();

		return answer;
	}

	/**
	 * Change the current capacity of this heap.
	 * <p>
	 * <b>Postcondition:</b>
	 * <ul>
	 * <li>This heap's capacity has been changed to at least
	 * <code>minimumCapacity</code>. If the capacity was already at or greater
	 * than <code>minimumCapacity</code>, then the capacity is left unchanged.
	 * </li>
	 * </ul>
	 * 
	 * @param minimumCapacity
	 *            The new capacity of this heap.
	 * @throws OutOfMemoryError
	 *             Indicates insufficient memory for altering the capacity.
	 */
	public void ensureCapacity(int minimumCapacity) {
		if (items == null) {
			items = new Object[minimumCapacity];
		} else if (items.length < minimumCapacity) {
			Object[] temp = null;
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
	 * <li>The add method works efficiently (without needing more memory) until
	 * this capacity is reached.</li>
	 * </ul>
	 * 
	 * @return Returns the current capacity of this heap.
	 */
	public int getCapacity() {
		return items.length;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	protected T getItem(int index) {
		return getItem(items, index);
	}

	/**
	 * 
	 */
	abstract public void heapify();

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.metrostate.ics240.chapter10.Heap#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return (numberOfItems == 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.metrostate.ics240.chapter10.Heap#peek()
	 */
	@Override
	public T peek() {
		return numberOfItems > 0 ? getItem(items, ROOT_INDEX) : null;
	}

	/*
	 * (non-Javadoc)
	 * 
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
				siftDown(ROOT_INDEX, numberOfItems);
			}
		}

		return answer;
	}

	/**
	 * 
	 * @param startIndex
	 * @param endIndex
	 */
	abstract protected void siftDown(int startIndex, int endIndex);

	/**
	 * 
	 * @param startIndex
	 * @param endIndex
	 */
	abstract protected void siftUp(int startIndex, int endIndex);
	
	/**
	 * 
	 */
	abstract protected void heapSort();

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.metrostate.ics240.chapter10.Heap#size()
	 */
	@Override
	public int size() {
		return numberOfItems;
	}
	
	/**
	 * 
	 */
	public void sort() {
		heapSort();
	}

	/**
	 * 
	 * @param i
	 * @param j
	 */
	protected void swap(int i, int j) {
		swap(items, i, j);
	}

	/**
	 * Reduce the current capacity of this heap to its actual size (i.e., the
	 * number of elements it contains).
	 * <p>
	 * <b>Postcondition:</b>
	 * <ul>
	 * <li>This heap's capacity has been changed to its current size.</li>
	 * </ul>
	 * 
	 * @throws OutOfMemoryError
	 *             Indicates insufficient memory for altering the capacity.
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

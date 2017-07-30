/**
 * File: BalancedTree.java
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
public abstract class BalancedTree<T extends Comparable<T>> implements Cloneable {
	protected static final int DEFAULT_MINIMUM_NUMBER_OF_ELEMENTS = 1;
	
	protected int minNumberOfElements;
	protected int maxNumberOfElements;
	protected Object[] items;
	protected int numberOfItems;
	protected int numberOfChildren;
	protected Object[] children;
	
	/**
	 * 
	 */
	public BalancedTree() {
		this(DEFAULT_MINIMUM_NUMBER_OF_ELEMENTS);
	}

	/**
	 * @param minimumNumberOfElements
	 */
	public BalancedTree(int minimumNumberOfElements) {
		if (minimumNumberOfElements < 1) {
			throw new IllegalArgumentException("BalancedTree(int minimumNumberOfElements): minimumNumberOfElements must be positive.");
		}
		
		minNumberOfElements = minimumNumberOfElements;
		maxNumberOfElements = minNumberOfElements * 2;
		
		items = new Object[maxNumberOfElements + 1]; // Allow space for one extra node to support lazy add and remove.
		children = new Object[maxNumberOfElements + 2]; // A node with n elements has n + 1 children.
	}
	
	/**
	 * 
	 * @param element
	 */
	public abstract void add(T element);
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public BalancedTree<T> clone() {
		// Clone a BalancedTree<T> object
		BalancedTree<T> answer;
		
		try {
			answer = (BalancedTree<T>) super.clone();
		} catch (CloneNotSupportedException exception) {
			// This exception should not occur. But if it does, it would indicate a programming
			// error that made super.clone unavailable. The most common cause would be
			// forgetting the "implements Cloneable" clause at the start of the class.
			throw new RuntimeException ("BalancedTree<T>.clone(): This class does not implement Cloneable.");
		}
		
		// Deep-copy the array.
		answer.items = items.clone();
		answer.children = children.clone();
		
		return answer;
	}
}

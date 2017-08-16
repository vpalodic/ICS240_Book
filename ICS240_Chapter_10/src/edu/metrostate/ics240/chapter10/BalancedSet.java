/**
 * 
 */
package edu.metrostate.ics240.chapter10;

import java.util.Comparator;

/**
 * @author Vincent
 *
 */
public class BalancedSet<T extends Comparable<T>> extends BalancedTree<T> {

	/**
	 * 
	 */
	public BalancedSet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param minimumNumberOfItems
	 */
	public BalancedSet(int minimumNumberOfItems) {
		super(minimumNumberOfItems);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param minimumNumberOfItems
	 * @param comparator
	 */
	public BalancedSet(int minimumNumberOfItems, Comparator<T> comparator) {
		super(minimumNumberOfItems, comparator);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean looseAdd(int targetIndex, int compareResults, T entry) {
		boolean answer = false; 
		
		if (compareResults != 0) {
			answer = super.looseAdd(targetIndex, compareResults, entry);
		}
		
		return answer;
	}
	
	@Override
	protected void rebalanceRoot() {
		BalancedSet<T> child = new BalancedSet<>(minNumberOfItems, comparator);

		child.items = items;
		child.numberOfItems = numberOfItems;
		child.children = children;
		child.numberOfChildren = numberOfChildren;

		items = new Object[maxNumberOfItems + 1];
		numberOfItems = 0;
		children = new Object[maxNumberOfItems + 2];
		numberOfChildren = 0;

		insertChild(0, child);

		fixExcess(0);
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.BalancedTree#splitChild(edu.metrostate.ics240.chapter10.BalancedTree, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected BalancedTree<T> splitChild(BalancedTree<T> child, int index) {
		BalancedSet<T> right = new BalancedSet<>(minNumberOfItems, comparator);

		int itemMidpoint = child.numberOfItems / 2;
		T midpoint = (T) child.items[itemMidpoint];
		child.items[itemMidpoint] = null;
		
		// move the items to the node.
		moveRightHalfOfChild(child, right, itemMidpoint + 1, itemMidpoint);

		// Pass the middle child up to the root in the correct spot.
		insertItem(index, midpoint);

		return right;
	}
}

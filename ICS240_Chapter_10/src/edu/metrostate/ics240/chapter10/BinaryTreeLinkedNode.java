/**
 * File: BinaryTreeLinkedNode.java
 */
package edu.metrostate.ics240.chapter10;

/**
 *
 * @author Vincent J Palodichuk
 * 	<A HREF="mailto:hu0011wy@metrostate.edu"> (e-mail me) </A>
 *
 * @version 07/31/2017
 *
 */
public class BinaryTreeLinkedNode<T extends Comparable<T>> extends BinaryTreeNode<T> {
	private BinaryTreeLinkedNode<T> previous;
	
	/**
	 * @return the previous
	 */
	public BinaryTreeLinkedNode<T> getPrevious() {
		return previous;
	}

	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(BinaryTreeLinkedNode<T> previous) {
		this.previous = previous;
	}

	public BinaryTreeLinkedNode() {
		super(null, null, null, null);
		previous = null;
	}
	
	public BinaryTreeLinkedNode(T value, BinaryTreeLinkedNode<T> left, BinaryTreeLinkedNode<T> right) {
		super(value, null, left, right);
		previous = null;
	}
	
	public BinaryTreeLinkedNode(T value, BinaryTreeLinkedNode<T> parent, BinaryTreeLinkedNode<T> left, BinaryTreeLinkedNode<T> right) {
		super(value, parent, left, right);
		previous = null;
	}

	public BinaryTreeLinkedNode(T value, BinaryTreeLinkedNode<T> parent, BinaryTreeLinkedNode<T> left, BinaryTreeLinkedNode<T> right, BinaryTreeLinkedNode<T> previous) {
		super(value, parent, left, right);
		this.previous = previous;
	}
}

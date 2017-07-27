/**
 * File: BinaryTreeNode.java
 */
package edu.metrostate.ics240.chapter10;

/**
 * <p>
 * The BinaryTreeNode&lt;T&gt; provides a node for a binary tree with a reference
 * to a T object that implements the Comparable interface. The BinaryTreeNode&lt;T&gt;
 * implements the Comparable interface and as such can be used in a Binary Search Tree.
 * <p>
 * <b>Important Notes:</b>
 * <ul>
 * <li>T must implement the Comparable interface.</li>
 * <li>T should override Object.toString() so that the print and log methods
 * output useful information.</li>
 * <li>Beyond Int.MAX_VALUE elements, treeSize is wrong.</li>
 * </ul>
 * 
 * @author Vincent J Palodichuk
 * 	<A HREF="mailto:hu0011wy@metrostate.edu"> (e-mail me) </A>
 *
 * @version 07/14/2017
 *
 */
public class BinaryTreeNode<T extends Comparable<T>> implements TreeNode<T>, Comparable<BinaryTreeNode<T>> {
	private static final String INDENT = "    ";
	private static final String DASH = "--";
	private BinaryTreeNode<T> left, right, parent;
	private T value;

	/**
	 * Initializes this node with no value, no parent, and no links to child nodes.
	 * <p>
	 * <b>Postcondition:</b>
	 * <ul>
	 * <li>The new node contains no value, no parent, and no links to child nodes.</li>
	 * </ul>
	 */
	public BinaryTreeNode() {
		this(null, null, null, null);
	}
	
	/**
	 * Initializes this node with specified value and links to child nodes. All parameters may be null.
	 * <p>
	 * <b>Postcondition:</b>
	 * <ul>
	 * <li>The new node contains the specified value and links to child nodes.</li>
	 * </ul>
	 * 
	 * @param value
	 *  The initial value of the node.
	 * @param left
	 *  The initial left child.
	 * @param right
	 *  The initial right child.
	 */
	public BinaryTreeNode(final T value, final BinaryTreeNode<T> left, final BinaryTreeNode<T> right) {
		this(value, null, left, right);
	}
	
	/**
	 * Initializes this node with specified value, parent, and links to child nodes. All parameters may be null.
	 * <p>
	 * <b>Postcondition:</b>
	 * <ul>
	 * <li>The new node contains the specified value, parent, and links to child nodes.</li>
	 * </ul>
	 * 
	 * @param value
	 *  The initial value of the node.
	 * @param parent
	 *  The initial parent.
	 * @param left
	 *  The initial left child.
	 * @param right
	 *  The initial right child.
	 */
	public BinaryTreeNode(T value, BinaryTreeNode<T> parent, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
		this.value = value;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(final BinaryTreeNode<T> other) {
		if (other == null) {
			throw new NullPointerException("BinaryTreeNode.compareTo(other): - other cannot be null!");
		}
		
		int answer = compareTo(value, other.value);
		
		return answer;
	}
	
	/**
	 * A class helper method to compare two T objects.
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * @param value1
	 * @param value2
	 */
	private static <T extends Comparable<T>> int compareTo(final T value1, final T value2) {
		int answer = 0;
		
		// If only one argument is null
		if ((value1 == null) ^ (value2 == null)) {
			answer = (value1 == null) ? -1 : 1;
		} else if ((value1 == null) && (value2 == null)) { // both are null
			answer = 0;
		} else { // both are not null
			answer = value1.compareTo(value2);
		}
		
		return answer;
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.TreeNode#getLeft()
	 */
	@Override
	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.TreeNode#getRight()
	 */
	@Override
	public BinaryTreeNode<T> getRight() {
		return right;
	}

	/**
	 * An accessor method to get the value of the left most node of the tree
	 * below this node.
	 * 
	 * @return
	 *  The T value from the deepest node that can be reached from this node
	 *  following the left children.
	 */
	public T getLeftMostValue() {
		if (left == null) {
			return value;
		} else {
			return left.getLeftMostValue();
		}
	}
	
	/**
	 * An accessor method to get the value of the right most node of the tree
	 * below this node.
	 * 
	 * @return
	 *  The T value from the deepest node that can be reached from this node
	 *  following the right children.
	 */
	public T getRightMostValue() {
		if (right == null) {
			return value;
		} else {
			return right.getRightMostValue();
		}
	}
	
	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.TreeNode#getValue()
	 */
	@Override
	public T getValue() {
		return value;
	}
	
	/**
	 * Traverses the tree in-order to print the T value from each node at
	 * or below this node of the binary tree.
	 * <p>
	 * <b>Postcondition:</b>
	 * <ul>
	 * <li>The T value of this node and all its descendants have been
	 * written by System.out.println in in-order.</li>
	 * </ul>
	 */
	public void inorderPrint() {
		if (left != null) {
			left.inorderPrint();
		}
		
		System.out.println(value);
		
		if (right != null) {
			right.inorderPrint();
		}
	}
	
	public boolean isLeaf() {
		return (left == null) && (right == null);
	}
	
	/**
	 * Traverses the tree post-order to print the T value from each node at
	 * or below this node of the binary tree.
	 * <p>
	 * <b>Postcondition:</b>
	 * <ul>
	 * <li>The T value of this node and all its descendants have been
	 * written by System.out.println in post-order.</li>
	 * </ul>
	 */
	public void postorderPrint() {
		if (left != null) {
			left.postorderPrint();
		}
		
		if (right != null) {
			right.postorderPrint();
		}
		
		System.out.println(value);
	}
	
	/**
	 * Traverses the tree pre-order to print the T value from each node at
	 * or below this node of the binary tree.
	 * <p>
	 * <b>Postcondition:</b>
	 * <ul>
	 * <li>The T value of this node and all its descendants have been
	 * written by System.out.println in pre-order.</li>
	 * </ul>
	 */
	public void preorderPrint() {
		System.out.println(value);
		
		if (left != null) {
			left.preorderPrint();
		}
		
		if (right != null) {
			right.preorderPrint();
		}
	}
	
	/**
	 * Uses an in-order traversal to print the T value from each node at or
	 * below this node of the binary tree, with indentation to indicate the
	 * depth of each node.
	 * <p>
	 * <b>Postcondition:</b>
	 * <ul>
	 * <li>The T value of this node and all its descendants have been
	 * written by System.out.println using an in-order traversal.</li>
	 * <li>The indentation of each line of T values is four times its depth
	 * in the tree.</li>
	 * <li>A dash (--) is printed at any place where a child has no sibling.
	 * </li>
	 * </ul>
	 * <p>
	 * <b>Notes:</b>
	 * <ul>
	 * <li>Should be called from the root node to print the entire tree.</li>
	 * </ul>
	 */
	public void print() {
		print(0);
	}
	
	/**
	 * Uses an in-order traversal to print the T value from each node at or
	 * below this node of the binary tree, with indentation to indicate the
	 * depth of each node.
	 * <p>
	 * <b>Precondition:</b>
	 * <ul>
	 * <li>The parameter depth is equal to the depth of this node in the
	 * tree.</li>
	 * </ul>
	 * <p>
	 * <b>Postcondition:</b>
	 * <ul>
	 * <li>The T value of this node and all its descendants have been
	 * written by System.out.println using an in-order traversal.</li>
	 * <li>The indentation of each line of T values is four times its depth
	 * in the tree.</li>
	 * <li>A dash (--) is printed at any place where a child has no sibling.
	 * </li>
	 * </ul>
	 * 
	 * @param depth
	 *  The depth of this node (with 0 for the root, 1 for the root's
	 *  children,...,n for the nth children).
	 */
	public void print(int depth) {
		int i;
		
		// Print the indentation and the data from the current node:
		for (i = 1; i <= depth; i++) {
			System.out.print(INDENT);
		}
		
		System.out.println(value);
		
		// Print the left subtree (or a dash if there is a right child and no left child).
		if (left != null) {
			left.print(depth + 1);
		} else if (right != null) {
			for (i = 1; i <= depth; i++) {
				System.out.print(INDENT);
			}
			
			System.out.println(DASH);
		}
		
		// Print the right subtree (or a dash if there is a left child and no right child).
		if (right != null) {
			right.print(depth + 1);
		} else if (left != null) {
			for (i = 1; i <= depth; i++) {
				System.out.print(INDENT);
			}
			
			System.out.println(DASH);
		}
	}
	
	/**
	 * Remove the left most node of the tree with this node as its root.
	 * <p>
	 * <b>Postcondition:</b>
	 * <ul>
	 * <li>The tree starting at this node has had its left most node (i.e.,
	 * the deepest node that can be reached by following left children)
	 * removed.</li>
	 * <li>The return value is a reference to the root of the new (smaller)
	 * tree.</li>
	 * <li>This return value could be null if the original tree has only
	 * one node (since that one node has now been removed).</li>
	 * </ul>
	 * <p>
	 * <b>Example:</b><br>
	 * <code>
	 * BinaryTreeNode&lt;String&gt; root = new BinaryTreeNode&lt;&gt;();<br>
	 * <br>
	 * // Build up a small binary tree of names.<br>
	 * root.setLeft(new BinaryTreeNode&lt;&gt;("Mary", null, null));<br>
	 * root.setRight(new BinaryTreeNode&lt;&gt;("Nancy", null, null));<br>
	 * root.getLeft().setLeft(new BinaryTreeNode&lt;&gt;("Laura", null, null));<br>
	 * root.getLeft().setRight(new BinaryTreeNode&lt;&gt;("Mindy", null, null));<br>
	 * root.getRight().setLeft(new BinaryTreeNode&lt;&gt;("Miranda", null, null));<br>
	 * root.getRight().setRight(new BinaryTreeNode&lt;&gt;("Oprah", null, null));<br>
	 * <br>
	 * // Remove Miranda from the tree.<br>
	 * root.setRight(root.getRight().removeLeftMost());<br>
	 * </code>
	 * @return
	 *  A reference to the root of the new (smaller) tree.
	 */
	public BinaryTreeNode<T> removeLeftMost() {
		if (left == null) { // The left most node is at the root because there is no left child.
			return right;
		} else { // A recursive call removes the left most node from this node's left child.
			left = left.removeLeftMost();
			return this;
		}
	}
	
	/**
	 * Remove the right most node of the tree with this node as its root.
	 * <p>
	 * <b>Postcondition:</b>
	 * <ul>
	 * <li>The tree starting at this node has had its right most node (i.e.,
	 * the deepest node that can be reached by following right children)
	 * removed.</li>
	 * <li>The return value is a reference to the root of the new (smaller)
	 * tree.</li>
	 * <li>This return value could be null if the original tree has only
	 * one node (since that one node has now been removed).</li>
	 * </ul>
	 * <p>
	 * <b>Example:</b><br>
	 * <code>
	 * BinaryTreeNode&lt;String&gt; root = new BinaryTreeNode&lt;&gt;();<br>
	 * <br>
	 * // Build up a small binary tree of names.<br>
	 * root.setLeft(new BinaryTreeNode&lt;&gt;("Mary", null, null));<br>
	 * root.setRight(new BinaryTreeNode&lt;&gt;("Nancy", null, null));<br>
	 * root.getLeft().setLeft(new BinaryTreeNode&lt;&gt;("Laura", null, null));<br>
	 * root.getLeft().setRight(new BinaryTreeNode&lt;&gt;("Mindy", null, null));<br>
	 * root.getRight().setLeft(new BinaryTreeNode&lt;&gt;("Miranda", null, null));<br>
	 * root.getRight().setRight(new BinaryTreeNode&lt;&gt;("Oprah", null, null));<br>
	 * <br>
	 * // Remove Mindy from the tree.<br>
	 * root.setLeft(root.getLeft().removeRightMost());<br>
	 * </code>
	 * @return
	 *  A reference to the root of the new (smaller) tree.
	 */
	public BinaryTreeNode<T> removeRightMost() {
		if (right == null) { // The right most node is at the root because there is no right child.
			return left;
		} else { // A recursive call removes the right most node from this node's right child.
			right = right.removeRightMost();
			return this;
		}
	}
	
	/**
	 * Copy a binary tree.
	 * 
	 * @param source
	 *  A reference to the root node of the tree to copy. source may be null. 
	 * @param <T>
	 *  The type of the value stored in the binary tree.
	 * @return
	 *  A reference to the root node of the new tree starting at source.
	 * @throws OutOfMemoryError
	 *  Indicates that there is insufficient memory for the new tree.  
	 */
	public static <T extends Comparable<T>> BinaryTreeNode<T> treeCopy(BinaryTreeNode<T> source) {
		BinaryTreeNode<T> leftCopy, rightCopy;
		
		if (source == null) {
			return null;
		} else {
			leftCopy = treeCopy(source.left);
			rightCopy = treeCopy(source.right);
			return new BinaryTreeNode<T>(source.value, leftCopy, rightCopy);
		}		
	}
	
	/**
	 * Computes the actual number of nodes in a binary tree.
	 * <p>
	 * <b>Note:</b>
	 * <ul>
	 * <li>A wrong answer occurs for trees larger than Int.MAX_VALUE.</li>
	 * </ul>
	 * 
	 * @param root
	 *  The reference to the root of a binary tree (which may be an empty
	 *  tree with a null root).
	 * @param <T>
	 *  The type of the value stored in the binary tree.
	 * @return
	 *  The actual number of nodes in the tree with the given root node.
	 */
	public static <T extends Comparable<T>> int treeSize(TreeNode<T> root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + treeSize(root.getLeft()) + treeSize(root.getRight());
		}
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.TreeNode#getParent()
	 */
	@Override
	public TreeNode<T> getParent() {
		return parent;
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.TreeNode#setLeft(edu.metrostate.ics240.chapter10.TreeNode)
	 */
	@Override
	public void setLeft(TreeNode<T> left) {
		this.left = (BinaryTreeNode<T>) left;
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.TreeNode#setParent(edu.metrostate.ics240.chapter10.TreeNode)
	 */
	@Override
	public void setParent(TreeNode<T> parent) {
		this.parent = (BinaryTreeNode<T>) parent;
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.TreeNode#setRight(edu.metrostate.ics240.chapter10.TreeNode)
	 */
	@Override
	public void setRight(TreeNode<T> right) {
		this.right = (BinaryTreeNode<T>) right;
	}

	/* (non-Javadoc)
	 * @see edu.metrostate.ics240.chapter10.TreeNode#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(T value) {
		this.value = value;
	}
}

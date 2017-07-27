/**
 * File: BinaryTreeNodeTest.java
 */
package edu.metrostate.ics240.chapter10;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author Vincent J Palodichuk
 * 	<A HREF="mailto:hu0011wy@metrostate.edu"> (e-mail me) </A>
 *
 * @version 07/16/2017
 *
 */
public class BinaryTreeNodeTest {

	@Test
	public final void testNode() {
		BinaryTreeNode<String> root = new BinaryTreeNode<>();
		
		assertTrue(BinaryTreeNode.treeSize(root) == 1);
		
		// Build up a small full binary tree of names.
		root.setLeft(new BinaryTreeNode<>("Mary", null, null));
		root.setRight(new BinaryTreeNode<>("Nancy", null, null));
		root.getLeft().setLeft(new BinaryTreeNode<>("Laura", null, null));
		root.getLeft().setRight(new BinaryTreeNode<>("Mindy", null, null));
		root.getRight().setLeft(new BinaryTreeNode<>("Miranda", null, null));
		root.getRight().setRight(new BinaryTreeNode<>("Oprah", null, null));
		
		assertTrue(BinaryTreeNode.treeSize(root) == 7);
		
		// Remove Miranda from the tree.
		root.setRight(root.getRight().removeLeftMost());
		
		// Remove Mindy from the tree.
		root.setLeft(root.getLeft().removeRightMost());
		
		// Remove Laura from the tree.
		root.removeLeftMost();
		
		assertTrue(BinaryTreeNode.treeSize(root) == 4);		
	}
}

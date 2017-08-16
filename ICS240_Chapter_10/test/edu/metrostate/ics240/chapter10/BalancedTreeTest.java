package edu.metrostate.ics240.chapter10;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.Random;

import org.junit.Test;

public class BalancedTreeTest {

	@Test
	public void testTest() {
		final long SEED = 20170815;
		final Random random = new Random(SEED);
		
		final int MINIMUM = 2;
		final int NUM_NUMBERS = 100;
		
		BalancedTree<Integer> intTree = new BalancedTree<>(MINIMUM);
		
		assertEquals(0, intTree.getNumberOfItems());
		assertTrue(intTree.add(6));
		assertEquals(1, intTree.getNumberOfItems());
		assertTrue(intTree.contains(6));
		assertTrue(intTree.add(9));
		assertEquals(2, intTree.getNumberOfItems());
		assertTrue(intTree.contains(9));
		assertTrue(intTree.add(3));
		assertEquals(3, intTree.getNumberOfItems());
		assertTrue(intTree.contains(3));
		
		for (int i = 0; i < NUM_NUMBERS; i++) {
			intTree.add(random.nextInt());
		}
		
		assertTrue(intTree.contains(9));
	}
	
	@Test
	public void testBuildSmallTree() {
		final long SEED = 20170815;
		final Random random = new Random(SEED);
		
		final int MINIMUM = 1;
		final int NUM_NUMBERS = 20;
		
		BalancedTree<Integer> intTree = new BalancedTree<>(MINIMUM);

		for (int i = 0; i < NUM_NUMBERS; i++) {
			int nextNumber = random.nextInt(NUM_NUMBERS); 
			intTree.add(nextNumber);
			System.out.println(String.format("%d has been added to the BalancedTree<T>", nextNumber));
			intTree.print(0);
		}
		
		System.out.println("Here is the BalancedTree<T>:");
		intTree.print(0);
	}
	
	@Test
	public void testRemoveSmallTree() {
		final long SEED = 20170815;
		final Random random = new Random(SEED);
		
		final int MINIMUM = 2;
		final int NUM_NUMBERS = 40;
		
		BalancedTree<Integer> intTree = new BalancedTree<>(MINIMUM);

		for (int i = 0; i < NUM_NUMBERS; i++) {
			int nextNumber = random.nextInt(NUM_NUMBERS); 
			intTree.add(nextNumber);
			System.out.println(String.format("%d has been added to the BalancedTree<T>", nextNumber));
			intTree.print(0);
		}
		
		while (intTree.getNumberOfItems() > 0) {
			int nextNumber = random.nextInt(NUM_NUMBERS); 
			if (intTree.remove(nextNumber)) {
				System.out.println(String.format("%d has been removed from the BalancedTree<T>", nextNumber));
				intTree.print(0);
			}
		}
		
		System.out.println("Here is the BalancedTree<T>:");
		intTree.print(0);
	}
	
	@Test
	public void testRemoveSmallComparatorTree() {
		final long SEED = 20170815;
		final Random random = new Random(SEED);
		
		final int MINIMUM = 2;
		final int NUM_NUMBERS = 20;
		final int NULL_LOOP = 3;
		
		BalancedTree<Integer> intTree = new BalancedTree<Integer>(MINIMUM, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				int answer = -1;
				
				if (a == null && b == null) {
					answer = 0;
				} else if ((a == null) ^ (b == null)) {
					answer = (a == null) ? -1 : 1;
				} else {
					answer = a.compareTo(b);
				}
				return answer;
			}
		});

		for (int i = 0; i < NUM_NUMBERS; i++) {
			int nextNumber = random.nextInt(NUM_NUMBERS); 
			intTree.add(nextNumber);
			System.out.println(String.format("%d has been added to the BalancedTree<T>", nextNumber));
			intTree.print(0);
		}
		
		while (intTree.getNumberOfItems() > 0) {
			int nextNumber = random.nextInt(NUM_NUMBERS); 
			if (intTree.remove(nextNumber)) {
				System.out.println(String.format("%d has been removed from the BalancedTree<T>", nextNumber));
				intTree.print(0);
			}
		}
		
		for (int i = 0; i < NUM_NUMBERS; i++) {
			int nextNumber = random.nextInt(NUM_NUMBERS); 
			
			if (i % NULL_LOOP == 0) {
				intTree.add(null);
				String temp = null;
				System.out.println(String.format("%s has been added to the BalancedTree<T>", temp));
			}
			intTree.add(nextNumber);
			System.out.println(String.format("%d has been added to the BalancedTree<T>", nextNumber));
			intTree.print(0);
		}
		
		int i = 0;
		
		while (intTree.getNumberOfItems() > 0) {
			int nextNumber = random.nextInt(NUM_NUMBERS);
			
			if (i++ % NULL_LOOP == 0 && intTree.remove(null)) {
				String temp = null;
				System.out.println(String.format("%s has been removed from the BalancedTree<T>", temp));
			}
			
			if (intTree.remove(nextNumber)) {
				System.out.println(String.format("%d has been removed from the BalancedTree<T>", nextNumber));
				intTree.print(0);
			}
		}
		
		System.out.println("Here is the BalancedTree<T>:");
		intTree.print(0);
	}
}

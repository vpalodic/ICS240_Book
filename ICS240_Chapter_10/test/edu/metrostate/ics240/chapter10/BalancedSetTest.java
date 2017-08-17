package edu.metrostate.ics240.chapter10;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.Random;

import org.junit.Test;

public class BalancedSetTest {
	@Test
	public void testPrintSets() {
		final long SEED = 20170815;
		final int MINIMUM = 12;
		final int NUM_NUMBERS = 4096;
		
		long start = System.nanoTime();
		
		System.out.println();
		System.out.println("Begin BalancedSet Printint Test...");
		System.out.println();
		System.out.println("Testing Printing String Sets Using A Comparator<String>");
		System.out.println();
		
		testPrintComparatorStringSet(SEED, MINIMUM, NUM_NUMBERS);
		
		System.out.println();
		System.out.println("Testing Printing String Sets Using Natural Ordering");
		System.out.println();
		
		testPrintStringSet(SEED, MINIMUM, NUM_NUMBERS);
		
		System.out.println();
		System.out.println("Testing Printing Integer Sets Using A Comparator<Integer>");
		System.out.println();
		
		testPrintComparatorIntegerSet(SEED, MINIMUM, NUM_NUMBERS);
		
		System.out.println();
		System.out.println("Testing Printing Integer Sets Using Natural Ordering");
		System.out.println();
		
		testPrintIntegerSet(SEED, MINIMUM, NUM_NUMBERS);
		
		System.out.println();
		
		long elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to perform the BalancedSet Printing Test!", (elapsed / 1E9)));
		System.out.println();
	}
	
	@Test
	public void testRemoveSets() {
		final long SEED = 20170815;
		final int MINIMUM = 19;
		final int NUM_NUMBERS = 1_000_000;
		
		long start = System.nanoTime();
		System.out.println();
		System.out.println("Begin BalancedSet Removing Test...");
		System.out.println();
		System.out.println("Testing Removing String Sets Using A Comparator<String>");
		System.out.println();
		testRemoveComparatorStringSet(SEED, MINIMUM, NUM_NUMBERS);
		System.out.println();
		System.out.println("Testing Removing String Sets Using Natural Ordering");
		System.out.println();
		testRemoveStringSet(SEED, MINIMUM, NUM_NUMBERS);
		System.out.println();
		System.out.println("Testing Removing Integer Sets Using A Comparator<Integer>");
		System.out.println();
		testRemoveComparatorIntegerSet(SEED, MINIMUM, NUM_NUMBERS);
		System.out.println();
		System.out.println("Testing Removing Integer Sets Using Natural Ordering");
		System.out.println();
		testRemoveIntegerSet(SEED, MINIMUM, NUM_NUMBERS);
		System.out.println();
		long elapsed = System.nanoTime() - start;
		System.out.println(String.format("It took %,f seconds to perform the BalancedSet Removing Test!", (elapsed / 1E9)));
		System.out.println();
	}
	
	@Test
	public void testSearchSets() {
		final long SEED = 20170815;
		final int MINIMUM = 19;
		final int NUM_NUMBERS = 1_000_000;
		
		long start = System.nanoTime();
		System.out.println();
		System.out.println("Begin BalancedSet Searching Test...");
		System.out.println();
		System.out.println("Testing Searching String Sets Using A Comparator<String>");
		System.out.println();
		testSearchComparatorStringSet(SEED, MINIMUM, NUM_NUMBERS);
		System.out.println();
		System.out.println("Testing Searching String Sets Using Natural Ordering");
		System.out.println();
		testSearchStringSet(SEED, MINIMUM, NUM_NUMBERS);
		System.out.println();
		System.out.println("Testing Searching Integer Sets Using A Comparator<Integer>");
		System.out.println();
		testSearchComparatorIntegerSet(SEED, MINIMUM, NUM_NUMBERS);
		System.out.println();
		System.out.println("Testing Searching Integer Sets Using Natural Ordering");
		System.out.println();
		testSearchIntegerSet(SEED, MINIMUM, NUM_NUMBERS);
		System.out.println();
		long elapsed = System.nanoTime() - start;
		System.out.println(String.format("It took %,f seconds to perform the BalancedSet Searching Test!", (elapsed / 1E9)));
		System.out.println();
	}
	
	private void testPrintComparatorStringSet(long seed, int min, int num) {
		final int MINIMUM = min;
		final int NUM_NUMBERS = num;
		
		BalancedSet<String> intSet = new BalancedSet<String>(MINIMUM, new AlphanumComparator());

		long start = 0;
		long elapsed = 0;
		
		assertNotNull(intSet);
		
		int i = NUM_NUMBERS;
		int j = 0;
		
		System.out.println(String.format("Building a BalancedSet with an AlphanumComparator() of %,d Strings using sequential calls in reverse.", NUM_NUMBERS));
		
		start = System.nanoTime();
		
		while (i > 0) {
			int nextNumber = i;
			j++;
			if (intSet.add(String.format("%d", nextNumber))) {
				i--;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d sequential calls in reverse to create the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
		
		intSet.add(null);
		
		start = System.nanoTime();
		assertTrue(intSet.contains(null));
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to perform a search for null in a sea of %,d numbers.", (elapsed / 1E9), NUM_NUMBERS));
		
		start = System.nanoTime();
		
		for (i = NUM_NUMBERS, j = 0; i > 0; i--) {
			if (intSet.contains(String.format("%d", i))) {
				j++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to perform %,d searches with %,d hits for all %,d numbers.", (elapsed / 1E9), NUM_NUMBERS, j, NUM_NUMBERS));
		
		System.out.println();
		System.out.println("The wonderful B-tree inorder traversal:");
		System.out.println();
		intSet.inorderPrint();
		System.out.println();
		
		System.out.println();
		System.out.println("The wonderful B-tree preorder traversal:");
		System.out.println();
		intSet.print(0);
	}

	private void testPrintStringSet(long seed, int min, int num) {
		final int MINIMUM = min;
		final int NUM_NUMBERS = num;
		
		BalancedSet<String> intSet = new BalancedSet<String>(MINIMUM);

		long start = 0;
		long elapsed = 0;
		
		assertNotNull(intSet);
		
		int i = 0;
		int j = 0;
		
		System.out.println(String.format("Building a BalancedSet of %,d Strings using sequential calls.", NUM_NUMBERS));
		
		start = System.nanoTime();
		
		while (i < NUM_NUMBERS) {
			int nextNumber = i;
			j++;
			if (intSet.add(String.format("%d", nextNumber))) {
				i++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d sequential calls to create the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
		
		start = System.nanoTime();
		
		for (i = 0, j = 0; i < NUM_NUMBERS; i++) {
			if (intSet.contains(String.format("%d", i))) {
				j++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to perform %,d searches with %,d hits for all %,d numbers.", (elapsed / 1E9), NUM_NUMBERS, j, NUM_NUMBERS));
		
		System.out.println();
		System.out.println("The wonderful B-tree inorder traversal:");
		System.out.println();
		intSet.inorderPrint();
		System.out.println();
		
		System.out.println();
		System.out.println("The wonderful B-tree preorder traversal:");
		System.out.println();
		intSet.print(0);
	}
	
	private void testPrintComparatorIntegerSet(long seed, int min, int num) {
		final int MINIMUM = min;
		final int NUM_NUMBERS = num;
		
		BalancedSet<Integer> intSet = new BalancedSet<Integer>(MINIMUM, new Comparator<Integer>() {
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

		long start = 0;
		long elapsed = 0;
		
		assertNotNull(intSet);
		
		int i = 0;
		int j = 0;
		
		System.out.println(String.format("Building a BalancedSet with a Comparator<Integer> of %,d Integers using sequential calls.", NUM_NUMBERS));
		
		start = System.nanoTime();
		
		while (i < NUM_NUMBERS) {
			int nextNumber = i;
			j++;
			if (intSet.add(nextNumber)) {
				i++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d sequential calls to create the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
		
		intSet.add(null);
		
		start = System.nanoTime();
		assertTrue(intSet.contains(null));
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to perform a search for null in a sea of %,d numbers.", (elapsed / 1E9), NUM_NUMBERS));
		
		start = System.nanoTime();
		
		for (i = 0, j = 0; i < NUM_NUMBERS; i++) {
			if (intSet.contains(i)) {
				j++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to perform %,d searches with %,d hits for all %,d numbers.", (elapsed / 1E9), NUM_NUMBERS, j, NUM_NUMBERS));
		
		System.out.println();
		System.out.println("The wonderful B-tree inorder traversal:");
		System.out.println();
		intSet.inorderPrint();
		System.out.println();
		
		System.out.println();
		System.out.println("The wonderful B-tree preorder traversal:");
		System.out.println();
		intSet.print(0);
	}

	private void testPrintIntegerSet(long seed, int min, int num) {
		final int MINIMUM = min;
		final int NUM_NUMBERS = num;
		
		long start = 0;
		long elapsed = 0;
		
		BalancedSet<Integer> intSet = new BalancedSet<Integer>(MINIMUM);

		assertNotNull(intSet);
		
		int i = NUM_NUMBERS;
		int j = 0;
		
		System.out.println(String.format("Building a BalancedSet of %,d Integers using sequential calls in reverse order.", NUM_NUMBERS));
		
		start = System.nanoTime();
		
		while (i > 0) {
			int nextNumber = i;
			j++;
			if (intSet.add(nextNumber)) {
				i--;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d sequential calls in reverse order to create the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
		
		start = System.nanoTime();
		
		for (i = NUM_NUMBERS, j = 0; i > 0; i--) {
			if (intSet.contains(i)) {
				j++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to perform %,d searches with %,d hits for all %,d numbers.", (elapsed / 1E9), NUM_NUMBERS, j, NUM_NUMBERS));
		
		System.out.println();
		System.out.println("The wonderful B-tree inorder traversal:");
		System.out.println();
		intSet.inorderPrint();
		System.out.println();
		
		System.out.println();
		System.out.println("The wonderful B-tree preorder traversal:");
		System.out.println();
		intSet.print(0);
	}
	
	private void testRemoveComparatorIntegerSet(long seed, int min, int num) {
		final long SEED = seed;
		final Random random = new Random(SEED);
		
		final int MINIMUM = min;
		final int NUM_NUMBERS = num;
		
		BalancedSet<Integer> intSet = new BalancedSet<Integer>(MINIMUM, new Comparator<Integer>() {
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

		assertNotNull(intSet);
		
		int i = 0;
		int j = 0;
		long start = 0;
		long elapsed = 0;
		
		System.out.println(String.format("Building a BalancedSet with a Comparator<Integers> of %,d Integers using a random number generator...", NUM_NUMBERS));

		start = System.nanoTime();
		
		while (i < NUM_NUMBERS) {
			int nextNumber = random.nextInt(NUM_NUMBERS);
			j++;
			if (intSet.add(nextNumber)) {
				i++;
			}
		}
		
		elapsed = System.nanoTime() - start;

		System.out.println(String.format("It took %,f seconds to make %,03d random generator calls to create the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
		
		j = 0;
		
		start = System.nanoTime();
		
		while (intSet.getNumberOfItems() > 0) {
			int nextNumber = random.nextInt(NUM_NUMBERS); 
			intSet.remove(nextNumber);
			j++;
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d random generator calls to delete the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
		
		i = 0;
		j = 0;
		
		System.out.println(String.format("Building a BalancedSet with a Comparator<Integers> of %,d Integers using sequential calls.", NUM_NUMBERS));

		start = System.nanoTime();
		
		while (i < NUM_NUMBERS) {
			int nextNumber = i; 
			
			if (intSet.add(nextNumber)) {
				i++;
			}
			j++;
		}
		
		elapsed = System.nanoTime() - start;
		
		intSet.add(null);
		
		System.out.println(String.format("It took %,f seconds to make %,03d sequential calls to create the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));

		start = System.nanoTime();
		assertTrue(intSet.contains(null));
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to perform a search for null in a sea of %,d numbers.", (elapsed / 1E9), NUM_NUMBERS));
		
		start = System.nanoTime();
		
		for (i = 0, j = 0; i < NUM_NUMBERS; i++) {
			if (intSet.contains(i)) {
				j++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to perform %,d searches with %,d hits for all %,d numbers.", (elapsed / 1E9), NUM_NUMBERS, j, NUM_NUMBERS));
		
		j = 0;
		
		intSet.remove(null);
		
		start = System.nanoTime();
		
		while (intSet.getNumberOfItems() > 0) {
			int nextNumber = random.nextInt(NUM_NUMBERS);
			
			intSet.remove(nextNumber);
			j++;
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d random generator calls to delete the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
	}
	
	private void testRemoveComparatorStringSet(long seed, int min, int num) {
		final long SEED = seed;
		final Random random = new Random(SEED);
		
		final int MINIMUM = min;
		final int NUM_NUMBERS = num;
		
		BalancedSet<String> intSet = new BalancedSet<String>(MINIMUM, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
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

		assertNotNull(intSet);
		
		int i = 0;
		int j = 0;
		long start = 0;
		long elapsed = 0;
		
		System.out.println(String.format("Building a BalancedSet with a Comparator<String> of %,d Strings using a random number generator...", NUM_NUMBERS));
		
		start = System.nanoTime();
		
		while (i < NUM_NUMBERS) {
			int nextNumber = random.nextInt(NUM_NUMBERS);
			j++;
			if (intSet.add(String.format("%010d", nextNumber))) {
				i++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d random generator calls to create the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
		
		j = 0;
		
		start = System.nanoTime();
		
		while (intSet.getNumberOfItems() > 0) {
			int nextNumber = random.nextInt(NUM_NUMBERS); 
			intSet.remove(String.format("%010d", nextNumber));
			j++;
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d random generator calls to delete the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));

		i = 0;
		j = 0;
		
		System.out.println(String.format("Building a BalancedSet with a Comparator<String> of %,d Strings using sequential calls...", NUM_NUMBERS));
		
		start = System.nanoTime();
		
		while (i < NUM_NUMBERS) {
			int nextNumber = i; 
			
			if (intSet.add(String.format("%010d", nextNumber))) {
				i++;
			}
			j++;
		}
		
		elapsed = System.nanoTime() - start;
		
		intSet.add(null);
		
		System.out.println(String.format("It took %,f seconds to make %,03d sequential calls to create the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));

		start = System.nanoTime();
		assertTrue(intSet.contains(null));
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to perform a search for null in a sea of %,d numbers.", (elapsed / 1E9), NUM_NUMBERS));
		
		start = System.nanoTime();	
		
		for (i = 0, j = 0; i < NUM_NUMBERS; i++) {
			if (intSet.contains(String.format("%010d", i))) {
				j++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to perform %,d searches with %,d hits for all %,d numbers.", (elapsed / 1E9), NUM_NUMBERS, j, NUM_NUMBERS));
		
		j = 0;
		
		intSet.remove(null);
		
		start = System.nanoTime();
		
		while (intSet.getNumberOfItems() > 0) {
			int nextNumber = random.nextInt(NUM_NUMBERS);
			
			intSet.remove(String.format("%010d", nextNumber));
			j++;
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d random generator calls to delete the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
	}
	
	private void testRemoveIntegerSet(long seed, int min, int num) {
		final long SEED = seed;
		final Random random = new Random(SEED);
		
		final int MINIMUM = min;
		final int NUM_NUMBERS = num;
		
		BalancedSet<Integer> intSet = new BalancedSet<Integer>(MINIMUM);

		assertNotNull(intSet);
		
		int i = 0;
		int j = 0;
		long start = 0;
		long elapsed = 0;
		
		System.out.println(String.format("Building a BalancedSet of %,d Integerss using a random number generator...", NUM_NUMBERS));

		start = System.nanoTime();	
		
		while (i < NUM_NUMBERS) {
			int nextNumber = random.nextInt(NUM_NUMBERS);
			j++;
			if (intSet.add(nextNumber)) {
				i++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d random generator calls to create the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
		
		j = 0;
		
		start = System.nanoTime();	
		
		while (intSet.getNumberOfItems() > 0) {
			int nextNumber = random.nextInt(NUM_NUMBERS); 
			intSet.remove(nextNumber);
			j++;
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d random generator calls to delete the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
		
		i = 0;
		j = 0;
		
		System.out.println(String.format("Building a BalancedSet of %,d Integers using sequential calls...", NUM_NUMBERS));
		
		start = System.nanoTime();	
		
		while (i < NUM_NUMBERS) {
			int nextNumber = i; 
			
			if (intSet.add(nextNumber)) {
				i++;
			}
			j++;
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d sequential calls to create the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));

		start = System.nanoTime();
		
		for (i = 0, j = 0; i < NUM_NUMBERS; i++) {
			if (intSet.contains(i)) {
				j++;
			}
		}
		
		elapsed = System.nanoTime() - start;
				
		System.out.println(String.format("It took %,f seconds to perform %,d searches with %,d hits for all %,d numbers.", (elapsed / 1E9), NUM_NUMBERS, j, NUM_NUMBERS));
		
		j = 0;
		
		start = System.nanoTime();
		
		while (intSet.getNumberOfItems() > 0) {
			int nextNumber = random.nextInt(NUM_NUMBERS);
			
			intSet.remove(nextNumber);
			j++;
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d random generator calls to delete the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
	}
	
	private void testRemoveStringSet(long seed, int min, int num) {
		final long SEED = seed;
		final Random random = new Random(SEED);
		
		final int MINIMUM = min;
		final int NUM_NUMBERS = num;
		
		BalancedSet<String> intSet = new BalancedSet<String>(MINIMUM);

		assertNotNull(intSet);
		
		int i = 0;
		int j = 0;
		long start = 0;
		long elapsed = 0;

		System.out.println(String.format("Building a BalancedSet of %,d Strings using a random number generator...", NUM_NUMBERS));
		
		start = System.nanoTime();	
		
		while (i < NUM_NUMBERS) {
			int nextNumber = random.nextInt(NUM_NUMBERS);
			j++;
			if (intSet.add(String.format("%,d", nextNumber))) {
				i++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d random generator calls to create the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
		
		j = 0;
		
		start = System.nanoTime();	
		
		while (intSet.getNumberOfItems() > 0) {
			int nextNumber = random.nextInt(NUM_NUMBERS); 
			intSet.remove(String.format("%,d", nextNumber));
			j++;
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d random generator calls to delete the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
		
		i = 0;
		j = 0;
		
		System.out.println(String.format("Building a BalancedSet of %,d Strings using sequential calls...", NUM_NUMBERS));
		
		start = System.nanoTime();	
		
		while (i < NUM_NUMBERS) {
			int nextNumber = i; 
			
			if (intSet.add(String.format("%,d", nextNumber))) {
				i++;
			}
			j++;
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d sequential calls to create the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));

		start = System.nanoTime();	
		
		for (i = 0, j = 0; i < NUM_NUMBERS; i++) {
			if (intSet.contains(String.format("%,d", i))) {
				j++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to perform %,d searches with %,d hits for all %,d numbers.", (elapsed / 1E9), NUM_NUMBERS, j, NUM_NUMBERS));
		
		j = 0;
		
		start = System.nanoTime();
		
		while (intSet.getNumberOfItems() > 0) {
			int nextNumber = random.nextInt(NUM_NUMBERS);
			
			intSet.remove(String.format("%,d", nextNumber));
			j++;
		}

		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d random generator calls to delete the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
	}
	
	private void testSearchComparatorStringSet(long seed, int min, int num) {
		final long SEED = seed;
		final Random random = new Random(SEED);
		
		final int MINIMUM = min;
		final int NUM_NUMBERS = num;
		
		BalancedSet<String> intSet = new BalancedSet<String>(MINIMUM, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
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

		long start = 0;
		long elapsed = 0;
		
		assertNotNull(intSet);
		
		int i = 0;
		int j = 0;
		
		System.out.println(String.format("Building a BalancedSet with a Comparator<String> of %,d Strings using a random number generator...", NUM_NUMBERS));
		
		start = System.nanoTime();
		
		while (i < NUM_NUMBERS) {
			int nextNumber = random.nextInt(NUM_NUMBERS);
			j++;
			if (intSet.add(String.format("%,d", nextNumber))) {
				i++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d random generator calls to create the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
		
		intSet.add(null);
		
		start = System.nanoTime();
		assertTrue(intSet.contains(null));
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to perform a search for null in a sea of %,d numbers.", (elapsed / 1E9), NUM_NUMBERS));
		
		start = System.nanoTime();
		
		for (i = 0, j = 0; i < NUM_NUMBERS; i++) {
			if (intSet.contains(String.format("%,d", i))) {
				j++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to perform %,d searches with %,d hits for all %,d numbers.", (elapsed / 1E9), NUM_NUMBERS, j, NUM_NUMBERS));
	}

	private void testSearchStringSet(long seed, int min, int num) {
		final long SEED = seed;
		final Random random = new Random(SEED);
		
		final int MINIMUM = min;
		final int NUM_NUMBERS = num;
		
		BalancedSet<String> intSet = new BalancedSet<String>(MINIMUM);

		long start = 0;
		long elapsed = 0;
		
		assertNotNull(intSet);
		
		int i = 0;
		int j = 0;
		
		System.out.println(String.format("Building a BalancedSet of %,d Strings using a random number generator...", NUM_NUMBERS));
		
		start = System.nanoTime();
		
		while (i < NUM_NUMBERS) {
			int nextNumber = random.nextInt(NUM_NUMBERS);
			j++;
			if (intSet.add(String.format("%,d", nextNumber))) {
				i++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d random generator calls to create the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
		
		start = System.nanoTime();
		
		for (i = 0, j = 0; i < NUM_NUMBERS; i++) {
			if (intSet.contains(String.format("%,d", i))) {
				j++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to perform %,d searches with %,d hits for all %,d numbers.", (elapsed / 1E9), NUM_NUMBERS, j, NUM_NUMBERS));
	}
	
	private void testSearchComparatorIntegerSet(long seed, int min, int num) {
		final long SEED = seed;
		final Random random = new Random(SEED);
		
		final int MINIMUM = min;
		final int NUM_NUMBERS = num;
		
		BalancedSet<Integer> intSet = new BalancedSet<Integer>(MINIMUM, new Comparator<Integer>() {
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

		long start = 0;
		long elapsed = 0;
		
		assertNotNull(intSet);
		
		int i = 0;
		int j = 0;
		
		System.out.println(String.format("Building a BalancedSet with a Comparator<Integer> of %,d Integers using a random number generator...", NUM_NUMBERS));
		
		start = System.nanoTime();
		
		while (i < NUM_NUMBERS) {
			int nextNumber = random.nextInt(NUM_NUMBERS);
			j++;
			if (intSet.add(nextNumber)) {
				i++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d random generator calls to create the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
		
		intSet.add(null);
		
		start = System.nanoTime();
		assertTrue(intSet.contains(null));
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to perform a search for null in a sea of %,d numbers.", (elapsed / 1E9), NUM_NUMBERS));
		
		start = System.nanoTime();
		
		for (i = 0, j = 0; i < NUM_NUMBERS; i++) {
			if (intSet.contains(i)) {
				j++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to perform %,d searches with %,d hits for all %,d numbers.", (elapsed / 1E9), NUM_NUMBERS, j, NUM_NUMBERS));
	}

	private void testSearchIntegerSet(long seed, int min, int num) {
		final long SEED = seed;
		final Random random = new Random(SEED);
		
		final int MINIMUM = min;
		final int NUM_NUMBERS = num;
		
		long start = 0;
		long elapsed = 0;
		
		BalancedSet<Integer> intSet = new BalancedSet<Integer>(MINIMUM);

		assertNotNull(intSet);
		
		int i = 0;
		int j = 0;
		
		System.out.println(String.format("Building a BalancedSet of %,d Integers using a random number generator...", NUM_NUMBERS));
		
		start = System.nanoTime();
		
		while (i < NUM_NUMBERS) {
			int nextNumber = random.nextInt(NUM_NUMBERS);
			j++;
			if (intSet.add(nextNumber)) {
				i++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to make %,03d random generator calls to create the tree of %,d numbers.", elapsed / 1E9, j, NUM_NUMBERS));
		
		start = System.nanoTime();
		
		for (i = 0, j = 0; i < NUM_NUMBERS; i++) {
			if (intSet.contains(i)) {
				j++;
			}
		}
		
		elapsed = System.nanoTime() - start;
		
		System.out.println(String.format("It took %,f seconds to perform %,d searches with %,d hits for all %,d numbers.", (elapsed / 1E9), NUM_NUMBERS, j, NUM_NUMBERS));
	}
}

package edu.metrostate.ics240.chapter10;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.Random;

import org.junit.Test;

public class BalancedSetTest {
	@Test
	public void testRemoveSmallComparatorSet() {
		final long SEED = 20170815;
		final Random random = new Random(SEED);
		
		final int MINIMUM = 1;
		final int NUM_NUMBERS = 99;
		final int NULL_LOOP = 3;
		
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
		
		while (i < NUM_NUMBERS) {
			int nextNumber = random.nextInt(NUM_NUMBERS); 
			if (intSet.add(nextNumber)) {
				i++;
				System.out.println(String.format("%d has been added to the BalancedSet<T>", nextNumber));
				intSet.print(0);
			}
		}
		
		while (intSet.getNumberOfItems() > 0) {
			int nextNumber = random.nextInt(NUM_NUMBERS); 
			if (intSet.remove(nextNumber)) {
				System.out.println(String.format("%d has been removed from the BalancedSet<T>", nextNumber));
				intSet.print(0);
			}
		}
		
		i = 0;
		int j = 0;
		
		while (i < NUM_NUMBERS) {
			int nextNumber = random.nextInt(NUM_NUMBERS); 
			
			if (i % NULL_LOOP == 0) {
				if (intSet.add(null)) {
					String temp = null;
					System.out.println(String.format("%s has been added to the BalancedSet<T>", temp));
				}
			}
			if (intSet.add(nextNumber)) {
				i++;
				System.out.println(String.format("%d has been added to the BalancedSet<T>", nextNumber));
				intSet.print(0);
			}
			j++;
		}

		assertTrue(intSet.contains(null));
		
		for (i = 0; i < NUM_NUMBERS; i++) {
			assertTrue(intSet.contains(i));
		}
		
		i = 0;
		
		while (intSet.getNumberOfItems() > 0) {
			int nextNumber = random.nextInt(NUM_NUMBERS);
			
			if (i++ % NULL_LOOP == 0 && intSet.remove(null)) {
				String temp = null;
				System.out.println(String.format("%s has been removed from the BalancedSet<T>", temp));
			}
			
			if (intSet.remove(nextNumber)) {
				System.out.println(String.format("%d has been removed from the BalancedSet<T>", nextNumber));
				intSet.print(0);
			}
		}
	}
	
}

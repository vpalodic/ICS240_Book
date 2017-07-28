/**
 * File: ArrayHeapTest.java
 */
package edu.metrostate.ics240.chapter10;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author Vincent J Palodichuk
 * 	<A HREF="mailto:hu0011wy@metrostate.edu"> (e-mail me) </A>
 *
 * @version 07/28/2017
 *
 */
public class ArrayHeapTest {

	@Test
	public final void test() {
		final int HEAP_SIZE = 20;
		ArrayHeap<Integer> heap = new ArrayMaxHeap<Integer>(HEAP_SIZE);
		
		assertNotNull(heap);
		assertEquals(0, heap.size());
		
		heap.add(25);
		
		assertEquals(1, heap.size());
		assertEquals(25, (int)heap.peek());
		
		heap.add(12);
		
		assertEquals(2, heap.size());
		assertEquals(25, (int)heap.peek());
		
		heap.add(28);
		
		assertEquals(3, heap.size());
		assertEquals(28, (int)heap.peek());
		
		heap.add(56);
		
		assertEquals(4, heap.size());
		assertEquals(56, (int)heap.peek());
		heap.trimToSize();
		heap.remove();
		
		assertEquals(3, heap.size());
		assertEquals(28, (int)heap.peek());
		
		heap.remove();
		
		assertEquals(2, heap.size());
		assertEquals(25, (int)heap.peek());
		
		heap.remove();
		
		assertEquals(1, heap.size());
		assertEquals(12, (int)heap.peek());
		assertTrue(heap.isEmpty() == false);
		
		heap.remove();
		
		assertEquals(0, heap.size());
		assertNull(heap.peek());
		assertTrue(heap.isEmpty() == true);
		
		for (int i = 0; i < 10; i++) {
			heap.add(i * 200);
		}
	}
}

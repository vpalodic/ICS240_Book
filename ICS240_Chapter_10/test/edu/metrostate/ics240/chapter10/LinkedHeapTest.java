/**
 * File: LinkedHeapTest.java
 */
package edu.metrostate.ics240.chapter10;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author Vincent J Palodichuk
 * 	<A HREF="mailto:hu0011wy@metrostate.edu"> (e-mail me) </A>
 *
 * @version 07/31/2017
 *
 */
public class LinkedHeapTest {

	@Test
	public final void testSmallMaxHeap() {
/*		final int HEAP_SIZE = 20;
		LinkedHeap<Integer> heap = new LinkedMaxHeap<Integer>(HEAP_SIZE);
		
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
		assertFalse(heap.isEmpty());
		
		heap.remove();
		
		assertEquals(0, heap.size());
		assertNull(heap.peek());
		assertTrue(heap.isEmpty());
		
		heap.clear();
		
		Integer[] items = {20, 5, 10, 12, 15, 8, 2, 6, 2, 9};
		
		heap = new LinkedMaxHeap<Integer>(items);
		heap.trimToSize();
		
		assertEquals(10, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(20, (int)heap.peek());
		
		LinkedHeap.maxHeapify(items);
		LinkedHeap.minHeapify(items);
		LinkedHeap.maxHeapify(items);
*/	}
	
	@Test
	public final void testSmallMinHeap() {
		LinkedHeap<Integer> heap = new LinkedMinHeap<Integer>();
		
		assertNotNull(heap);
		assertEquals(0, heap.size());
		
		heap.add(25);
		
		assertEquals(1, heap.size());
		assertEquals(25, (int)heap.peek());
		
		heap.add(12);
		
		assertEquals(2, heap.size());
		assertEquals(12, (int)heap.peek());
		
		heap.add(28);
		
		assertEquals(3, heap.size());
		assertEquals(12, (int)heap.peek());
		
		heap.add(56);
		
		assertEquals(4, heap.size());
		assertEquals(12, (int)heap.peek());
	
		heap.add(10);
		
		assertEquals(5, heap.size());
		assertEquals(10, (int)heap.peek());
	
		heap.add(32);
		
		assertEquals(6, heap.size());
		assertEquals(10, (int)heap.peek());
	
		heap.add(96);
		
		assertEquals(7, heap.size());
		assertEquals(10, (int)heap.peek());
	
		heap.add(1);
		
		assertEquals(8, heap.size());
		assertEquals(1, (int)heap.peek());
	
		heap.remove();
		
		assertEquals(7, heap.size());
		assertEquals(10, (int)heap.peek());
		
		heap.remove();
		
		assertEquals(6, heap.size());
		assertEquals(12, (int)heap.peek());
		
		heap.remove();
		
		assertEquals(5, heap.size());
		assertEquals(25, (int)heap.peek());
		
		heap.remove();
		
		assertEquals(4, heap.size());
		assertEquals(28, (int)heap.peek());
		
		heap.remove();
		
		assertEquals(3, heap.size());
		assertEquals(32, (int)heap.peek());

		heap.remove();
		
		assertEquals(2, heap.size());
		assertEquals(56, (int)heap.peek());
		
		heap.remove();
		
		assertEquals(1, heap.size());
		assertEquals(96, (int)heap.peek());
		assertFalse(heap.isEmpty());
		
		heap.remove();
		
		assertEquals(0, heap.size());
		assertNull(heap.peek());
		assertTrue(heap.isEmpty());
		
		heap.clear();
		
		final int HEAP_SIZE = 200000;
		
		assertNotNull(heap);
		
		for (int i = HEAP_SIZE; i > 0; i--) {
			heap.add(i);
		}
		
		assertEquals(HEAP_SIZE, heap.size());
		
		Integer a = heap.remove();
		
		while (!heap.isEmpty()) {
			Integer b = heap.remove();
			
			assertTrue (a.compareTo(b) <= 0);
			
			a = b;
		}
		
		assertEquals(0, heap.size());
		assertNull(heap.peek());
		assertTrue(heap.isEmpty());
		
		heap.clear();
		
		assertNotNull(heap);
		
		for (int i = HEAP_SIZE; i > 0; i--) {
			heap.add(i);
		}
		
		assertEquals(HEAP_SIZE, heap.size());
		
		heap.sort();
		
		heap.heapify();
		
		a = heap.remove();
		
		while (!heap.isEmpty()) {
			Integer b = heap.remove();
			
			assertTrue (a.compareTo(b) <= 0);
			
			a = b;
		}
		
		assertEquals(0, heap.size());
		assertNull(heap.peek());
		assertTrue(heap.isEmpty());
		
		heap.clear();
		
		assertNotNull(heap);
		
		System.out.println("done.");
	}
	
	@Test
	public final void testBigMaxHeap() {
/*		final int HEAP_SIZE = 200000;
		Integer[] items = new Integer[HEAP_SIZE];
		
		assertNotNull(items);
		assertEquals(HEAP_SIZE, items.length);
		
		for (int i = 0; i < HEAP_SIZE; i++) {
			items[i] = i;
		}
		
		LinkedHeap.minHeapify(items);
		LinkedHeap.maxHeapify(items);
		LinkedHeap.minHeapify(items);
		
		LinkedHeap<Integer> heap = new LinkedMaxHeap<Integer>(items);
		
		LinkedHeap.maxHeapSort(items, true);
		heap.sort();

		assertNotNull(heap);
		assertEquals(items.length, heap.size());
		
		for (int i = 0; i < items.length - 1; i++) {
			assertTrue(items[i].compareTo(items[i + 1]) <= 0);
		}
*/	}
	
	@Test
	public final void testBigMinHeap() {
/*		final int HEAP_SIZE = 200000;
		Integer[] items = new Integer[HEAP_SIZE];
		
		assertNotNull(items);
		assertEquals(HEAP_SIZE, items.length);
		
		for (int i = 0; i < HEAP_SIZE; i++) {
			items[i] = i;
		}
		
		LinkedHeap.minHeapify(items);
		LinkedHeap.maxHeapify(items);
		LinkedHeap.minHeapify(items);
		
		LinkedHeap<Integer> heap = new LinkedMinHeap<Integer>(items);
		
		LinkedHeap.minHeapSort(items, false);
		heap.sort();

		assertNotNull(heap);
		assertEquals(items.length, heap.size());
		
		for (int i = 0; i < items.length - 1; i++) {
			assertTrue(items[i].compareTo(items[i + 1]) >= 0);
		}
*/	}
}

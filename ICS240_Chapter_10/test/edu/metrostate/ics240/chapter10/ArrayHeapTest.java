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
	public final void testSmallMaxHeap() {
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
		assertFalse(heap.isEmpty());
		
		heap.remove();
		
		assertEquals(0, heap.size());
		assertNull(heap.peek());
		assertTrue(heap.isEmpty());
		
		heap.clear();
		
		Integer[] items = {20, 5, 10, 12, 15, 8, 2, 6, 2, 9};
		
		heap = new ArrayMaxHeap<Integer>(items);
		heap.trimToSize();
		
		assertEquals(10, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(20, (int)heap.peek());
		
		ArrayMaxHeap.heapify(items);
	}
	
	@Test
	public final void testSmallMinHeap() {
		final int HEAP_SIZE = 20;
		ArrayHeap<Integer> heap = new ArrayMinHeap<Integer>(HEAP_SIZE);
		
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
		heap.trimToSize();
		heap.remove();
		
		assertEquals(3, heap.size());
		assertEquals(25, (int)heap.peek());
		
		heap.remove();
		
		assertEquals(2, heap.size());
		assertEquals(28, (int)heap.peek());
		
		heap.remove();
		
		assertEquals(1, heap.size());
		assertEquals(56, (int)heap.peek());
		assertFalse(heap.isEmpty());
		
		heap.remove();
		
		assertEquals(0, heap.size());
		assertNull(heap.peek());
		assertTrue(heap.isEmpty());
		
		heap.clear();
		
		Integer[] items = {20, 5, 10, 12, 15, 8, 2, 6, 2, 9};
		
		heap = new ArrayMinHeap<Integer>(items);
		heap.trimToSize();
		
		assertEquals(10, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(2, (int)heap.peek());
		
		ArrayMinHeap.heapify(items);
	}
	
	@Test
	public final void testBigMaxHeap() {
		final int HEAP_SIZE = 200000;
		Integer[] items = new Integer[HEAP_SIZE];
		
		assertNotNull(items);
		assertEquals(HEAP_SIZE, items.length);
		
		for (int i = 0; i < HEAP_SIZE; i++) {
			items[i] = i;
		}
		
		ArrayMinHeap.heapify(items);
		ArrayMaxHeap.heapify(items);
		ArrayMinHeap.heapify(items);
		
		ArrayHeap<Integer> heap = new ArrayMaxHeap<Integer>(items);
		
		ArrayHeap.maxHeapSort(items, true);
		heap.sort();

		assertNotNull(heap);
		assertEquals(items.length, heap.size());
		
		for (int i = 0; i < items.length - 1; i++) {
			assertTrue(items[i].compareTo(items[i + 1]) <= 0);
		}
	}
	
	@Test
	public final void testBigMinHeap() {
		final int HEAP_SIZE = 200000;
		Integer[] items = new Integer[HEAP_SIZE];
		
		assertNotNull(items);
		assertEquals(HEAP_SIZE, items.length);
		
		for (int i = 0; i < HEAP_SIZE; i++) {
			items[i] = i;
		}
		
		ArrayMinHeap.heapify(items);
		ArrayMaxHeap.heapify(items);
		ArrayMinHeap.heapify(items);
		
		ArrayHeap<Integer> heap = new ArrayMinHeap<Integer>(items);
		
		ArrayHeap.minHeapSort(items, false);
		heap.sort();

		assertNotNull(heap);
		assertEquals(items.length, heap.size());
		
		for (int i = 0; i < items.length - 1; i++) {
			assertTrue(items[i].compareTo(items[i + 1]) >= 0);
		}
	}
}

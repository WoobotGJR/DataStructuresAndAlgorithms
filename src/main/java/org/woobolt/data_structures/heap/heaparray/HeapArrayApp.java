package org.woobolt.data_structures.heap.heaparray;

public class HeapArrayApp {
    public static void main(String[] args) {
        HeapArray minHeap = new HeapArray(10);
        minHeap.add(15);
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(17);
        minHeap.add(8);

        System.out.println(minHeap.poll()); // 8
        System.out.println(minHeap.poll()); // 10
    }
}

package org.woobolt.data_structures.heap.priorityqueue;


public class HeapPriorityQueueApp {
    public static void main(String[] args) {
        HeapPriorityQueue pq = new HeapPriorityQueue(10);
        pq.add(15);
        pq.add(10);
        pq.add(20);
        pq.add(17);
        pq.add(8);

        System.out.println("Peek: " + pq.peek()); // 8
        System.out.println("Poll: " + pq.poll()); // 8
        System.out.println("Peek: " + pq.peek()); // 10
        System.out.println("Poll: " + pq.poll()); // 10
    }
}

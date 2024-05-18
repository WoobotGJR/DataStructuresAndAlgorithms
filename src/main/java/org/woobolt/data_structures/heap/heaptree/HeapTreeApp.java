package org.woobolt.data_structures.heap.heaptree;

public class HeapTreeApp {
    public static void main(String[] args) {
        HeapTree heap = new HeapTree();
        heap.insert(15);
        heap.insert(10);
        heap.insert(20);
        heap.insert(17);
        heap.insert(8);

        System.out.println("Минимальный элемент: " + heap.getMin()); // 8
        System.out.println("Извлечение минимального элемента: " + heap.extractMin()); // 8
        System.out.println("Новый минимальный элемент: " + heap.getMin()); // 10
    }
}

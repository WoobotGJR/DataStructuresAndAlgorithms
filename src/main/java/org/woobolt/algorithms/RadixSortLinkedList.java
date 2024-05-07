package org.woobolt.algorithms;

import org.woobolt.data_structures.linked_list.LinkedListNode;

import java.util.Arrays;

public class RadixSortLinkedList {

    // Функция для добавления узла в конец связанного списка
    private LinkedListNode addToEnd(LinkedListNode head, int val) {
        LinkedListNode newNode = new LinkedListNode(val);
        if (head == null) {
            return newNode;
        }
        LinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    // Функция для извлечения значения из узла связанного списка и удаления его
    private static int extractValue(LinkedListNode head) {
        int val = (int) head.value;
        head = head.next;
        return val;
    }

    // Реализация поразрядной сортировки для массива чисел с использованием связанных списков
    public void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        LinkedListNode[] buckets = new LinkedListNode[10];
        for (int exp = 1; max / exp > 0; exp *= 10) {
            for (int value : arr) {
                int digit = (value / exp) % 10;
                buckets[digit] = this.addToEnd(buckets[digit], value);
            }
            int index = 0;
            for (LinkedListNode bucket : buckets) {
                while (bucket != null) {
                    arr[index++] = extractValue(bucket);
                    bucket = bucket.next;
                }
            }
            // Очищаем корзины после каждой итерации
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = null;
            }
        }
    }

    // Пример использования
}
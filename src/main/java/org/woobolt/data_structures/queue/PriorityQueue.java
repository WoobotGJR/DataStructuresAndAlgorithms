package org.woobolt.data_structures.queue;

public class PriorityQueue {
    private int maxSize;
    private int[] queueArray;
    private int nItems;

    public PriorityQueue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        nItems = 0;
    }

    public void insert(int item) {
        if (isFull()) {
            System.out.println("Очередь переполнена");
            return;
        }

        if (nItems == 0) {
            queueArray[nItems++] = item;
        } else {
            int j;
            for (j = nItems - 1; j >= 0; j--) {
                if (item > queueArray[j]) {
                    queueArray[j + 1] = queueArray[j];
                } else {
                    break;
                }
            }
            queueArray[j + 1] = item;
            nItems++;
        }
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Очередь пуста");
            return -1;
        }
        return queueArray[--nItems];
    }

    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Очередь пуста");
            return -1;
        }
        return queueArray[nItems - 1];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }
}


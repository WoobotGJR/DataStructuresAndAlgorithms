package org.woobolt.queue;

public class OrderedArray {
    private int[] arr;
    private int arrLength;

    public OrderedArray(int maxElements) {
        this.arr = new int[maxElements];
        this.arrLength = 0;
    }

    public int length() {
        return arrLength;
    }

    // binary search
    public int find(int searchKey) {
        int leftP = 0;
        int rightP = arrLength;
        int current;

        while (leftP <= rightP) {
            current = (leftP + rightP) / 2;

            if (arr[current] == searchKey) {
                return current;
            }

            if (arr[current] < searchKey) {
                leftP = current + 1;
            } else {
                rightP = current - 1;
            }
        }

        return -1;
    }

    // Вставка элемента в упорядоченный массив
    public void insert(int element) {
        int j = 0;

        // ищем элемент перед которым нужно вставить новый элемент
        for (; j < arrLength; j++)
            if (arr[j] > element) break;

        // Перемещаем элементы на 1 вперёд начиная с конца, совобождая место j-элементу
        for (int i = arrLength; i > j; i--)
            arr[i] = arr[i - 1];

        arr[j] = element;
        arrLength++;
    }

    public boolean delete(int element) {
        int j = find(element);

        if (j == -1) return false;

        for (int i = j; i < arrLength; i++)
            arr[i] = arr[i+1];

        arrLength--;
        return true;
    }

    public void display() {
        for (int i = 0; i < arrLength; i++) {
            System.out.println(arr[i] + "\t");
        }
        System.out.println();
    }
}


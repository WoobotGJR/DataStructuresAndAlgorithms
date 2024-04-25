package org.woobolt.data_structures.array;

public class UnorderedArray {
    private int[] arr = {};
    private int arrLength;

    public UnorderedArray(int maxElements) {
        this.arr = new int[maxElements];
        this.arrLength = 0;
    }

    public int length() {
        return arrLength;
    }

    public int find(int searchKey) {
        for (int i = 0; i < arrLength; i++)
            if (arr[i] == searchKey)
                return i;
        return -1;
    }

    // Linear search
    // Вставка элемента в упорядоченный массив
    public void insert(int element) {
        arr[arrLength + 1] = element;
    }

    public boolean delete(int element) {
        int j = find(element);

        if (j == -1) return false;

        for (int i = j; i < arrLength; i++)
            arr[i] = arr[i + 1];

        arrLength--;
        return true;
    }

    public void display() {
        for (int i = 0; i < arrLength; i++) {
            System.out.println(arr[i] + "\t");
        }
        System.out.println();
    }

    public int[] getArr() {
        return arr;
    }
}



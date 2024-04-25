package org.woobolt.algorithms;

import org.woobolt.data_structures.array.UnorderedArray;

public class InsertionSort {
    private UnorderedArray array;
    private int[] arr = array.getArr();

    public InsertionSort(int maxSize) {
        array = new UnorderedArray(maxSize);
    }

    public void insertionSort() {
        int in, out;
        for (out = 1; out < array.length(); out++) {
            int temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
        }
    }
}

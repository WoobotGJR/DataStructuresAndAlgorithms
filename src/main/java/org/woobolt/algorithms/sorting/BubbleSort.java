package org.woobolt.algorithms.sorting;

import org.woobolt.data_structures.array.UnorderedArray;

public class BubbleSort {
    private UnorderedArray array;
    private int[] arr = array.getArr();

    public BubbleSort(int maxSize) {
         array = new UnorderedArray(maxSize);
    }

    public void bubbleSort() {
        for (int i = 0; i < array.length(); i++) {
            for (int j = 0; j < array.length(); j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
            }
        }
    }

    private void swap(int firstInd, int secondInd) {
        int temp = arr[firstInd];
        arr[firstInd] = arr[secondInd];
        arr[secondInd] = temp;
    }
}

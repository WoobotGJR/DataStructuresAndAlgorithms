package org.woobolt.algorithms;

import DataStructures.UnorderedArray;

import java.beans.JavaBean;

public class SelectionSort {
  private UnorderedArray array;
  private int[] arr = array.getArr();

  public SelectionSort(int maxSize) {
    array = new UnorderedArray(maxSize);
  }

  public void selectionSort() {
    int min, out = 0, in = 0;

    for (; out < array.length() - 1; out++) {
      min = out;
      for (in = out + 1; in < array.length(); in++) {
        if(arr[in] < arr[min])
          min = in;

        swap(out, min);
      }
    }
  }

  private void swap(int firstInd, int secondInd) {
    int temp = arr[firstInd];
    arr[firstInd] = arr[secondInd];
    arr[secondInd] = temp;
  }
}

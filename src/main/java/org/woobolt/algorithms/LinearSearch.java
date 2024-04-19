package org.woobolt.algorithms;

public class LinearSearch<T> {

	// here we work with sorted array!
	public int linear(T[] arr, T value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				return i;
			}
		}

		return -1;
	}
}

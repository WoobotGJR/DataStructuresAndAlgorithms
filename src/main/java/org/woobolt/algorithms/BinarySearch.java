package org.woobolt.algorithms;

public class BinarySearch {
	
	// here we work with sorted array!
	public static int binary(int[] arr, int value) {
		int leftPointer = 0;
		int rightPointer = arr.length - 1;

		while (leftPointer <= rightPointer) {
			int middle = (rightPointer + leftPointer) / 2;
			
			if (arr[middle] == value) return middle;
			
			if (arr[middle] < value) {
				leftPointer = middle + 1;
			} else {
				rightPointer = middle - 1;
			}
		}
		
		return -1;
	}
	
	private static int binaryRecursion(int[] arr, int value, int left, int right) {

		if (left > right) return -1;
		
		int mid =  (right + left) / 2;
		
		if (arr[mid] == value) return mid;
		
		if (arr[mid] < right) {
			return binaryRecursion(arr, value, left, mid - 1);
		} else {
			return binaryRecursion(arr, value, mid + 1, right);
		}
	}
	
	public static int binaryRecursive(int[] arr, int value, int left) {
		return binaryRecursion(arr, value, left, arr.length - 1);
	}
	
}

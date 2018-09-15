package com.ibits.arrays;

/*
 * https://www.geeksforgeeks.org/duplicates-array-using-o1-extra-space-set-2/
 * Elements are restricted in the ranges 0 to n-1
 */
public class PrintDuplicates {

	public static void main(String[] args) {
		//int arr[] = { 1, 6, 3, 1, 3, 6, 6 };
		int arr[] = {2, 2, 2};
		int n = arr.length;
		printDuplicates(arr, n);
	}

	private static void printDuplicates(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			int ind = arr[i] % n;
			arr[ind] += n;
		}

		// Print all those elements whose division by n
		// results in a value greater than 1
		for (int i = 0; i < n; i++) {
			if (arr[i] / n > 1)
				System.out.print(i + " ");
		}
	}

}

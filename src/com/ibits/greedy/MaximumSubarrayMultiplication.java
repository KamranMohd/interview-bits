package com.ibits.greedy;

/*
 * https://www.geeksforgeeks.org/maximum-product-subarray/
 */
public class MaximumSubarrayMultiplication {

	public static void main(String[] args) {
		int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
		int n = arr.length;
		System.out.println(getMaxMultiplication(arr, n));
	}

	public static int getMaxMultiplication(int arr[], int n) {
		int max_positive_prod = 1, min_neg_prod = 1, max_prod = 1;

		for (int i = 0; i < n; i++) {
			if (arr[i] > 0) {
				max_positive_prod *= arr[i];
				min_neg_prod = Math.min(min_neg_prod * arr[i], 1);
			}

			else if (arr[i] == 0) {
				max_positive_prod = 1;
				min_neg_prod = 1;
			}

			else {
				int temp = max_positive_prod;
				max_positive_prod = Math.max(min_neg_prod * arr[i], 1);
				min_neg_prod = temp * arr[i];
			}

			max_prod = Math.max(max_prod, max_positive_prod);
		}
		return max_prod;
	}

}

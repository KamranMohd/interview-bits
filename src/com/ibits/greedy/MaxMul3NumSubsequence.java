package com.ibits.greedy;

import java.util.Arrays;

public class MaxMul3NumSubsequence {

	public static void main(String[] args) {
		int arr[] = { 10, 3, 5, 6, 20 };
		// int arr[] = {-10, -3, -5, -6, -20};
		// int arr[] = {1, -4, 3, -6, 7, 0};
		int n = arr.length;
		System.out.println(getMaxMul(arr, n));
		System.out.println(getMaxMul2(arr, n));
	}

	/*
	 * Method 1: Time complexity : O(nlogn) Space complexity : O(1)
	 */
	public static int getMaxMul(int arr[], int n) {
		if (n < 3)
			return Integer.MIN_VALUE;
		Arrays.sort(arr);

		return Math.max(arr[n - 1] * arr[n - 2] * arr[n - 3], arr[n - 1] * arr[0] * arr[1]);
	}

	/*
	 * Method 1: Time complexity : O(n) Space complexity : O(n)
	 */
	public static int getMaxMul2(int arr[], int n) {
		if (n < 3)
			return Integer.MIN_VALUE;

		int leftMax[] = new int[n];
		int leftMin[] = new int[n];
		int rightMax[] = new int[n];
		int rightMin[] = new int[n];

		// Initialize the values
		leftMax[0] = -1;
		leftMin[0] = -1;
		rightMax[n - 1] = -1;
		rightMin[n - 1] = -1;
		int max = arr[0], min = arr[0];

		for (int i = 1; i < n; i++) {
			leftMax[i] = max;
			max = Math.max(max, arr[i]);
			leftMin[i] = min;
			min = Math.min(min, arr[i]);
		}

		max = arr[n - 1];
		min = arr[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = max;
			max = Math.max(max, arr[i]);
			rightMin[i] = min;
			min = Math.min(min, arr[i]);
		}

		int result = Integer.MIN_VALUE;
		for (int i = 1; i < n - 1; i++) {
			int max1 = Math.max(arr[i] * leftMax[i] * rightMax[i], arr[i] * leftMin[i] * rightMin[i]);
			int max2 = Math.max(arr[i] * leftMax[i] * rightMin[i], arr[i] * leftMin[i] * rightMax[i]);
			result = Math.max(result, Math.max(max1, max2));
		}
		return result;

	}
}

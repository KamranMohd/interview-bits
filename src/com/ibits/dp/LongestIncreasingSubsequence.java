package com.ibits.dp;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		System.out.println(getLongestIncreasingSubsequence(arr, n));
	}

	public static int getLongestIncreasingSubsequence(int[] arr, int n) {
		if (n == 0 || n == 1)
			return n;

		int lis[] = new int[n];
		lis[0] = 1;
		int max = 1;
		
		for (int i = 1; i < n; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && (lis[j] + 1) > lis[i])
					lis[i] = lis[j] + 1;
			}
			
			max = Math.max(max, lis[i]);
		}
		return max;
	}
}
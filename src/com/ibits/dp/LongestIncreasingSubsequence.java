package com.ibits.dp;

/*
 * Find and print Longest increasing subsequence
 * https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 * https://www.geeksforgeeks.org/construction-of-longest-increasing-subsequence-using-dynamic-programming/
 * 
 */
import java.util.ArrayList;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		System.out.println("length of lis " + getLongestIncreasingSubsequence(arr, n));
	}

	public static int getLongestIncreasingSubsequence(int[] arr, int n) {
		if (n == 0 || n == 1)
			return n;

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		int lis[] = new int[n];
		lis[0] = 1;
		ArrayList<Integer> internal = new ArrayList<>();
		internal.add(arr[0]);
		result.add(internal);
		
		int max = 1;

		for (int i = 1; i < n; i++) {
			lis[i] = 1;
			internal = new ArrayList<>();
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && (lis[j] + 1) > lis[i]) {
					lis[i] = lis[j] + 1;
					// internal = new ArrayList<>(result.get(j));
					internal = new ArrayList<>(result.get(j));
				}
			}
			internal.add(arr[i]);
			result.add(internal);
			max = Math.max(max, lis[i]);
		}

		// Print the maximum length list
		int maxLen = Integer.MIN_VALUE, maxIndex = -1;
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).size() > maxLen)
				maxIndex = i;
		}
		System.out.println(result.get(maxIndex));
		return max;
	}
}
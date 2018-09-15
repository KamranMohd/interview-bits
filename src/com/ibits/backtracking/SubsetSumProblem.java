package com.ibits.backtracking;

import java.util.ArrayList;

/*
 * https://www.geeksforgeeks.org/subset-sum-backtracking-4/
 */

public class SubsetSumProblem {
	static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		int arr[] = { 10, 7, 5, 18, 12, 20, 15 };
		int k = 35;
		//int arr[] = {3, 34, 4, 12, 5, 2};
		//int k = 9;
		//int arr[] = {5,4,8,2,3,6};
		//int k = 11;
		int n = arr.length; 
		printSubsetSum(arr, n, k);
		System.out.println(result.toString());
	}

	public static void printSubsetSum(int[] arr, int n, int k) {
		ArrayList<Integer> solution = new ArrayList<>();
		//Arrays.sort(arr);
		printSubsetSumUtils(arr, n, k, 0, 0, solution);
	}

	public static void printSubsetSumUtils(int[] arr, int n, int k, int currentPos, int sum_so_far,
			ArrayList<Integer> solution) {

		// Base condition: If the sum is equal to k, then print the solution
		// System.out.println("Sum : " + sum_so_far);
		if (sum_so_far == k) {
			result.add(new ArrayList<>(solution));
			return;
		} else if (sum_so_far > k)
			return;
		else {
			for (int i = currentPos; i < n; i++) {
				// Add the current element in the subset and check if the
				// solution is formed
				sum_so_far += arr[i];
				solution.add(arr[i]);
				printSubsetSumUtils(arr, n, k, i + 1, sum_so_far, solution);
				// Now, we backtrack and see for the remaining combination
				solution.remove(solution.size() - 1);
				sum_so_far -= arr[i];
			}
		}

	}

	private static void printSolution(ArrayList<Integer> solution) {
		for (int num : solution)
			System.out.print(num + " ");
		System.out.println();
	}

}
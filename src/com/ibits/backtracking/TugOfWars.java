package com.ibits.backtracking;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/tug-of-war/
 */
public class TugOfWars {
	static int minDiff = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int arr[] = { 23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4 };
		int n = arr.length;
		tugOfWar(arr, n);
	}

	public static void tugOfWar(int[] arr, int n) {
		// Create 2 arrays, solution[] and current[]
		// which will store the final solution and the current
		// elements in the first set respectively
		boolean[] current = new boolean[n];
		boolean[] solution = new boolean[n];

		// Initialize the arrays
		Arrays.fill(current, false);
		Arrays.fill(solution, false);

		// Get the total of the array which will be used in the minimization condition
		int total = 0;
		for (int num : arr)
			total += num;

		int selected = 0, currentPos = 0, currentSum = 0;
		tugOfWarsUtil(arr, n, current, solution, total, selected, currentPos, currentSum);

		// Print the solution sets
		for (int i = 0; i < n; i++) {
			if (solution[i] == true)
				System.out.print(arr[i] + " ");
		}
		System.out.println();

		// Print the second set
		for (int i = 0; i < n; i++) {
			if (solution[i] == false)
				System.out.print(arr[i] + " ");
		}

	}

	private static void tugOfWarsUtil(int[] arr, int n, boolean[] current, boolean[] solution, int total, int selected,
			int currentPos, int currentSum) {

		// Base condition 1: If we have seen all the elements
		if (currentPos == n)
			return;

		// Base condition 2: If the number of element to be selected is
		// greater than the number of elements left to be traversed
		if ((n / 2 - selected) > n - currentPos)
			return;

		// If the current element is excluded from the first set
		tugOfWarsUtil(arr, n, current, solution, total, selected, currentPos + 1, currentSum);

		// If the current element is included
		selected++;
		current[currentPos] = true;
		currentSum += arr[currentPos];

		// Check if n/2 elements are selected
		if (selected == n / 2) {
			// Check if the current diff is less than the previous difference and update
			// minDiff
			if (Math.abs(total / 2 - currentSum) < minDiff) {
				minDiff = Math.abs(total / 2 - currentSum);
				// Update the solution array if the minimum is found
				for (int i = 0; i < n; i++)
					solution[i] = current[i];
			}

		} else {
			// Call the tugsOfWar again
			tugOfWarsUtil(arr, n, current, solution, total, selected, currentPos + 1, currentSum);
		}

		// Remove this element from the current set and recurse
		current[currentPos] = false; // Backtracking step
	}

}

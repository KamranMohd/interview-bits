package com.ibits.dp;

/*
 * https://www.interviewbit.com/problems/min-jumps-array/
 */
public class MinJumpsLinearSol {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		int n = arr.length;
		System.out.println(getMinimumJumps(arr, n));
	}

	public static int getMinimumJumps(int arr[], int n) {
		// Base cases: If there is only one element, then we return 0
		// as first index is the starting point
		if (n <= 1)
			return 0;
		if (arr[0] == 0)
			return -1;
		
		// Maximum index that is reachable from the current index
		int maxReach = arr[0];

		// Number of steps/options available at any time
		int steps = arr[0];

		// Initialized to zero since we are already on index 0
		int jumps = 1;

		for (int i = 1; i < n; i++) {
			// If we have reached the end, then return the jumps
			if (i == n - 1)
				return jumps;

			// Update maximum reach from the index i
			maxReach = Math.max(maxReach, i + arr[i]);

			// Since, we have taken one option while updating the maxReach in the previous
			// step
			steps--;
			if (steps == 0) {
				jumps++;
				steps = maxReach - i;
			}
		}
		return jumps;
	}
}
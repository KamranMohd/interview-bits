package com.ibits.heapsandmaps;
/*
 * https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
 * https://www.interviewbit.com/problems/distinct-numbers-in-window/
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DistinctNumbersInWindow {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
		int n = arr.length;
		int k = 4;
		printDistinctNumbersInWindowOpt(arr, n, k);
	}

	/*
	 * This is not the most optimal solution
	 */
	private static void printDistinctNumbersInWindow(int[] arr, int n, int k) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i <= n - k; i++) {
			for (int j = i; j < i + k; j++) {
				set.add(arr[j]);
			}
			System.out.print(set.size() + " ");
			set.clear();
		}

	}

	private static void printDistinctNumbersInWindowOpt(int[] arr, int n, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int distCount = 0;
		// First window
		for (int i = 0; i < k; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
				distCount++;
			}
		}
		System.out.print(distCount + " ");

		for (int i = k; i < n; i++) {
			// Remove the first element of the previous window
			// If the removed element was distinct in the previous window
			if (map.get(arr[i - k]) == 1) {
				distCount--;
				map.remove(arr[i - k]);
			}

			else {
				// If it was not distinct, reduce it's count by 1
				map.put(arr[i - k], map.get(arr[i - k]) - 1);
			}

			// Check if the current element is unique of not
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
				distCount++;
			}
			System.out.print(distCount + " ");
		}
	}
}
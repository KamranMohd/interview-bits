package com.ibits.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/combinational-sum/
 */
public class Combinations {
	static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		int arr[] = { 2, 4, 6, 8 };
		//int [] arr = {7, 2, 6, 5};
		//int [] arr = {6, 5, 1, 8, 2, 7, 9};
		int n = arr.length;
		int k = 8;
		//int k = 16;
		//int k = 6;
		getCombinations(arr, n, k);
	}

	public static void getCombinations(int[] arr, int n, int k) {
		ArrayList<Integer> combo = new ArrayList<>();

		// Assumptions: That the below step 1 and step 2 are done
		// First step: Sort the array in decreasing order
		Arrays.sort(arr);
		// Second step : Remove duplicates from the array

		getCombinationsUtils(arr, n, k, combo, 0);
		printSolution();
	}

	
	public static void getCombinationsUtils(int[] arr, int n, int k, ArrayList<Integer> combo,int i) {

		// If the sum is zero, then we have a combination
		if (k == 0) {
			//	We have added a new object, because if we add combo
			//	directly then values will disappear between recursion calls
			//	and the result list would become empty
			result.add(new ArrayList<>(combo));
			return;
		}

		// If sum becomes less than zero, then we must return
		if (k < 0)
			return;

		// We consider elements one by one such that the element is less than the sum
		while(i < n && k - arr[i] >= 0) {
			//	Add the element to the combo list
			combo.add(arr[i]);
			//	Recur for other combinations
			getCombinationsUtils(arr, n, k-arr[i], combo, i);
			
			//	Increase the index of the starting element and remove it
			//	from the combo list
			i++;
			combo.remove(combo.size()-1); // Backtrack step
		}
	}
	
	private static void printSolution() {
		for(ArrayList<Integer> combo : result) {
			System.out.print("(");
			for(int i = 0;i < combo.size(); i++)
				System.out.print(combo.get(i) + (i==combo.size()-1 ? "" : ", "));
			System.out.println(")");
		}
		
	}


}

package com.ibits.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class ReturnAllSubset {
	static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) {
		//int arr[] = { 1, 2, 3, 4 };
		int arr[] = {6};
		ArrayList<Integer> list = new ArrayList<>();
		for (int num : arr)
			list.add(num);
		// getAllSubsets(list);
		getAllSubsetsBT(list);
		System.out.println(result.size() + " "  + result.toString());
	}

	private static void getAllSubsetsBT(ArrayList<Integer> list) {
		Collections.sort(list);
		int n = list.size();
		ArrayList<Integer> solution = new ArrayList<>();

		getAllSubsetsUtils(list, n, 0, solution);
	}

	private static void getAllSubsetsUtils(ArrayList<Integer> A, int n, int currentPos, ArrayList<Integer> solution) {
		//System.out.println(solution.toString() + " " + currentPos);
		if (currentPos <= n)
			result.add(new ArrayList<>(solution));
		else if (currentPos > n)
			return;
		for (int i = currentPos; i < n; i++) {
			solution.add(A.get(i));
			getAllSubsetsUtils(A, n, i + 1, solution);
			solution.remove(solution.size() - 1);
		}
	}

	private static void getAllSubsets(ArrayList<Integer> list) {
		int n = list.size();
		int counter = (int) Math.pow(2, n);
		for (int i = 0; i < counter; i++) {
			ArrayList<Integer> sol = new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0) {
					sol.add(list.get(j));
					System.out.println(sol.toString());
				}
			}
			result.add(sol);
		}
	}

}

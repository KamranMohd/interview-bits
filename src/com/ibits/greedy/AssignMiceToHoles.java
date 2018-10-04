package com.ibits.greedy;

import java.util.ArrayList;
import java.util.Collections;

/*
 * https://www.geeksforgeeks.org/assign-mice-holes/
 * https://www.interviewbit.com/problems/assign-mice-to-holes/
 */
public class AssignMiceToHoles {

	public static void main(String[] args) {
		/*int mices[] = { -10, -79, -79, 67, 93, -85, -28, -94 };
		int holes[] = { -2, 9, 69, 25, -31, 23, 50, 78 };*/
		int mices[] = { 4, -4, 2 };
		int holes[] = { 4, 0, 5 };
		ArrayList<Integer> A = convertList(mices);
		ArrayList<Integer> B = convertList(holes);
		System.out.println(assignMicesToHoles(A, B));
	}

	private static int assignMicesToHoles(ArrayList<Integer> a, ArrayList<Integer> b) {
		if (a.size() != b.size())
			return -1;

		int n = a.size();
		
		//	Sort the list
		Collections.sort(a);
		Collections.sort(b);
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (max < Math.abs(a.get(i) - b.get(i)))
				max = Math.abs(a.get(i) - b.get(i));
		}
		return max;
	}

	private static ArrayList<Integer> convertList(int[] values) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int val : values)
			result.add(val);
		return result;
	}
}
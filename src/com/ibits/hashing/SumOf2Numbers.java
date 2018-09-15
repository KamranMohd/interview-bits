package com.ibits.hashing;

/*
 * https://www.interviewbit.com/problems/2-sum/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SumOf2Numbers {

	public static void main(String[] args) {
		// int arr[] = {2, 7, 11, 15};
		// int B = 9;
		// int arr[]= {4, 5, 5, 6, 10 };
		// int B = 10;
		int arr[] = { 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4,
				4, -8 };
		int B = -3;
		ArrayList<Integer> A = new ArrayList<>();
		for (int num : arr)
			A.add(num);
		System.out.println(Integer.MIN_VALUE + " " + Integer.MAX_VALUE);
		ArrayList<Integer> result = twoSum(A, B);
		System.out.println(result.get(0) + " " + result.get(1));
	}

	public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {
		ArrayList<Integer> result = new ArrayList<>();
		HashMap<Integer, Integer> comp = new HashMap<>();
		int n = A.size();
		for (int i = 0; i < n; i++) {
			if (comp.get(B - A.get(i)) != null) {
				result.add(comp.get(B - A.get(i)) + 1);
				result.add(i + 1);
				return result;
			} else if (comp.get(A.get(i)) == null)
				//	The above condition makes sure that if there are multiple instances of a number, 
				//	only the smaller index is stored in the map
				comp.put(A.get(i), i);
		}
		return result;
	}

}

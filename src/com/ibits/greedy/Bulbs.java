package com.ibits.greedy;

/*
 * https://www.interviewbit.com/problems/bulbs/
 */
import java.util.ArrayList;

public class Bulbs {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 1 };
		// int[] arr = { 1, 0, 1, 0, 0, 1, 0 };
		// int arr[] = {0, 0, 0, 0};
		// int arr[] = {1, 1, 1, 1};
		ArrayList<Integer> A = convertList(arr);
		System.out.println(getMinSwitches(A));
	}

	private static int getMinSwitches(ArrayList<Integer> a) {
		int n = a.size();
		int count = 0, intialState = 1;
		for (int i = 0; i < n; i++) {
			if (a.get(i) != intialState) {
				count++;
				intialState ^= 1;
			}
		}
		return count;
	}

	private static ArrayList<Integer> convertList(int[] values) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int val : values)
			result.add(val);
		return result;
	}

}
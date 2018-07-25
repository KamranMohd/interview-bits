package com.ibits.arrays;

/*
 * https://www.interviewbit.com/problems/minimize-the-absolute-difference/?ref=dash-reco
 */
import java.util.ArrayList;

public class MinimizeAbsoluteDiff {

	public static void main(String[] args) {
		int a[] = { 1, 4, 5, 8, 10 };
		int b[] = { 6, 9, 15 };
		int c[] = { 2, 3, 6, 6 };
		ArrayList<Integer> A = new ArrayList<>();
		ArrayList<Integer> B = new ArrayList<>();
		ArrayList<Integer> C = new ArrayList<>();
		A = convertToList(a);
		B = convertToList(b);
		C = convertToList(c);
		System.out.println(solve(A, B, C));
	}

	public static ArrayList<Integer> convertToList(int[] arr) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int num : arr)
			list.add(num);
		return list;
	}

	public static int solve(ArrayList<Integer> A, ArrayList<Integer> B,
			ArrayList<Integer> C) {
		int min = Integer.MAX_VALUE;
		int i = A.size() - 1, j = B.size() - 1, k = C.size() - 1;
		while (i >= 0 && j >= 0 && k >= 0) {
			int temp_max = Math.max(C.get(k), Math.max(A.get(i), B.get(j)));
			int temp_min = Math.min(C.get(k), Math.min(A.get(i), B.get(j)));
			min = Math.min(min, Math.abs(temp_max - temp_min));
			String maxList = getMaxIndex(A, B, C, i, j, k);
			if (maxList.equals("A"))
				i--;
			else if (maxList.equals("B"))
				j--;
			else
				k--;
		}
		return min;
	}

	public static String getMaxIndex(ArrayList<Integer> A,
			ArrayList<Integer> B, ArrayList<Integer> C, int i, int j, int k) {
		String index = "";
		if ((A.get(i) >= B.get(j)) && (A.get(i) >= C.get(k)))
			index = "A";
		else if ((B.get(j) >= A.get(i)) && (B.get(j) >= C.get(k)))
			index = "B";
		else
			index = "C";
		return index;
	}

}

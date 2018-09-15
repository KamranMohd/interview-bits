package com.ibits.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class PermutationsOfNumbers {
	static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) {
		int arr[] = {1,2,3};
		ArrayList<Integer> list = new ArrayList<>();
		for(int num : arr)
			list.add(num);
		getAllPermutations(list);
		System.out.println(result.toString());
	}

	private static void getAllPermutations(ArrayList<Integer> A) {
		int n = A.size();
		Collections.sort(A);
		ArrayList<Integer> solution = new ArrayList<>();
		getAllPermutationsUtil(A, n, 0, n-1, solution);
		
	}

	private static void getAllPermutationsUtil(ArrayList<Integer> A, int n, int l, int r, ArrayList<Integer> solution) {
		if(l==r) {
			//System.out.println(A.toString());
			result.add(new ArrayList<>(A));
			return;
		}
		for(int i=l;i<n;i++) {
			swap(A,l,i);
			getAllPermutationsUtil(A, n, l+1, r, solution);
			swap(A,l,i);
		}
	}

	private static void swap(ArrayList<Integer> A, int l, int r) {
		int temp = A.get(l);
		A.set(l, A.get(r));
		A.set(r, temp);
	}

}

package com.ibits.arrays;

/*
 * https://www.interviewbit.com/problems/add-one-to-number/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddOneToMSB {

	public static void main(String[] args) {
		// Integer arr[] = new Integer[]{2, 5, 6, 8, 6, 1, 2, 4, 5};
		// Integer arr[] = new Integer[]{0, 3, 7, 6, 4, 0, 5, 5, 5};
		// Integer arr[] = new Integer[] { 0, 6, 0, 6, 4, 8, 8, 1 };
		Integer arr[] = new Integer[] { 0 };
		List<Integer> A = Arrays.asList(arr);
		ArrayList<Integer> list = new ArrayList<>(A);
		list = plusOne(list);
		for (int i : list)
			System.out.print(i + " ");
	}

	public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		int n = A.size();
		if (n == 0) {
			A.add(0);
			return A;
		}
		// Remove out all the zeros
		for (int i = 0; i < A.size();) {
			if (A.get(i) != 0)
				break;
			else
				A.remove(i);
		}
		
		//	The size will change after removing the elements from the list
		n = A.size();
		int carry = 1, newNum;
		for (int i = n - 1; i >= 0; i--) {
			newNum = A.get(i) + carry;
			A.set(i, newNum % 10);
			carry = newNum / 10;
			if (carry == 0)
				break;
		}
		if (carry == 1)
			A.add(0, 1);

		return A;
	}
}

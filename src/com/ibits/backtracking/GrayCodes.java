package com.ibits.backtracking;

import java.util.ArrayList;

/*
 * 
 */
public class GrayCodes {

	public static void main(String[] args) {
		int n = 3;
		// printGrayCodes(n);
		ArrayList<Integer> result = new ArrayList<>();
		printGrayCodes(n);
		// for(int code : result)
		// System.out.println(code);
	}

	//	Method 1 : Using the backtracking algorithm. Currently this method does not work
	//	Will come back at this to solve. The below method although works
	private static void printGrayCodesBT(int bits, int num, ArrayList<Integer> result) {
		// Base condition: If all the bits are processed
		System.out.println(result.toString());
		if (bits == 0) {
			result.add(num);
			return;
		}

		// Keep the bits as it is
		printGrayCodesBT(bits - 1, num, result);

		// Invert the bits
		num = num ^ (1 << (bits - 1));
		printGrayCodesBT(bits - 1, num, result);
	}

	//	Method 2 : Without using the backtracking algorithm
	public static void printGrayCodes(int n) {
		if (n <= 0)
			return;
		// Create a list that will contain gray codes
		ArrayList<String> codes = new ArrayList<>();

		// Add 1 bit codes
		codes.add("0");
		codes.add("1");

		// Loop for the other bits. For n bits, there will be 2^n grey codes
		for (int i = 2; i < (1 << n); i = i << 1) {
			// To the existing list, add the reverse of the list
			for (int j = i - 1; j >= 0; j--)
				codes.add(codes.get(j));

			// Add "0" as prefix to the first half of the list
			for (int j = 0; j < i; j++)
				codes.set(j, "0" + codes.get(j));

			// Add "1" as prefix to the second half of the list
			for (int j = i; j < 2 * i; j++)
				codes.set(j, "1" + codes.get(j));
		}

		// Print all the elements inside the list
		for (String code : codes)
			System.out.println(Integer.parseInt(code,2));
	}
}
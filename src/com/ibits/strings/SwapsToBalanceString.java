package com.ibits.strings;

import java.util.ArrayList;

/*
 * https://www.geeksforgeeks.org/minimum-swaps-bracket-balancing/
 */

public class SwapsToBalanceString {

	public static void main(String[] args) {
		// String exp = "[]][][";
		String exp = "]]]][[[[";
		System.out.println(minSwaps(exp));
		System.out.println(minSwapsOpt(exp,exp.length()));
	}

	/*
	 * Method 2: Optimized as we traverse the array elements more than once Time
	 * complexity: O(n)
	 */
	public static int minSwapsOpt(String exp, int n) {
		
		char brackets[] = exp.toCharArray();

		ArrayList<Integer> open = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (brackets[i] == '[')
				open.add(i);
		}
		
		int count = 0, minSwaps = 0, pos = 0;
		for (int i = 0; i < brackets.length; i++) {
			if (brackets[i] == '[') {
				count++;
				pos++;
			}
			else
				count--;
			if (count < 0) {
				minSwaps += open.get(pos) - i;
				swap(brackets, i, open.get(pos));
				pos++;
				count = 1;
			}
		}
		return minSwaps;
	}

	/*
	 * Method 1: Not optimized as we traverse the array elements more than once Time
	 * complexity: O(n * n)
	 */
	public static int minSwaps(String exp) {
		int count = 0, minSwaps = 0;
		char brackets[] = exp.toCharArray();
		for (int i = 0; i < brackets.length; i++) {
			if (brackets[i] == '[')
				count++;
			else
				count--;
			if (count < 0) {
				int j = i + 1;
				while (j < brackets.length && brackets[j] != '[')
					j++;
				minSwaps += (j - i);
				swap(brackets, i, j);
				count = 1;
			}
		}
		return minSwaps;
	}

	private static void swap(char[] brackets, int i, int j) {
		char temp = brackets[i];
		brackets[i] = brackets[j];
		brackets[j] = temp;
	}

}

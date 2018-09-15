package com.ibits.backtracking;

/*
 * https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * https://www.geeksforgeeks.org/distinct-permutations-string-set-2/
 */
public class StringPermutations {

	public static void main(String[] args) {
		// String str = "ABC";
		// If there are repetition in the string, then the below
		// algorithm will produce duplicates
		String str = "ABCDEFGHIJKLP";
		char[] string = str.toCharArray();
		printPermutations(string, 0, string.length - 1);
		System.out.println();
		printPermutationsWithoutRepetition(string, 0, string.length - 1);
	}

	public static void printPermutations(char[] string, int l, int r) {
		// Base condition: If left is equal to right, print the string
		if (l == r) {
			System.out.println(new String(string));
			return;
		} else {
			for (int i = l; i <= r; i++) {
				// Swap the characters with one another
				swap(string, l, i);
				printPermutations(string, l + 1, r);
				swap(string, l, i); // Backtrack to the previous permutation
			}
		}
	}

	public static void printPermutationsWithoutRepetition(char[] string, int l, int r) {
		// Base condition: If left is equal to right, print the string
		if (l == r) {
			System.out.println(new String(string));
			return;
		}

		for (int i = l; i <= r; i++) {
			// If there is a character which appears twice there is no
			// point in swapping those two, as they will always produce same
			// result. So, let's check if the current character is present in the string
			boolean isDuplicate = checkForDuplicates(string, l, i);
			if (!isDuplicate) {
				swap(string, l, i);
				printPermutationsWithoutRepetition(string, l + 1, r);
				swap(string, l, i); // Backtrack to the previous permutation
			}
		}
	}

	private static boolean checkForDuplicates(char[] string, int start, int current) {
		for (int j = start; j < current; j++) {
			if (string[j] == string[current])
				return true;
		}
		return false;
	}

	private static void swap(char[] string, int l, int i) {
		char ch = string[l];
		string[l] = string[i];
		string[i] = ch;
	}
}

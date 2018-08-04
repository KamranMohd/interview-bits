package com.ibits.strings;

public class KMP {

	public static void main(String[] args) {
		// String pattern = "AAACAAAAAC";
		// String pattern = "AABAACAABAA";
		//String text = "ABABDABACDABABCABAB", pattern = "ABABCABAB";
		String text = "AABAACAADAABAABA", pattern = "AABA";
		int lps[] = getlps(pattern);
		implementKMP(text, pattern, lps);
		//printArray(getlps(pattern));
	}

	public static void implementKMP(String text, String pattern, int [] lps) {
		//	i is iterator for text and j is iterator for pattern
		int i=0,j=0,n=text.length(),m=pattern.length();
		while(i < n) {
			if(text.charAt(i)==pattern.charAt(j)) {
				i++;
				j++;
			}
			//	If the complete pattern is traversed, then we found the pattern
			//	inside the text, so, print it's
			if(j==m) {
				System.out.println("Pattern found at index : " + (i-j));
				j = lps[j-1];
			}
			//	When a mismatch occurs
			else if(i < n && text.charAt(i)!=pattern.charAt(j)) {
				if(j!=0)
					j = lps[j-1];
				else {
					j = 0;
					i++;
				}
			}
		}
	}

	public static int[] getlps(String pattern) {
		int n = pattern.length();
		int lps[] = new int[n];

		// lps[0] is always 0
		lps[0] = 0;

		int j = 0, i = 1;
		while (i < n) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				j++;
				lps[i] = j;
				i++;
			}
			// If i and j characters do not match
			else {
				// Move to the previous lps i.e. lps[j-1]
				if (j != 0)
					j = lps[j - 1];
				else { // when j is zero
					lps[i] = j;
					i++;
				}
			}

		}
		return lps;
	}

	public static void printArray(int[] arr) {
		for (int num : arr)
			System.out.print(num + " ");
		System.out.println();
	}
}
package com.ibits.strings;

/*
 * https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/
 * https://www.geeksforgeeks.org/minimum-characters-added-front-make-string-palindrome/
 */
public class MinimumCharactersToAddForPalindrome {

	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("AACECAAAA");
		int lps[] = getlps(str +  "$" + str.reverse());
		
		//	Required answer will be original string length - lps[n-1]
		System.out.println(str.length() - lps[lps.length-1]);
	}

	private static int[] getlps(String pattern) {
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
	

}

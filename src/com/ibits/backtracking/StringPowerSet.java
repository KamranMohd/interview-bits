package com.ibits.backtracking;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/powet-set-lexicographic-order/
 */

public class StringPowerSet {

	public static void main(String[] args) {
		//String str = "abc";
		String str = "bac";
		int n = str.length();
		
		char [] ch = str.toCharArray();
		//	Sort the string first as we need print the subsets in order
		Arrays.sort(ch);
		String string = new String(ch);
		printPowerInLexicographicalOrder(string, n, 0, "");
	}
	
	public static void printPowerInLexicographicalOrder(String str, int n, int index, String currentStr) {
		if(index > n)
			return;
		
		//	Print the current string
		System.out.println(currentStr);
		
		//	Consider each string starting from the 
		//	one of the characters
		for(int i=index;i<n;i++) {
			currentStr += str.charAt(i);
			printPowerInLexicographicalOrder(str, n, i + 1, currentStr);
			//	Back track and remove the current element from the current string
			currentStr = currentStr.substring(0, currentStr.length()-1);
		}
	}
}
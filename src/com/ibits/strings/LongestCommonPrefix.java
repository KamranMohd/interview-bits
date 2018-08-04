package com.ibits.strings;

import java.util.ArrayList;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// String str[] = {"abcd", "abcd", "efgh"};
		String str[] = { "abcdefgh","aefghijk","abcefgh" };
		ArrayList<String> A = new ArrayList<>();
		for (String s : str)
			A.add(s);
		System.out.println("Longest common prefix : " + longestCommonPrefix(A));

	}

	public static String longestCommonPrefix(ArrayList<String> A) {
		if (A.size() == 0)
			return "";
		if (A.size() == 1)
			return A.get(0);

		int candidateIndex = getSmallestLengthString(A);
		String candidateStr = A.get(candidateIndex);
		int i = 0;
		while (candidateStr.length() > 0 && i < A.size()) {
			//System.out.println(candidateStr + " " + A.get(i).startsWith(candidateStr));
			if (i == candidateIndex) {
				i++;
				continue;
			}
			if (A.get(i).startsWith(candidateStr))
				i++;
			else {
				candidateStr = candidateStr.substring(0, candidateStr.length() - 1);
				i = 0;
			}
		}
		return candidateStr;
	}

	public static int getSmallestLengthString(ArrayList<String> A) {
		int min = Integer.MAX_VALUE, index = -1;
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i).length() < min) {
				min = A.get(i).length();
				index = i;
			}
		}
		return index;
	}

}

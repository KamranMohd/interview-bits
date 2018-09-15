package com.ibits.backtracking;

/*
 * https://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
 */
public class GenerateAllPossibleParenthesesBalanced {

	public static void main(String[] args) {
		int n = 3;
		// Create a brackets array that will store the string
		// of parentheses with n opening and n closing brackets
		char brackets[] = new char[2 * n];
		printAllPossibleParentheses(brackets, n, 0, 0, 0);
	}

	public static void printAllPossibleParentheses(char[] ch, int n, int openBrackets, int closeBrackets,
			int currentPos) {
		// Base condition: If the number of closing brackets equal to n
		if (closeBrackets == n) {
			System.out.println(new String(ch));
			return;
		}
		// Now, there are 2 cases we can either use { or }

		// Case 2: If we use {, then we must make sure that we are not using { for
		// more than n times as defined by the input
		if (openBrackets < n) {
			ch[currentPos] = '(';
			printAllPossibleParentheses(ch, n, openBrackets + 1, closeBrackets, currentPos + 1);
		}

		// Case 1 : If we use }, we need to make sure that the number of opening
		// brackets is
		// greater than the closing brackets otherwise the exp will become unbalanced
		if (openBrackets > closeBrackets) {
			ch[currentPos] = ')';
			printAllPossibleParentheses(ch, n, openBrackets, closeBrackets + 1, currentPos + 1);
		}

	}

}

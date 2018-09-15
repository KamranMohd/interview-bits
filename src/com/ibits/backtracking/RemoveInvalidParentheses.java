package com.ibits.backtracking;

import java.util.HashSet;
import java.util.LinkedList;

/*
 * https://www.geeksforgeeks.org/remove-invalid-parentheses/
 */
public class RemoveInvalidParentheses {

	public static void main(String[] args) {
		String str = "()())()";
		// String str = "()v)";
		// String str = "()()()";
		int n = str.length();
		getValidParenthese(str, n);
	}

	public static void getValidParenthese(String str, int n) {
		// If the string is empty return
		if (n == 0)
			return;

		// Create a set to store the already visited string
		HashSet<String> visited = new HashSet<>();

		// Create a queue to hold the string after removing parentheses
		LinkedList<String> q = new LinkedList<>();

		// Add the initial string to both the data structure
		visited.add(str);
		q.add(str);

		boolean level = false;

		while (!q.isEmpty()) {
			String pop = q.poll();

			// Check if the string is valid. If yes, then we can't go
			// further than this in removing the parentheses as we need
			// to remove the minimum number of parentheses. We just process
			// the remaining strings in the queue
			if (isValidExpression(pop)) {
				System.out.println(pop);
				level = true;
			}
			if (level)
				continue;

			// If we have not found any valid string after removing
			// n parentheses, we will remove 1 more parentheses and check
			// again if a valid expression is found

			for (int i = 0; i < pop.length(); i++) {
				// Remove parentheses only if the current character is parentheses
				if (!isParentheses(pop.charAt(i)))
					continue;

				// Else remove the current parentheses at index i and add to the
				// queue and visited set if not already visited
				String temp = pop.substring(0, i) + pop.substring(i + 1);
				if (!visited.contains(temp)) {
					visited.add(temp);
					q.add(temp);
				}
			}
		}
	}

	private static boolean isValidExpression(String pop) {
		// Count the number of closing and opening brackets
		int count = 0;
		for (int i = 0; i < pop.length(); i++) {
			char ch = pop.charAt(i);
			if (ch == '(')
				count++;
			else if (ch == ')')
				count--;
			if (count < 0)
				return false;
		}
		return count == 0;
	}

	private static boolean isParentheses(char ch) {
		return ch == ')' || ch == '(';
	}
}

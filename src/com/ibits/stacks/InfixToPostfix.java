package com.ibits.stacks;

/*
 * https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
 */
import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		String infix = "a+b*(c^d-e)^(f+g*h)-i";
		String postFixExpression = convertToPostFix(infix);
		System.out.println("Postfix expression : " + postFixExpression);
	}

	public static String convertToPostFix(String infix) {
		String postfix = "";
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < infix.length(); i++) {
			char ch = infix.charAt(i);
			if (isOperand(ch))
				postfix += ch;
			else if (isOpenParenthese(ch))
				s.push(ch);
			else if (isOperator(ch)) {
				while(!s.isEmpty() && getPrecedence(s.peek()) >= getPrecedence(ch)) 
					postfix+=s.pop();
				s.push(ch);
			} else if(isClosedParenthese(ch)){
				// For closed parentheses
				while(!s.isEmpty() && s.peek()!='(')
					postfix+=s.pop();
				s.pop();
			}
		}
		while(!s.isEmpty())
			postfix+=s.pop();
		return postfix;
	}

	private static int getPrecedence(char ch) {
		if (ch == '^')
			return 3;
		else if (ch == '*' || ch == '/')
			return 2;
		else if (ch == '+' || ch == '-')
			return 1;
		return -1;
	}

	private static boolean isOperand(char ch) {
		return !isOperator(ch) && !isOpenParenthese(ch) && !isClosedParenthese(ch);
	}

	private static boolean isOperator(char ch) {
		return ch == '*' || ch == '/' || ch == '+' || ch == '-' || ch=='^';
	}

	private static boolean isClosedParenthese(char ch) {
		return ch == ')';
	}

	private static boolean isOpenParenthese(char ch) {
		return ch == '(';
	}

}

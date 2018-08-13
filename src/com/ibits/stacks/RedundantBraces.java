package com.ibits.stacks;

/*
 * https://www.interviewbit.com/problems/redundant-braces/
 */
import java.util.Stack;

public class RedundantBraces {

	public static void main(String[] args) {
		//String str = "((a+b))";
		//String str = "(a+(a+b))";
		String str = "(((a+b) + c + )";
		System.out.println(redundantBraces(str));
	}

	public static int redundantBraces(String str) {
		Stack<Character> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();

		int n = str.length();

		for (int i = 0; i < n; i++) {
			char ch = str.charAt(i);
			if (ch == ' ')
				continue;
			// If the character is an operand, push it to operand stack
			if (isOperand(ch))
				operands.push(ch);

			else if (isOpenBracket(ch))
				operators.push(ch);

			else if (isOperator(ch)) {
				while (!operators.isEmpty() && getPrecedence(ch) <= getPrecedence(operators.peek())) {
					operands.pop();
					operators.pop();
				}
				operators.push(ch);
			} else {
				if(operators.isEmpty() || isOpenBracket(operators.peek()))
					return 1;
				while(!operators.isEmpty() && !isOpenBracket(operators.peek())) {
					operands.pop();
					operators.pop();
				}
				operators.pop();
			}
		}
		return 0;
	}

	public static boolean isOperand(char ch) {
		return !isOpenBracket(ch) && !isClosedBracket(ch) && !isOperator(ch);
	}

	public static int getPrecedence(char ch) {
		if (ch == '*' || ch == '/')
			return 2;
		else if (ch == '+' || ch == '-')
			return 1;
		else
			return 0;
	}

	public static boolean isOpenBracket(char ch) {
		return ch == '(';
	}

	public static boolean isClosedBracket(char ch) {
		return ch == ')';
	}

	public static boolean isOperator(char ch) {
		return ch == '/' || ch == '+' || ch == '*' || ch == '-';
	}

}

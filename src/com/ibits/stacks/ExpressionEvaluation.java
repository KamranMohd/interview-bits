package com.ibits.stacks;
/*
 * https://www.geeksforgeeks.org/expression-evaluation/
 */
import java.util.Stack;

public class ExpressionEvaluation {

	public static void main(String[] args) {
		//String expression = "10 + 2 * 6";
		//String expression = "100 * 2 + 12";
		String expression = "100 * ( 2 + 12 )";
		//String expression = "100 * ( 2 + 12 ) / 14";
		String expTokens[] = expression.split(" ");
		
		System.out.println(getExpressionValue(expTokens));
	}

	public static int getExpressionValue(String[] exp) {
		// Create 2 arrays one for operators/brackets and
		// the other for values
		Stack<Integer> val = new Stack<>();
		Stack<String> ops = new Stack<>();

		int n = exp.length;

		for (int i = 0; i < n; i++) {
			String ch = exp[i];
			// If the current character is a value, push it on the value stack
			if (isValue(ch))
				val.push(Integer.parseInt(ch));
			// If left parentheses push it onto the operator stack
			else if (isOpenParentheses(ch))
				ops.push(ch);
			// If right parenthesis, then pop until the left operator is not encountered
			else if (isClosedParentheses(ch)) {
				while (!ops.isEmpty() && !isOpenParentheses(ops.peek())) {
					String op = ops.pop();
					int val1 = val.pop();
					int val2 = val.pop();
					val.push(evaluateExpression(val2, val1, op));
				}
				if (!ops.isEmpty())
					ops.pop();
			}

			// If the character is an operator
			else {
				while (!ops.isEmpty() && !ops.peek().equals("(") && hasPrecedence(ops.peek(), ch)) {
					String op = ops.pop();
					int val1 = val.pop();
					int val2 = val.pop();
					val.push(evaluateExpression(val2, val1, op));
				}
				ops.push(ch);
			}
		}
		
		//	Loop until there are operators in the operator stack
		while(!ops.empty()) {
			int val1 = val.pop();
			int val2 = val.pop();
			String op = ops.pop();
			val.push(evaluateExpression(val2, val1, op));
		}
		return val.pop();
	}

	private static int evaluateExpression(int val1, int val2, String op) {
		if (op.equals("*"))
			return val1 * val2;
		if (op.equals("/"))
			return val1 / val2;
		if (op.equals("+"))
			return val1 + val2;
		return val1 - val2;
	}

	public static boolean hasPrecedence(String ch1, String ch2) {
		if (ch1.equals("*") || ch1.equals("/"))
			return true;
		else if ((ch1.equals("+") || ch1.equals("-")) && (ch2.equals("+") || ch2.equals("-")))
			return true;
		System.out.println("returning true : " + ch1 + " " + ch2);
		return false;
	}

	public static boolean isValue(String ch) {
		return (!isOpenParentheses(ch) && !isClosedParentheses(ch) && !isOperator(ch));
	}

	public static boolean isOpenParentheses(String ch) {
		return ch.equals("(");
	}

	public static boolean isClosedParentheses(String ch) {
		return ch.equals(")");
	}

	public static boolean isOperator(String ch) {
		return ch.equals("*") || ch.equals("+") || ch.equals("/") || ch.equals("-");
	}

}

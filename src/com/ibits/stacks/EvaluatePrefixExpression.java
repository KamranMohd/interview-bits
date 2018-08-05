package com.ibits.stacks;

import java.util.Stack;

public class EvaluatePrefixExpression {

	public static void main(String[] args) {
		

	}
	
	public static int evaluatePostFix(String [] str){
		Stack<Integer> s = new Stack<>();
		
		return s.pop();
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
	
	public static boolean isOperator(String ch) {
		return ch.equals("*") || ch.equals("+") || ch.equals("/") || ch.equals("-");
	}

}

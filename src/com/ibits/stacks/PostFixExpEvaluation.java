package com.ibits.stacks;

/*
 * https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
 */
import java.util.Stack;

public class PostFixExpEvaluation {

	public static void main(String[] args) {
		String exp = "100 200 + 2 / 5 * 7 +";
		System.out.println(evaluatePostFix(exp.split(" ")));
	}
	
	public static int evaluatePostFix(String [] str){
		Stack<Integer> s = new Stack<>();
		for(int i=0;i<str.length;i++){
			String ch = str[i];
			if(isOperator(ch)){
				//	Take care of division
				int val2 = s.pop();
				int val1 = s.pop();
				int result = evaluateExpression(val1, val2, ch);
				System.out.println(result);
				s.push(result);
			}else{
				s.push(Integer.parseInt(ch));
			}
		}
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

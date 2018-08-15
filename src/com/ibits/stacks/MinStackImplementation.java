package com.ibits.stacks;

/*
 * https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 * Related links : https://www.geeksforgeeks.org/tracking-current-maximum-element-in-a-stack/
 */

import java.util.Stack;

public class MinStackImplementation {
	static Stack<Integer> stack = new Stack<>();
	static int min = -1;
	
	public static void main(String[] args) {
		push(3);
		push(5);
		System.out.println(getMin());
		push(2);
		push(1);
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
		pop();
		System.out.println(peek());
	}
	
	public static void push(int n) {
		//	If the element to be added is less than the minimum
		//	we add 2*n - min to the stack and store min = n;
		if(stack.isEmpty()) {
			stack.push(n);
			min = n;
		}
		else if(n < min) {
			stack.push(2 * n - min);
			min = n;
		}
		else
			stack.push(n);
	}

	public static void pop() {
		//	Remove the element from the top.
		//	If the removed element is less that the min
		//	vale, update the minimum value
		if(!stack.isEmpty()) {
			int popped = stack.pop();
			min = (popped < min) ? 2 * min - popped : min;
		}
	}
	
	public static int getMin() {
		return stack.isEmpty() ? -1 : min;
	}

	public static int peek() {
		//	Return the element at the top of the stack
		//	without removing it. If the element at the top
		//	is less than the min, then the actual value on 
		//	the top of the stack is min
		if(stack.isEmpty())
			return -1;
		else {
			int peek = stack.peek();
			return peek < min ? min : peek;
		}
	}
}

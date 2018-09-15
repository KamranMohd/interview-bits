package com.ibits.hashing;

/*
 * https://www.interviewbit.com/problems/colorful-number/
 */
import java.util.HashSet;
import java.util.Set;

public class ColourfulNumber {

	public static void main(String[] args) {
		// int n = 23;
		//	int n = 3245;
		// int n = 234;
		int n = 123;
		System.out.println(colorful(n));
	}

	public static int colorful(int A) {
		// Store all the digits in an array
		int n = (int) Math.log10(A) + 1;
		int[] digits = new int[n];
		int i = n - 1;
		while (A > 0) {
			digits[i--] = A % 10;
			A /= 10;
		}
		Set<Integer> product = new HashSet<>();
		for (i = 1; i <= n; i++) {
			for (int j = 0; j <= n - i; j++) {
				int count = 0, prod = 1;
				while (count < i) {
					prod *= digits[j + count];
					count++;
				}
				// System.out.println(prod);
				if (product.contains(prod))
					return 0;
				else
					product.add(prod);
			}
		}

		return 1;
	}

}

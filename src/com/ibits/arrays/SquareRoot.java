package com.ibits.arrays;

public class SquareRoot {

	public static void main(String[] args) {
		int a = 930675566;
		System.out.println(getSqrt(a));
	}

	public static int getSqrt(int a) {
		if (a == 0 || a == 1)
			return a;
		int low = 1, high = a / 2, ans = 0;
		long product;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			product = (long) mid * mid;
			if (product == a)
				return mid;
			else if (product < a) {
				ans = mid;
				low = mid + 1;
			} else
				high = mid - 1;
		}
		return ans;
	}

}

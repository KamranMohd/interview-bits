package com.ibits.arrays;

/*
 * https://www.interviewbit.com/problems/max-non-negative-subarray/
 */
import java.util.ArrayList;

public class MaxSumSubarray {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();

		A.add(2);
		A.add(5);
		A.add(6);
		A.add(-1);
		A.add(-2);

		/*
		 * A.add(-2); A.add(-5); A.add(-6); A.add(-1); A.add(-2);
		 */
		ArrayList<Integer> res = maxset(A);
		for (int i = 0; i < res.size(); i++)
			System.out.print(res.get(i) + " ");
	}

	public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
		ArrayList<Integer> current = new ArrayList<>();
		ArrayList<Integer> max = new ArrayList<>();

		long currentSum = 0;
		long maxSum = 0;

		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) >= 0) {
				currentSum += A.get(i);
				current.add(A.get(i));
			} else {
				if ((currentSum > maxSum)
						|| (currentSum == maxSum && current.size() > max.size())) {
					max = current;
					maxSum = currentSum;
				}
				currentSum = 0;
				current = new ArrayList<>();
			}
		}
		if ((currentSum > maxSum)
				|| (currentSum == maxSum && current.size() > max.size())) {
			max = current;
		}
		return max;
	}

}

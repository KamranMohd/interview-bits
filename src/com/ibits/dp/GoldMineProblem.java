package com.ibits.dp;

/*
 * https://www.geeksforgeeks.org/gold-mine-problem/
 */
import java.util.Arrays;

public class GoldMineProblem {

	public static void main(String[] args) {
		// int mat[][] = { { 1, 3, 3 }, { 2, 1, 4 }, { 0, 6, 4 } };
		// int mat[][] = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2
		// } };
		int mat[][] = { { 10, 33, 13, 15 }, { 22, 21, 04, 1 }, { 5, 0, 2, 3 }, { 0, 6, 14, 2 } };
		System.out.println("Maximum gold that can be collected : " + getMaxGold(mat));
	}

	public static int getMaxGold(int[][] mat) {
		int rows = mat.length, cols = mat[0].length;

		int dp[][] = new int[rows][cols];

		// Initialize to 0
		for (int[] col : dp)
			Arrays.fill(col, 0);

		//	We have taken the outer to be the columns because
		//	we are always moving right in all the 3 directions
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				int right = i == 0 ? 0 : dp[j][i - 1];
				int right_up = (j == rows - 1 || i == 0) ? 0 : dp[j + 1][i - 1];
				int right_down = (j == 0 || i == 0) ? 0 : dp[j - 1][i - 1];

				dp[j][i] = mat[j][i] + Math.max(Math.max(right_up, right_down), right);
			}
		}
		/*for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++)
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}*/

		int res = Integer.MIN_VALUE;
		
		for (int i = 0; i < rows; i++) {
			res = Math.max(res, dp[i][cols - 1]);
		}
		return res;
	}

}

package com.ibits.dp;

public class MinSumPath {

	public static void main(String[] args) {
		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		int m = cost.length - 1, n = cost[0].length - 1;
		System.out.println(getMinPath(cost, m, n));
	}

	public static int getMinPath(int[][] cost, int m, int n) {
		if (m < 0 || n < 0)
			return 0;
		int dp[][] = new int[m + 1][n + 1];
		dp[0][0] = cost[0][0];
		for (int i = 1; i <= m; i++)
			dp[i][0] = dp[i - 1][0] + cost[i][0];

		for (int j = 1; j <= n; j++)
			dp[0][j] = dp[0][j - 1] + cost[0][j];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++)
				dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + cost[i][j];
		}

		return dp[m][n];
	}

}

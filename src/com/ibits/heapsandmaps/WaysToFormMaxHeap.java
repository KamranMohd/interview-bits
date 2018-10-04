package com.ibits.heapsandmaps;

/*
 * https://www.geeksforgeeks.org/number-ways-form-heap-n-distinct-integers/
 */
public class WaysToFormMaxHeap {

	static int N = 100;
	static int bio[][] = new int[N + 1][N + 1];
	static int dp[] = new int[N + 1];
	static int log2[] = new int[N + 1];
	
	public static void main(String[] args) {
		int n = 7;
		//int dp[] = new int[n + 1];

		// Initialize dp[]
		for (int i = 0; i <= n; i++)
			dp[i] = -1;

		// Initialize choosing k from n values
		//int bio[][] = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++)
				bio[i][j] = -1;
		}

		// Initialize log2[n]
		//int log2[] = new int[n + 1];
		int currentPow = 1, currentLog = -1;
		for (int i = 0; i <= n; i++) {
			if (currentPow == i) {
				currentLog++;
				currentPow *= 2;
			}
			log2[i] = currentLog;
		}
		System.out.println(getWaysToFormMaxHeap(n));
	}

	/*public static int getWaysToFormMaxHeap(int n, int[] dp, int[][] bio, int[] log2) {
		if (n <= 1)
			return 1;
		if (dp[n] != -1)
			return dp[n];

		int left = getLeft(n, log2);
		int ans = choose(n - 1, left, bio) * getWaysToFormMaxHeap(left, dp, bio, log2)
				* getWaysToFormMaxHeap(n - 1 - left, dp, bio, log2);
		dp[n] = ans;
		return ans;
	}

	private static int choose(int n, int k, int[][] bio) {
		if (k > n)
			return 0;
		if (k == 0)
			return 1;
		if (n <= 1)
			return 1;
		if (bio[n][k] != -1)
			return bio[n][k];
		int ans = choose(n - 1, k - 1, bio) + choose(n - 1, k, bio);
		bio[n][k] = ans;
		return ans;
	}

	private static int getLeft(int n, int[] log2) {
		if (n == 1)
			return 0;

		// Height/level of the heap
		int h = log2[n];

		// Maximum nodes possible at level h
		int maxNodes = (1 << h); // (2^h)

		// Actual nodes present at this level is
		//	total nodes - (sum of all nodes before hth level)
		int actualNodes = n - ((1 << h) - 1);
		
		if(actualNodes >= maxNodes/2) 
			return (1<<h) - 1;
		return (1<<h) - 1 - (maxNodes/2 - actualNodes);
	}*/
	
	public static int getWaysToFormMaxHeap(int n) {
		if (n <= 1)
			return 1;
		if (dp[n] != -1)
			return dp[n];

		int left = getLeft(n);
		System.out.println(left);
		int ans = choose(n - 1, left) * getWaysToFormMaxHeap(left)
				* getWaysToFormMaxHeap(n - 1 - left);
		dp[n] = ans;
		return ans;
	}

	private static int choose(int n, int k) {
		if (k > n)
			return 0;
		if (k == 0)
			return 1;
		if (n <= 1)
			return 1;
		if (bio[n][k] != -1)
			return bio[n][k];
		long ans = ((choose(n - 1, k - 1) % 1000000007) + (choose(n - 1, k) % 1000000007)) % 1000000007;
		bio[n][k] = (int)ans;
		return (int)ans;
	}

	private static int getLeft(int n) {
		if (n == 1)
			return 0;

		// Height/level of the heap
		int h = log2[n];

		// Maximum nodes possible at level h
		int maxNodes = (1 << h); // (2^h)

		// Actual nodes present at this level is
		//	total nodes - (sum of all nodes before hth level)
		int actualNodes = n - ((1 << h) - 1);
		System.out.println("h : " + h + " n : " + n +  " actual nodes : " + actualNodes + " max nodes : " + maxNodes);
		if(actualNodes >= maxNodes/2)  
			return (1<<h) - 1;
		return (1<<h) - 1 - (maxNodes/2 - actualNodes);
	}

}

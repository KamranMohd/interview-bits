package com.ibits.backtracking;

/*
 * https://www.geeksforgeeks.org/print-all-possible-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/
 */
public class PrintAllPossiblePaths {

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
		int m = mat.length, n = mat[0].length;
		printAllPaths(mat, m, n);
	}

	private static void printAllPaths(int[][] mat, int m, int n) {
		int[] path = new int[m + n - 1];
		System.out.println("Method 1");
		printAllPathsUtils(mat, 0, 0, m, n, path, 0);
		System.out.println("Method 2");
		printAllPathsUtils2(mat, 0, 0, m, n, path, 0);
	}

	private static void printAllPathsUtils(int[][] mat, int i, int j, int m, int n, int[] path, int pos) {
		// Base condition 1: Check if we have reached the end of
		// right extreme
		if (j == n - 1) {
			for (int k = i; k < m; k++)
				path[pos++] = mat[k][j];
			// Print the path
			for (int pa : path)
				System.out.print(pa + " ");
			System.out.println();
			return;
		}

		// Base condition 2: Check if we have reached the bottom
		if (i == m - 1) {
			for (int k = j; k < n; k++)
				path[pos++] = mat[i][k];
			// Print the path
			for (int pa : path)
				System.out.print(pa + " ");
			System.out.println();
			return;
		}

		// If the base conditions are not true, add the current pos to the path
		path[pos] = mat[i][j];

		// Then, recursively call the next cells
		printAllPathsUtils(mat, i + 1, j, m, n, path, pos + 1);
		printAllPathsUtils(mat, i, j + 1, m, n, path, pos + 1);
	}

	private static void printAllPathsUtils2(int[][] mat, int i, int j, int m, int n, int[] path, int pos) {
		// Base condition 1: If we have reached the destination
		if (i == m - 1 && j == n - 1) {
			path[pos] = mat[i][j];
			// Print the sol and return
			for (int point : path)
				System.out.println(point + " ");
			return;
		}
		// Base condition 2: If we overflow
		if (i > m - 1 || j > n - 1) {
			return;
		}

		// If the base conditions are not true, add the current pos to the path
		path[pos] = mat[i][j];

		// Then, recursively call the next cells
		printAllPathsUtils(mat, i + 1, j, m, n, path, pos + 1);
		printAllPathsUtils(mat, i, j + 1, m, n, path, pos + 1);
	}

}

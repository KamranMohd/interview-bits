package com.ibits.backtracking;

public class NQueen {

	public static void main(String[] args) {
		int n = 4;
		solveNQueen(n);
	}

	public static void solveNQueen(int n) {
		int chess[][] = new int[n][n];

		// Initialize all the cells with 0
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				chess[i][j] = 0;
		}

		if (solveNQueenUtils(chess, 0, n) == false) {
			System.out.println("No solution exists");
			return;
		}
	}

	private static boolean solveNQueenUtils(int[][] chess, int col, int n) {
		if (col == n) {
			printSolution(chess, n);
			return true;
		}

		// Check for each row in the current column and check if the queen
		// can be placed in that row
		boolean res = false;
		for (int i = 0; i < n; i++) {
			if (isSafe(chess, i, col, n)) {
				chess[i][col] = 1;
				/*if (solveNQueenUtils(chess, col + 1, n))
					return true;
				else*/
				res = solveNQueenUtils(chess, col + 1, n) || res;
				chess[i][col] = 0; // Backtrack
			}
		}
		return res;
	}

	private static boolean isSafe(int[][] chess, int row, int col, int n) {
		// Check if the queen can be placed in the given row
		// for the given col, if col-1 queens are already placed
		for (int i = 0; i < col; i++) {
			if (chess[row][i] == 1)
				return false;
		}

		// Check for upper-left diagonal
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (chess[i][j] == 1)
				return false;
		}

		// Check for upper-left diagonal
		for (int i = row, j = col; i < n && j >= 0; i++, j--) {
			if (chess[i][j] == 1)
				return false;
		}

		return true;
	}

	private static void printSolution(int[][] chess, int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				System.out.print(chess[i][j] + "\t");
			System.out.println();
		}
		System.out.println();
	}

}

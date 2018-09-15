package com.ibits.backtracking;

/*
 * https://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/
 */

public class KnightTour {

	public static void main(String[] args) {
		solveKnightTour();
	}

	public static boolean solveKnightTour() {
		int solution[][] = new int[8][8];
		// Initialize the solution matrix
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++)
				solution[i][j] = -1;
		}

		// Possible eight moves that the Knight
		// can take
		int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		// Since, the first move is taken from 0,0
		solution[0][0] = 0;

		if (solveKT(0, 0, 1, xMove, yMove, solution) == false) {
			System.out.println("No solution exists");
			return false;
		}
		//printSolution(solution);
		return true;
	}

	public static boolean solveKT(int x, int y, int totalMoves, int[] xMove, int[] yMove, int[][] sol) {
		// Check if we have found the solution
		if (totalMoves == 64) {
			printSolution(sol);
			return true;
		}
			
		// Try all possible 8 moves that the
		// knight can take from the current position
		boolean res = false;
		for (int i = 0; i < 8; i++) {
			int nextX = x + xMove[i];
			int nextY = y + yMove[i];
			if (isMovePossible(nextX, nextY, sol)) {
				sol[nextX][nextY] = totalMoves;
				res = solveKT(nextX, nextY, totalMoves + 1, xMove, yMove, sol) || res;
				/*if (solveKT(nextX, nextY, totalMoves + 1, xMove, yMove, sol))
					return true;
				else*/
				sol[nextX][nextY] = -1; // backtracking
			}
		}
		return res;
	}

	private static boolean isMovePossible(int nextX, int nextY, int[][] sol) {
		if (nextX >= 0 && nextX < 8 && nextY >= 0 && nextY < 8 && sol[nextX][nextY] == -1)
			return true;
		return false;
	}

	private static void printSolution(int[][] solution) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(solution[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

}

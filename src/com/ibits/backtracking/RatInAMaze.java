package com.ibits.backtracking;

/*
 * https://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/
 * Variation: Where multiple steps/jumps are allowed 
 * https://www.geeksforgeeks.org/rat-in-a-maze-with-multiple-steps-jump-allowed/
 */
public class RatInAMaze {

	public static void main(String[] args) {
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		solveRatAndMaze(maze);
	}

	public static void solveRatAndMaze(int[][] maze) {
		int rows = maze.length;
		int cols = maze[0].length;
		int sol[][] = new int[rows][cols];

		// Initialize the solution path
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++)
				sol[i][j] = 0;
		}

		if (solveRatAndMazeUtil(0, 0, rows, cols, maze, sol) == false) {
			System.out.println("Solution does not exist");
		} else
			printSolution(sol, rows, cols);
	}

	private static boolean solveRatAndMazeUtil(int x, int y, int rows, int cols, int[][] maze, int[][] sol) {
		// Check if the solution is found
		if (x == rows - 1 && y == cols - 1) {
			sol[x][y] = 1;
			return true;
		}

		if (isPossible(x, y, rows, cols, maze)) {
			sol[x][y] = 1;

			// Check if there is a solution if we move to right
			if (solveRatAndMazeUtil(x + 1, y, rows, cols, maze, sol))
				return true;
			// Check if there is a solution if we move to left
			if (solveRatAndMazeUtil(x, y + 1, rows, cols, maze, sol))
				return true;
			// Else backtrack and remove the solution
			sol[x][y] = 0;
			return false;
		}

		return false;
	}

	private static boolean isPossible(int x, int y, int rows, int cols, int[][] maze) {
		if (x >= 0 && x <= rows - 1 && y >= 0 && y <= cols - 1 && maze[x][y] == 1)
			return true;
		return false;
	}

	private static void printSolution(int[][] solution, int rows, int cols) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(solution[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

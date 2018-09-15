package com.ibits.backtracking;

/*
 * https://www.geeksforgeeks.org/sudoku-backtracking-7/
 */
public class Sudoku {

	public static void main(String[] args) {
		int sudoku[][] = {{2, 0, 7, 0, 8, 3, 0, 1, 0},
		                {3, 8, 1, 0, 0, 0, 7, 0, 9},
		                {9, 0, 0, 1, 7, 5, 2, 0, 8},
		                {0, 1, 0, 0, 9, 7, 3, 0, 2},
		                {4, 0, 3, 0, 0, 2, 0, 8, 0},
		                {6, 0, 2, 3, 4, 0, 0, 0, 1},
		                {0, 3, 4, 2, 6, 0, 0, 0, 5},
		                {1, 0, 9, 0, 0, 4, 8, 2, 3},
		                {0, 2, 0, 0, 3, 0, 1, 0, 4}};
		solveSudoku(sudoku);
	}
	
	public static boolean solveSudoku(int [][] sudoku) {
		//	Create an array of size to store the row and col
		//	of the unfilled cell
		int unfilled[] = new int[2];
		//	Base condition: If there is no unfilled space, then the soduko is solved
		if(!unFilledSpace(sudoku, unfilled)) {
			printSolution(sudoku);
			return true;
		}
		int row = unfilled[0];
		int col = unfilled[1];
		//	Generate all the numbers from 1 to 9
		//	and check if it leads to the correct solution
		for(int i=1;i<=9;i++) {
			if(isSafe(sudoku,row,col,i)) {
				sudoku[row][col] = i;
				
				//	Check if this leads to the correct solution
				if(solveSudoku(sudoku))
					return true;
				
				//	Else, backtrack
				sudoku[row][col] = 0;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] sudoku, int row, int col, int i) {
		return !inCol(sudoku,row, col,i) && !inRow(sudoku,row,col, i) && !inSquare(sudoku,row,col,i);
	}

	private static boolean inRow(int[][] sudoku, int row, int col, int num) {
		//	Check if the number is present in all the rows for a given column
		for(int i=0;i<9;i++) {
			if(sudoku[i][col]==num)
				return true;
		}
		return false;
	}
	
	private static boolean inCol(int[][] sudoku, int row, int col, int num) {
		//	Check if the number is present in all the columns for a given row
		for(int i=0;i<9;i++) {
			if(sudoku[row][i]==num)
				return true;
		}
		return false;
	}
	
	private static boolean inSquare(int[][] sudoku, int row, int col, int num) {
		//	Get the starting row and column of the square
		int r = row - (row%3);
		int c = col - (col%3);
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(sudoku[i+r][j+c]==num)
					return true;
			}
		}
		return false;
	}

	private static boolean unFilledSpace(int[][] sudoku, int[] unfilled) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++)
				if(sudoku[i][j]==0) {
					//	Fill the unfilled with the 
					//	row number and column number
					unfilled[0] = i;
					unfilled[1] = j;
					return true;
				}
		}
		return false;
	}
	
	private static void printSolution(int[][] sudoku) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++)
				System.out.print(sudoku[i][j] +  "\t");
			System.out.println();
		}
		System.out.println();
	}
}
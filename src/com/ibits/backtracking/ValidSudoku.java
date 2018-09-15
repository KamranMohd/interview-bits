package com.ibits.backtracking;

import java.util.HashSet;

public class ValidSudoku {

	public static void main(String[] args) {
		char board[][] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println("Valid sudoku : " + isSudokuValid(board));
	}

	private static boolean isSudokuValid(char[][] board) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				//	Check if the cell is filled
				if(board[i][j]=='.')
					continue;
				if(!isValid(board, i, j))
					return false;
			}
		}
		return true;
	}

	private static boolean isValid(char[][] board, int row, int col) {
		return notInRow(board, row, col) && notInCol(board, row, col) && notInSmallSquare(board, row, col);
	}

	private static boolean notInRow(char[][] board, int row, int col) {
		//	Check if value board[i][j] is present in the current row
		HashSet<Character> set = new HashSet<>();
		for(int i=0;i<9;i++) {
			if(set.contains(board[row][i]))
				return false;
			else if(board[row][i]!='.')
				set.add(board[row][i]);
		}
		return true;
	}

	private static boolean notInCol(char[][] board, int row, int col) {
		HashSet<Character> set = new HashSet<>();
		for(int i=0;i<9;i++) {
			if(set.contains(board[i][col]))
				return false;
			else if(board[i][col]!='.')
				set.add(board[i][col]);
		}
		return true;
	}

	private static boolean notInSmallSquare(char[][] board, int row, int col) {
		int startRow = row - row%3, startCol = col - col %3;
		HashSet<Character> set = new HashSet<>();
		for(int i=startRow;i<3;i++) {
			for(int j=startCol;j<3;j++) {
				if(set.contains(board[i][j]))
					return false;
				else if(board[i][j]!='.')
					set.add(board[i][j]);
			}
		}
		return true;
	}

}

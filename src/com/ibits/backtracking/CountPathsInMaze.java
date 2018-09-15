package com.ibits.backtracking;

/*
 * https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze/
 */
public class CountPathsInMaze {

	public static void main(String[] args) {
		int maze[][] = {{-1, 0, 0, 0},
                {0, -1, 0, 0},
                {-1, 0, 0, -1},
                {0, 0, 0, 0}};
		int totalPaths = getPathsInMaze(maze);
		System.out.println("Total paths : " + totalPaths);
	}

	private static int getPathsInMaze(int[][] maze) {
		int rows = maze.length, cols = maze[0].length;
		int paths[][] = new int[rows][cols];
		
		//	If the first cell is blocked then return 0
		if(maze[0][0]==-1)
			return 0;
		
		//	Initialize the values at each cell with 0
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++)
				paths[i][j] = 0;
		}
		
		//	Initialize the first column
		for(int i=0;i<rows;i++) {
			if(maze[i][0]!=-1)
				paths[i][0] = 1;
			else
				break;
		}
		
		//	Initialize the first row
		for(int i=1;i<cols;i++) {
			if(maze[0][i]!=-1)
				paths[0][i] = 1;
			else
				break;
		}
		
		//	Iterate for all the other rows
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				if(maze[i][j]==-1)
					continue;
				if(paths[i-1][j] > 0)
					paths[i][j] += paths[i-1][j];
				
				if(paths[i][j-1] > 0)
					paths[i][j] += paths[i][j-1];
				
			}
		}
		// If the final cell is blocked, 
        // output 0, otherwise the answer
		return maze[rows-1][cols-1] != -1 ? paths[rows-1][cols-1] : 0;
	}

}

package com.ibits.backtracking;

/*
 * https://www.geeksforgeeks.org/m-coloring-problem-backtracking-5/
 */

public class MColoringProblem {

	public static void main(String[] args) {
		int V = 4, m = 3;
		int graph[][] = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 }, };
		mColoring(graph, V, m);
	}

	public static boolean mColoring(int[][] graph, int V, int m) {
		// Define a color array such that color[i] stores the
		// the color that will be used to color the ith vertex
		int color[] = new int[V];
		for (int i = 0; i < V; i++)
			color[i] = 0;

		if (solveMColouring(graph, 0, m, color, V) == false) {
			System.out.println("No solution exists");
			return false;
		}
		printSolution(color);
		return true;
	}

	private static boolean solveMColouring(int[][] graph, int v, int m, int[] color, int V) {
		// Base condition: If the current vertex is same the final vertex
		if (v == V) {
			return true;
		}

		// Loop over all the colors and see if the current
		// vertex v can be added
		for (int i = 1; i <= m; i++) {
			if (isSafe(graph, v, color, V, i)) {
				color[v] = i;
				if (solveMColouring(graph, v + 1, m, color, V)) {
					return true;
				}
				// Backtrack
				color[v] = 0;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] graph, int v, int[] color, int V, int col) {
		for (int i = 0; i < V; i++) {
			if (graph[v][i] == 1 && color[i] == col)
				return false;
		}
		return true;
	}

	private static void printSolution(int[] color) {
		for (int col : color)
			System.out.print(col + " ");
		System.out.println();

	}
}

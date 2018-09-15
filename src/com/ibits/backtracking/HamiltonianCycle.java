package com.ibits.backtracking;

/*
 * https://www.geeksforgeeks.org/hamiltonian-cycle-backtracking-6/
 */
import java.util.Arrays;

public class HamiltonianCycle {

	public static void main(String[] args) {
		/* Let us create the following graph
        (0)--(1)--(2)
         |   / \   |
         |  /   \  |
         | /     \ |
        (3)-------(4)    */
     int graph1[][] = {{0, 1, 0, 1, 0},
         {1, 0, 1, 1, 1},
         {0, 1, 0, 0, 1},
         {1, 1, 0, 0, 1},
         {0, 1, 1, 1, 0},
     };
     int V1 = 5;

     // Print the solution
     hamiltonian(graph1, V1);

     /* Let us create the following graph
        (0)--(1)--(2)
         |   / \   |
         |  /   \  |
         | /     \ |
        (3)       (4)    */
     int graph2[][] = {{0, 1, 0, 1, 0},
         {1, 0, 1, 1, 1},
         {0, 1, 0, 0, 1},
         {1, 1, 0, 0, 0},
         {0, 1, 1, 0, 0},
     };
     int V2 = 5;

     // Print the solution
     hamiltonian(graph2, V2);

	}

	private static boolean hamiltonian(int[][] graph, int V) {
		//	Create a path array such that path[i] contains
		//	a node that is a part of the hamiltonian cycle
		int [] path = new int[V];
		Arrays.fill(path, -1);
		
		//	Added the first node in the path and check for all the adjacent vertex
		path[0] = 0;
		
		if(hamiltonianUtil(graph, V, path, 1)==false) {
			System.out.println("No solution exists");
			return false;
		}
		printSolution(path);
		return true;
	}

	private static boolean hamiltonianUtil(int[][] graph, int V, int[] path, int pos) {
		//	Base condition: If all the nodes are existed
		//	Also, check if there is a vertex from last node to first node
		if(pos==V) {
			//	Check if the last vertex has a path to the 
			//	first vertex
			if(graph[path[pos-1]][path[0]]==1)
				return true;
			return false;
		}
		
		//	Check for all the other vertices
		for(int i=1;i<V;i++) {
			if(isSafe(graph, i, pos, path)) {
				//	Add the vertex to the path
				path[pos] = i;
				//	Check if this leads to the complete solution
				if(hamiltonianUtil(graph, V, path, pos+1))
					return true;
				
				//	Backtrack
				path[pos] = -1;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] graph, int v, int pos, int [] path) {
		//	Check if there is a vertex from current vertex to the 
		//	last added node
		if(graph[v][path[pos-1]]==0)
			return false;
		
		//	Check if the current vertex is already
		//	added in the path
		for(int i=0;i<pos;i++) {
			if(path[i]==v)
				return false;
		}
		return true;
	}
	
	private static void printSolution(int[] path) {
		for(int node : path)
			System.out.print(node + " ");
		System.out.println(path[0]);
	}

}

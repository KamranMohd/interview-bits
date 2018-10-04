package com.ibits.arrays;

import java.util.ArrayList;

public class PasalTriangles {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(pascalTriangle(n));
	}
	
	public static ArrayList<ArrayList<Integer>> pascalTriangle(int n) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for(int i=1;i<=n;i++) {
			int c = 1;
			ArrayList<Integer> row = new ArrayList<Integer>();
			for(int j=0;j<i;j++) {
				if(j==0 || j==i-1) {
					row.add(1);
					continue;
				}
				c = (c*(i-j))/j;
				row.add(c);
			}
			result.add(row);
		}
		return result;
	}

}

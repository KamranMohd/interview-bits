package com.ibits.hashing;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line
 */
public class MaxPointsOnAStraightLine {

	public static void main(String[] args) {
		/*
		 * int[] xarr = { -1, 0, 1, 2, 3, 3 }; int[] yarr = { 1, 0, 1, 2, 3, 4 };
		 */
		/*
		 * int[] xarr = { 1, 1, 1}; int[] yarr = { 0, 4, -1 };
		 */
		int[] xarr = { 4, 8, -4 };
		int[] yarr = { -4, -4, -4 };
		ArrayList<Integer> a = convertToList(xarr);
		ArrayList<Integer> b = convertToList(yarr);
		System.out.println(maxPoints(a, b));
	}

	public static int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		// Create a hashmap that will store the frequency of
		// a particular slope for the n points
		HashMap<Double, Integer> slopeCount = new HashMap<>();
		int maxPoints = 0, currentMax = 0, overlappingPoints = 0, verticalPoints = 0;

		int n = a.size();
		if (n <= 2)
			return n;
		for (int i = 0; i < n; i++) {
			currentMax = overlappingPoints = verticalPoints = 0;
			for (int j = i + 1; j < n; j++) {

				// If both the points are overlapping, i.e. both x and y coordinates are same
				if (a.get(i) == a.get(j) && b.get(i) == b.get(j))
					overlappingPoints++;
				// If both the points are vertical i.e. x coordinate is same
				else if (a.get(i) == a.get(j))
					verticalPoints++;
				else {
					int yDiff = b.get(j) - b.get(i);
					int xDiff = a.get(j) - a.get(i);
					//	Why have we returned 0.0 especially?
					//	Because if xDiff is negative the expression returns -0.0 as the answer
					//	which causes problems
					double slope = yDiff == 0 ? 0.0 : (1.0 * yDiff) / xDiff;
					if (slopeCount.get(slope) != null)
						slopeCount.put(slope, slopeCount.get(slope) + 1);
					else
						slopeCount.put(slope, 1);
					currentMax = Math.max(currentMax, slopeCount.get(slope));
				}
				currentMax = Math.max(currentMax, verticalPoints);
			}
			
			//	Why added 1 to the expression overlappingPoints + currentMax + 1
			//	Because if they are 2 pairs with equal slope, then there are actually 
			//	3 points that lie in the same straight line
			maxPoints = Math.max(maxPoints, overlappingPoints + currentMax + 1);
			slopeCount.clear();
		}
		return maxPoints;
	}

	private static ArrayList<Integer> convertToList(int[] arr) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int num : arr)
			list.add(num);
		return list;
	}

}

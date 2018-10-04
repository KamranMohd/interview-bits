package com.ibits.tree;

/*
 * https://stackoverflow.com/questions/19174796/puzzle-find-the-order-of-n-persons-standing-in-a-line-based-on-their-heights
 * http://qa.geeksforgeeks.org/3974/qa.geeksforgeeks.org/3974/determine-the-actual-order-heights-google.html
 * Reference : Segment tree
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class People {
	int height, infront;

	public People(int height, int infront) {
		this.height = height;
		this.infront = infront;
	}
}

public class OrderPeopleHeight {

	public static void main(String[] args) {
		//int heights[] = { 5, 3, 2, 6, 1, 4 };
		//int infronts[] = { 0, 1, 2, 0, 3, 2 };*/
		int heights[] = { 4, 3, 5, 6, 2, 1 };
		int infronts[] = { 1, 3, 1, 0, 1, 2 };
		int n = heights.length;
		System.out.println(getHeightOrder(heights, infronts, n));
	}

	public static ArrayList<Integer> getHeightOrder(int[] heights, int[] infronts, int n) {
		People persons[] = new People[n];
		for (int i = 0; i < n; i++)
			persons[i] = new People(heights[i], infronts[i]);

		Arrays.sort(persons, new Comparator<People>() {
			@Override
			public int compare(People p1, People p2) {
				return p1.height - p2.height;
			}
		});

		ArrayList<Integer> orderOfHeight = new ArrayList<>();

		People tempOrder[] = new People[n];

		for (int i = 0; i < n; i++) {
			int infront = persons[i].infront;
			int count = 0, j = 0;
			while (count <= infront) {
				if (tempOrder[j] == null)
					count++;
				j++;
			}
			tempOrder[j - 1] = persons[i];
		}

		for (People people : tempOrder)
			orderOfHeight.add(people.height);

		return orderOfHeight;
	}
}

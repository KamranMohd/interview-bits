package com.ibits.heapsandmaps;

/*
 * https://www.geeksforgeeks.org/merge-k-sorted-arrays-set-2-different-sized-arrays/
 * https://www.geeksforgeeks.org/merge-k-sorted-arrays/
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class HeapNode {
	int data;
	int listIndex;
	int nextEleIndex;

	public HeapNode(int data, int listIndex, int nextEleIndex) {
		this.data = data;
		this.listIndex = listIndex;
		this.nextEleIndex = nextEleIndex;
	}
}

public class MergeKSortedList {

	public static void main(String[] args) {
		int k = 3, n = 4;
		//int arr[][] = { { 1, 3, 5, 7 }, { 2, 4, 6, 8 }, { 0, 9, 10, 11 } };
		int arr[][] = { { 1, 1, 5 }, { 1, 2, 6, 8 }, { 0, 9, 10, 11 } };

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ArrayList<Integer> l = new ArrayList<>();
			for (int j = 0; j < arr[i].length; j++)
				l.add(arr[i][j]);
			list.add(l);
		}
		
		System.out.println(mergeKSortedList(list, k, n).toString());
	}

	public static ArrayList<Integer> mergeKSortedList(ArrayList<ArrayList<Integer>> list, int k, int n) {
		ArrayList<Integer> mergedList = new ArrayList<>();

		Comparator<HeapNode> heapNodeComparator = new Comparator<HeapNode>() {
			@Override
			public int compare(HeapNode n1, HeapNode n2) {
				return n1.data - n2.data;
			}
		};

		PriorityQueue<HeapNode> minHeap = new PriorityQueue<>(heapNodeComparator);

		for (int i = 0; i < k; i++) {
			minHeap.add(new HeapNode(list.get(i).get(0), i, 1));
		}

		while(!minHeap.isEmpty()) {
			HeapNode poll = minHeap.poll();
			mergedList.add(poll.data);
			//System.out.print(poll.data +  " ");
			if(poll.nextEleIndex < list.get(poll.listIndex).size())
				minHeap.add(new HeapNode(list.get(poll.listIndex).get(poll.nextEleIndex), poll.listIndex, poll.nextEleIndex+1));
		}
		return mergedList;
	}

}

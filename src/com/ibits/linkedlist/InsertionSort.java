package com.ibits.linkedlist;

/*
 * https://www.geeksforgeeks.org/insertion-sort-for-singly-linked-list/
 */
public class InsertionSort {

	static ListNode sorted;

	public static void main(String[] args) {
		LinkedList list = new LinkedList(null);
		list.insertNodeAtEnd(30);
		list.insertNodeAtEnd(3);
		list.insertNodeAtEnd(4);
		list.insertNodeAtEnd(20);
		list.insertNodeAtEnd(5);
		System.out.print("linked list before sorting : ");
		list.printLL(list.head);
		doInsertionSort(list.head);
		System.out.print("linked list after sorting : ");
		list.printLL(sorted);
	}
	
	public static void doInsertionSort(ListNode head) {
		ListNode current = head;
		while (current != null) {
			ListNode next = current.next;
			insertInSortedList(current);
			current = next;
		}
	}

	private static void insertInSortedList(ListNode newNode) {
		ListNode current = sorted;
		if(current==null || newNode.data <= current.data){
			newNode.next = sorted;
			sorted = newNode;
		}else{
			ListNode prev = null;
			while(current!=null && current.data < newNode.data){
				prev = current;
				current = current.next;
			}
			prev.next = newNode;
			newNode.next = current;
		}
	}
}

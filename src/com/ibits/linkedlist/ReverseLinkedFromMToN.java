package com.ibits.linkedlist;

/*
 * https://www.interviewbit.com/problems/reverse-link-list-ii/
 * Reverse the linked list from m to n
 */
public class ReverseLinkedFromMToN {
	public static void main(String[] args) {
		LinkedList list = new LinkedList(null);
		list.insertNodeAtEnd(1);
		list.insertNodeAtEnd(2);
		list.insertNodeAtEnd(3);
		list.insertNodeAtEnd(4);
		list.insertNodeAtEnd(5);
		int m = 3, n = 5;
		list.printLL(list.head);
		list.head = reverseFromMtoN(list.head, m, n);
		list.printLL(list.head);
	}

	public static ListNode reverseFromMtoN(ListNode head, int m, int n) {
		ListNode prev = null, current = head;
		int count = 1;
		while (count < m) {
			prev = current;
			current = current.next;
			count++;
		}
		ListNode next = current.next, mhead = current;
		while (current != null && count < n) {
			ListNode nextOfNext = next.next;
			next.next = current;
			current = next;
			next = nextOfNext;
			count++;
		}
		//	If previous is null, then it means the head of the  list is to 
		//	be changed else not
		if(prev!=null) 
			prev.next = current;
		
		else
			head = current;
		mhead.next = next;	
		return head;
	}
}

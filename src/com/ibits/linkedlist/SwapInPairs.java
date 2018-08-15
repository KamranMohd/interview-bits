package com.ibits.linkedlist;

/*
 * https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list-by-changing-links/
 */
public class SwapInPairs {
	public static void main(String[] args) {
		LinkedList list = new LinkedList(null);
		list.insertNodeAtEnd(1);
		list.insertNodeAtEnd(2);
		list.insertNodeAtEnd(3);
		list.insertNodeAtEnd(4);
		list.insertNodeAtEnd(5);
		list.insertNodeAtEnd(6);
		list.printLL(list.head);
		list.printLL(reverseInPairs(list.head));
	}
	
	public static ListNode reverseInPairs(ListNode head) {
		ListNode prev = head;
		if(prev == null)
			return prev;
		ListNode current = prev.next;
		if(current==null)
			return prev;
		ListNode newHead = current;
		while(current.next!=null && current.next.next!=null) {
			ListNode next = current.next;
			current.next = prev;
			prev.next = next.next;
			prev = next;
			current = next.next;
		}
		if(current.next==null) {
			prev.next = current.next;
			current.next = prev;
		}
		else if(current.next.next==null) {
			ListNode next = current.next;
			prev.next = next;
			current.next = prev;
		}
		return newHead;
	}
}

package com.ibits.linkedlist;

public class LinkedList {
	ListNode head;
	
	public LinkedList(ListNode head) {
		this.head = head;
	}

	public void insertNodeAtEnd(int data){
		ListNode toInsert = new ListNode(data, null);
		ListNode current = head, prev = null;
		if(current==null)
			head = toInsert;
		else{
			while(current!=null){
				prev = current;
				current = current.next;
			}
			prev.next = toInsert;
		}	
	}
	
	public void printLL(ListNode head){
		ListNode current = head;
		while(current!=null){
			System.out.print(current.data + (current.next==null?"":" -> "));
			current = current.next;
		}
		System.out.println();
	}
}

package com.ibits.linkedlist;

/*
 * https://www.interviewbit.com/problems/add-two-numbers-as-lists/
 */

public class AddTwoNumbersAsList {

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList(null);
		list1.insertNodeAtEnd(0);
		/*list1.insertNodeAtEnd(9);
		list1.insertNodeAtEnd(8);
		list1.insertNodeAtEnd(6);
		list1.insertNodeAtEnd(9);*/
		//list1.printLL(list1.head);
		
		LinkedList list2 = new LinkedList(null);
		list2.insertNodeAtEnd(1);
		list2.insertNodeAtEnd(0);
		list2.insertNodeAtEnd(1);
		/*list2.insertNodeAtEnd(4);
		list2.insertNodeAtEnd(3);
		list2.insertNodeAtEnd(4);*/
		//list2.printLL(list2.head);
		
		System.out.print("Sum : ");
		LinkedList result = new LinkedList(null);
		result.printLL(getSumAsList(list1.head, list2.head));

	}
	
	public static ListNode getSumAsList(ListNode head1, ListNode head2) {
		ListNode current1 = head1, current2 = head2;
		ListNode sumHead = null, sumNode = null;
		int carry = 0;
		while(current1!=null && current2!=null) {
			int sum = current1.data + current2.data + carry;
			ListNode currentSum = new ListNode(sum % 10, null);
			if(sumHead==null) {
				sumHead = currentSum;
				sumNode = currentSum;
			}
			else {
				sumNode.next = currentSum;
				sumNode = sumNode.next;
			}
			
			carry = sum/10;		
			current1 = current1.next;
			current2 = current2.next;
		}
		
		while(current1!=null) {
			int sum = current1.data + carry;
			ListNode currentSum = new ListNode(sum % 10, null);
			if(sumHead==null) {
				sumHead = currentSum;
				sumNode = currentSum;
			}
			else {
				sumNode.next = currentSum;
				sumNode = sumNode.next;
			}
			carry = sum/10;
			current1 = current1.next;
		}
		
		while(current2!=null) {
			int sum = current2.data + carry;
			ListNode currentSum = new ListNode(sum % 10, null);
			if(sumHead==null) {
				sumHead = currentSum;
				sumNode = currentSum;
			}
			else {
				sumNode.next = currentSum;
				sumNode = sumNode.next;
			}
			carry = sum/10;
			current2 = current2.next;
		}
		if(carry!=0) {
			ListNode currentSum = new ListNode(carry, null);
			sumNode.next = currentSum;
			sumNode.next.next = null;
		}
		else
			sumNode.next = null;
				
		return sumHead;
	}
}
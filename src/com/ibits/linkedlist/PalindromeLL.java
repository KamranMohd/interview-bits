package com.ibits.linkedlist;

/*
 * https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
 */
public class PalindromeLL {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(null);
		list.insertNodeAtEnd(1);
		list.insertNodeAtEnd(2);
		/*list.insertNodeAtEnd(3);
		list.insertNodeAtEnd(3);
		list.insertNodeAtEnd(2);
		list.insertNodeAtEnd(1);*/
		//list.printLL(list.head);
		System.out.println(isPalindrome(list.head));
		//list.printLL(list.head);
	}

	public static int isPalindrome(ListNode head) {
		// Get the middle and divide the list into 2 halves
		if(head.next==null)
			return 1;
		ListNode head1 = head;
		ListNode middle = getMiddleNode(head);
		ListNode head2 = middle.next;
		middle.next = null;

		// Reverse the second half
		head2 = reverseLinkedList(head2);

		// Compare both the halves
		ListNode current1 = head1, current2 = head2;
		int isPalindrome = 1;
		while (current2 != null) {
			if (current1.data != current2.data) {
				isPalindrome = 0;
				break;
			}
			current1 = current1.next;
			current2 = current2.next;
		}

		// Reverse the second half, if the original linked list is needed
		middle.next = reverseLinkedList(head2);
		return isPalindrome;
	}

	private static ListNode reverseLinkedList(ListNode head) {
		ListNode current = head, prev = null, next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	private static ListNode getMiddleNode(ListNode head) {
		ListNode slow = head, fast = head, prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast == null)
			return prev;
		else
			return slow;
	}

}

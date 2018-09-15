package com.ibits.tree;

/*
 * https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
 * https://www.interviewbit.com/problems/kth-smallest-element-in-tree/
 */
public class KthSmallestElementInBST {

	private static int count = 0;

	public static void main(String[] args) {
		TreeNode node = new TreeNode(20);
		node.left = new TreeNode(8);
		node.right = new TreeNode(22);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(12);
		node.left.right.left = new TreeNode(10);
		node.left.right.left.right = new TreeNode(14);
		int k = 3;
		System.out.println("Kth smallest element : " + kSmallestElement(node, k));
	}

	public static int kSmallestElement(TreeNode node, int k) {
		if (node == null)
			return -1;
		
		//	In BST, smaller elements lie in the left subtree, therefore, 
		//	we completely traverse the left subtree before processing the 
		//	right subtree
		int left = kSmallestElement(node.left, k);
		System.out.println("Left : " + left + " node value : " + node.val + " count : " + count);
		
		//	If the required value is present in left subtree
		//	then return else check the root and right subtree
		if (left != -1)
			return left;
		count++;
		
		//	If the kth element is found, then return it's value
		if (count == k)
			return node.val;
		
		//	Search in the right subtree
		return kSmallestElement(node.right, k);
	}

	public static void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

}

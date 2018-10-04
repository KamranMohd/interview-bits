package com.ibits.tree;

/*
 * https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
 */
public class FixSwappedNodesOfBST {
	static TreeNode first, middle, last, prev;

	public static void main(String[] args) {
		/*TreeNode node = new TreeNode(10);
		node.left = new TreeNode(5);
		node.right = new TreeNode(8);
		node.left.left = new TreeNode(2);
		node.left.right = new TreeNode(20);*/
		TreeNode node = new TreeNode(6);
		node.left = new TreeNode(10);
		node.right = new TreeNode(2);
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(3);
		node.right.right = new TreeNode(12);
		node.right.left = new TreeNode(7);
		System.out.print("Inorder traversal before BST fix : ");
		inOrder(node);
		fixBST(node);
		System.out.print("\nInorder traversal after BST fix : ");
		inOrder(node);
	}

	public static void fixBST(TreeNode root) {
		// Initialize the global variables
		first = middle = last = prev = null;

		// We will do the inorder traversal of the tree
		correctBSTUtil(root);
		
		// Case 1: Where there are 2 instances
		// when the node is smaller than the previous node
		if (first != null && last != null) {
			int temp = first.val;
			first.val = last.val;
			last.val = temp;
		}
		
		// Case 2: Where there is only 1 instance
		// when the node is smaller than the previous node
		else if (first != null && middle != null) {
			int temp = first.val;
			first.val = middle.val;
			middle.val = temp;
		}

		// Else, the tree is already a BST
	}

	private static void correctBSTUtil(TreeNode node) {
		if(node==null)
			return;
		correctBSTUtil(node.left);
		
		//	If the node value is smaller than the previous
		//	then it is violating the BST rule
		if(prev!=null && node.val < prev.val) {
			//	It is the first violation of the rule
			if(first==null) {
				first = prev;
				middle = node;
			}
			//	Second violation of the rule
			else
				last = node;
		}
		
		prev = node;
		correctBSTUtil(node.right);
	}

	public static void inOrder(TreeNode node) {
		if (node == null)
			return;
		inOrder(node.left);
		System.out.print(node.val + " ");
		inOrder(node.right);
	}

}

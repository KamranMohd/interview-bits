package com.ibits.tree;

/*
 * https://www.geeksforgeeks.org/flatten-a-binary-tree-into-linked-list/
 * https://www.programcreek.com/2013/01/leetcode-flatten-binary-tree-to-linked-list/
 */
import java.util.Stack;

public class FlatternBinaryTree {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(5);
		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(4);
		node.right.right = new TreeNode(6);
		System.out.print("Inorder traversal before flattening : ");
		inOrder(node);
		flattenTree2(node);
		System.out.print("\nInorder traversal after flattening : ");
		inOrder(node);
	}

	/*
	 * Not an optimized solution
	 */
	public static void flattenTree(TreeNode node) {
		// Base condition: If the node is null or leaf node
		if (node == null || (node.left == null && node.right == null))
			return;

		// Recursively check for the left subtree
		if (node.left != null) {
			flattenTree(node.left);
			TreeNode temp = node.right;
			node.right = node.left;
			node.left = null;

			TreeNode t = node.right;
			while (t.right != null)
				t = t.right;
			t.right = temp;
		}

		flattenTree(node.right);
	}

	/*
	 * This method is the optimized solution
	 */
	public static void flattenTree2(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = node;

		while (p != null) {

			if (p.right != null) {
				stack.push(p.right);
			}

			if (p.left != null) {
				p.right = p.left;
				p.left = null;
			} else if (!stack.empty()) {
				p.right = stack.pop();
			}

			p = p.right;
		}
	}

	public static void inOrder(TreeNode node) {
		if (node == null)
			return;
		inOrder(node.left);
		System.out.print(node.val + " ");
		inOrder(node.right);
	}

}

package com.ibits.tree;

/*
 * https://www.interviewbit.com/problems/invert-the-binary-tree/
 * https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
 */
public class MirrorTree {

	public static void main(String[] args) {
		/*TreeNode node = new TreeNode(1);
		node.left = new TreeNode(3);
		node.right = new TreeNode(2);
		node.right.left = new TreeNode(5);
		node.right.right = new TreeNode(4);*/
		TreeNode node = new TreeNode(20);
		node.left = new TreeNode(8);
		node.right = new TreeNode(22);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(12);
		node.left.right.left = new TreeNode(10);
		node.left.right.right = new TreeNode(14);
		preOrder(node);
		TreeNode mirrorRoot = mirrorTreeMethod2(node);
		System.out.println();
		preOrder(mirrorRoot);
	}
	
	public static TreeNode mirrorTreeMethod2(TreeNode node) {
		if(node==null)
			return node;
		TreeNode left = mirrorTree(node.left);
		TreeNode right = mirrorTree(node.right);
		node.left = right;
		node.right = left;
		return node;
		
	}
	
	public static TreeNode mirrorTree(TreeNode node) {
		if(node==null)
			return node;
		TreeNode left = node.left;
		node.left = mirrorTree(node.right);
		node.right = mirrorTree(left);
		return node;
		
	}

	public static void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
}

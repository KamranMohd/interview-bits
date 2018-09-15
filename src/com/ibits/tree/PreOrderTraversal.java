package com.ibits.tree;

public class PreOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		preOrder(root);
	}
	
	public static void preOrder(TreeNode root) {
		if(root==null)
			return ;
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

}

package com.ibits.tree;

/*
 * https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 */
class Height {
	int height;

	public Height() {
		this.height = 0;
	}
}

public class BalancedTree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.right = new TreeNode(6);
		node.left.left.left = new TreeNode(7);

		/*
		 * TreeNode node = new TreeNode(1); node.left = new TreeNode(2); node.right =
		 * new TreeNode(3); node.left.left = new TreeNode(4); node.left.right = new
		 * TreeNode(5); node.left.left.left = new TreeNode(8);
		 */
		System.out.println("Is tree balanced using optimized code : " + isBalancedOpt(node, new Height()));
		System.out.println("Is tree balanced : " + isBalanced(node));
	}

	private static boolean isBalancedOpt(TreeNode node, Height height) {
		if (node == null) {
			height.height = 0;
			return true;
		}

		Height lheight = new Height(), rheight = new Height();
		boolean lBalanced = isBalancedOpt(node.left, lheight);
		boolean rBalanced = isBalancedOpt(node.right, rheight);
		int lh = lheight.height, rh = rheight.height;

		height.height = Math.max(lh, rh) + 1;

		return Math.abs(lh - rh) <= 1 && lBalanced && rBalanced;
	}

	/*
	 * Method 1 : It is not optimized. Time complexity : O(n^2)
	 */
	public static boolean isBalanced(TreeNode node) {
		if (node == null)
			return true;
		int lh = height(node.left);
		int rh = height(node.right);

		return (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right));
	}

	private static int height(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}
}

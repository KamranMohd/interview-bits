package com.ibits.tree;

/*
 * https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
 */
public class ConstructFromPostAndIn {
	static int postIndex;

	public static void main(String[] args) {
		int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
		int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };
		int n = in.length;
		postIndex = n - 1;
		TreeNode root = buildTree(in, post, 0, postIndex);
		preOrderTraversal(root);

	}

	private static TreeNode buildTree(int[] in, int[] post, int start, int end) {
		if (start > end)
			return null;

		// Create a node from the last element in
		// post order traversal
		TreeNode node = new TreeNode(post[postIndex--]);

		// If the node has no child, then return the node
		if (start == end)
			return node;

		int inOrderIndex = search(in, start, end, node.val);

		node.right = buildTree(in, post, inOrderIndex + 1, end);
		node.left = buildTree(in, post, start, inOrderIndex - 1);

		return node;
	}

	private static int search(int[] in, int start, int end, int val) {
		for (int i = start; i <= end; i++) {
			if (in[i] == val)
				return i;
		}
		return -1;
	}

	private static void preOrderTraversal(TreeNode root) {
		if(root==null)
			return;
		System.out.print(root.val +  " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

}

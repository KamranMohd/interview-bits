package com.ibits.tree;

/*
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 */
public class LCA {

	// Global variables to store whether the nodes exist
	// in the tree or not
	public static boolean v1 = false;
	public static boolean v2 = false;

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		System.out.println(findLCA(node, 4, 5).val);
		System.out.println(findLCA(node, 4, 6).val);
		System.out.println(findLCA(node, 3, 4).val);
		System.out.println(findLCA(node, 2, 4).val);

		System.out.println(findLCAOpt(node, 4, 5).val);
		System.out.println(findLCAOpt(node, 4, 10) == null ? "Keys not present" : findLCAOpt(node, 4, 10).val);
	}

	/*
	 * This method assumes that both the nodes are present in the binary tree
	 */
	public static TreeNode findLCA(TreeNode node, int node1, int node2) {
		if (node == null)
			return null;

		// If the current node value matches with any of the node (node1 || node2)
		// return the current node
		if (node.val == node1 || node.val == node2)
			return node;

		// Else recur for left and right subtree
		TreeNode leftLCA = findLCA(node.left, node1, node2);
		TreeNode rightLCA = findLCA(node.right, node1, node2);

		// If both the values are not null, that means
		// that the nodes lie on either side of the LCA
		if (leftLCA != null && rightLCA != null)
			return node;

		// Else if one of them is null, return the other one
		// This implies that both the nodes lie on one side
		// of LCA
		return leftLCA == null ? rightLCA : leftLCA;

	}

	public static TreeNode findLCAOpt(TreeNode node, int n1, int n2) {
		v1 = false;
		v2 = false;
		if (node == null)
			return node;
		TreeNode lca = findLCAUtil(node, n1, n2);

		if (v1 && v2 || v1 & findPath(lca, n2) || v2 && findPath(lca, n1))
			return lca;

		return null;
	}

	public static TreeNode findLCAUtil(TreeNode node, int n1, int n2) {
		if (node == null)
			return node;

		if (node.val == n1) {
			v1 = true;
			return node;
		}

		if (node.val == n2) {
			v2 = true;
			return node;
		}

		// Else recur for left and right subtree
		TreeNode leftLCA = findLCAUtil(node.left, n1, n2);
		TreeNode rightLCA = findLCAUtil(node.right, n1, n2);

		// If both the values are not null, that means
		// that the nodes lie on either side of the LCA
		if (leftLCA != null && rightLCA != null)
			return node;

		// Else if one of them is null, return the other one
		// This implies that both the nodes lie on one side
		// of LCA
		return leftLCA == null ? rightLCA : leftLCA;
	}

	private static boolean findPath(TreeNode lca, int node) {
		if (lca == null)
			return false;
		if (lca.val == node || findPath(lca.left, node) || findPath(lca.right, node))
			return true;
		return false;
	}

}

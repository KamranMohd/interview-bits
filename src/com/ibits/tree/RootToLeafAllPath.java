package com.ibits.tree;

/*
 * https://www.interviewbit.com/problems/root-to-leaf-paths-with-sum/
 * reference : https://www.geeksforgeeks.org/print-paths-root-specified-sum-binary-tree/
 */

import java.util.ArrayList;

public class RootToLeafAllPath {

	static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) {
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(4);
		node.right = new TreeNode(8);
		node.left.left = new TreeNode(11);
		node.left.left.left = new TreeNode(7);
		node.left.left.right = new TreeNode(2);
		node.right.left = new TreeNode(13);
		node.right.right = new TreeNode(4);
		node.right.right.left = new TreeNode(5);
		node.right.right.right = new TreeNode(1);
		int sum = 22;
		getPaths(node, sum);
		System.out.println(result);
	}

	public static void getPaths(TreeNode node, int sum) {
		ArrayList<Integer> path = new ArrayList<>();
		getPathsUtil(node, sum, 0, path);
	}

	private static void getPathsUtil(TreeNode node, int sum, int currentSum, ArrayList<Integer> path) {
		if (node == null)
			return;
		currentSum += node.val;
		path.add(node.val);
		if (currentSum == sum && node.left == null && node.right == null)
			result.add(new ArrayList<>(path));
		if (node.left != null)
			getPathsUtil(node.left, sum, currentSum, path);
		if (node.right != null)
			getPathsUtil(node.right, sum, currentSum, path);
		path.remove(path.size() - 1);
	}

	public static void inOrder(TreeNode node) {
		if (node == null)
			return;
		inOrder(node.left);
		System.out.print(node.val + " ");
		inOrder(node.right);
	}

}

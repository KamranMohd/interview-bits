package com.ibits.tree;

/*
 * https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
 */
public class ContructFromPreAndIn {
	static int preIndex = 0;
	public static void main(String[] args) {
		int [] inOrder = {2,5,6,10,12,14,15};
		int [] preOrder = {10,5,2,6,14,12,15};
		int n = inOrder.length;
		TreeNode root = buildTree(inOrder, preOrder, 0, n-1);
		inOrder(root);
	}

	private static TreeNode buildTree(int[] inOrder, int[] preOrder, int start, int end) {
		if(start > end)
			return null;
		
		//	Pick the first element from the preOrder and create
		//	a node
		TreeNode node = new TreeNode(preOrder[preIndex++]);
		
		//	If the node has no children
		if(start == end)
			return node;
		
		//	Search for this node in the 
		//	inOrder array and find the index
		int inOrderIndex = search(inOrder, start, end, node.val);
		
		//	Recursively create left subtree and right subtree
		node.left = buildTree(inOrder, preOrder, start, inOrderIndex-1);
		node.right = buildTree(inOrder, preOrder, inOrderIndex + 1, end);
		
		return node;
		
	}

	private static int search(int[] inOrder, int start, int end, int val) {
		for(int i=start; i<= end; i++) {
			if(inOrder[i]==val)
				return i;
		}
		return -1;
	}

	public static void inOrder(TreeNode root) {
		if(root==null)
			return ;
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}
}

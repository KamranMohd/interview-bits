package com.ibits.tree;

import java.util.ArrayList;
import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/zigzag-tree-traversal/
 */
public class ZigZagTraversal {
	static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(7);
		node.left.right = new TreeNode(6);
		node.right.left = new TreeNode(5);
		node.right.right = new TreeNode(4);
		System.out.print("Inorder traversal : ");
		inOrder(node);
		System.out.print("\nZigzag traversal : ");
		zigZagTraversal(node);
		System.out.println(zigzagLevelOrder(node).toString());
	}
	
	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        if(A==null)
            return result;
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        s1.push(A);
        
        while(!s1.isEmpty() || !s2.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            while(!s1.isEmpty()){
                TreeNode pop = s1.pop();
                level.add(pop.val);
                if(pop.left!=null)
                    s2.push(pop.left);
                if(pop.right!=null)
                    s2.push(pop.right);
            }
            System.out.println(level);
            if(level.size()>0)
            	result.add(new ArrayList<Integer>(level));
            level.clear();
            while(!s2.isEmpty()){
                TreeNode pop = s2.pop();
                level.add(pop.val);
                if(pop.right!=null)
                    s1.push(pop.right);
                if(pop.left!=null)
                    s1.push(pop.left);
            }
            System.out.println(level);
            if(level.size()>0)
            	result.add(new ArrayList<Integer>(level));
        }
        return result;
    }
	
	public static void zigZagTraversal(TreeNode node) {
		if(node==null)
			return;
		
		//	Create 2 stacks for alternate levels
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		
		s1.push(node);
		
		//	Loop until one of them is non empty
		while(!s1.isEmpty() || !s2.isEmpty()) {
			//	Print the nodes from the first stack
			while(!s1.isEmpty()) {
				TreeNode pop = s1.pop();
				System.out.print(pop.val + " ");
				
				//	Push the child of pop in stack 2
				if(pop.left!=null)
					s2.push(pop.left);
				if(pop.right!=null)
					s2.push(pop.right);
			}
			
			//	Print the nodes from the second stack
			while(!s2.isEmpty()) {
				TreeNode pop = s2.pop();
				System.out.print(pop.val + " ");
				
				//	Push the child of pop in stack 2
				if(pop.right!=null)
					s1.push(pop.right);
				if(pop.left!=null)
					s1.push(pop.left);
			}
		}
		System.out.println();
	}
	
	public static void inOrder(TreeNode node) {
		if(node==null)
			return;
		inOrder(node.left);
		System.out.print(node.val + " ");
		inOrder(node.right);
	}
}

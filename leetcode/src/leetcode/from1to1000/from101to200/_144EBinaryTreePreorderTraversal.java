package leetcode.from1to1000.from101to200;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class _144EBinaryTreePreorderTraversal {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = null;
		TreeNode right = new TreeNode(2);
		root.right = right;
		right.left = new TreeNode(3);
		right.right = null;
		
		List<Integer> list = preorderTraversal2(root);
		for(int i = 0; i < list.size(); ++ i) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
	
	public static List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		
		TreeNode[] nodes = new TreeNode[100];
		
		int i = 0;
		nodes[0] = root;
		int tmp = 1;
		while(nodes[i] != null) {
//			System.out.println(i + " " + nodes[i].val + " " + nodes[i].left + " " + nodes[i].right);
			if(nodes[i].left != null) {
				nodes[tmp] = nodes[i].left;
				nodes[i].left = null;
				tmp ++;
			} else {
			}
			if(nodes[i].right != null) {
				nodes[tmp] = nodes[i].right;
				tmp ++;
			}
			i ++;
		}
		
		return result;
	}
	
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root != null) {
			preorder(root, result);
		}
		return result;
	}
	
	public void preorder(TreeNode node, List<Integer> result) {
		result.add(node.val);
		if(node.left != null) {
			preorder(node.left, result);
		}
		if(node.right != null) {
			preorder(node.right, result);
		}
	}
}

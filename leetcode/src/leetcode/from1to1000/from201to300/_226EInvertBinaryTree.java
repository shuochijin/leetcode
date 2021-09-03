package leetcode.from1to1000.from201to300;

import java.util.LinkedList;

import util.TreeNode;

public class _226EInvertBinaryTree {
	
	public TreeNode invertTree(TreeNode root) {
		
		if(root == null) {
			return null;
		}
		
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);
		
		TreeNode tmp, tmp2;
		while(list.size() > 0) {
			tmp = list.remove(0);
			if(tmp.left != null) {
				list.add(tmp.left);
			}
			if(tmp.right != null) {
				list.add(tmp.right);
			}
			tmp2 = tmp.left;
			tmp.left = tmp.right;
			tmp.right = tmp2;
		}
		
		return root;
	}
}

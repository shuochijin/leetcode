package leetcode.from1to1000.from101to200;

import java.util.LinkedList;

import util.TreeNode;

public class _111EMinimumDepthofBinaryTree {
	
	public static void main(String[] args) {
		
	}
	
	public static int minDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		if(root.left == null && root.right == null) {
			return 1;
		}
		
		int depth = 1;
		
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		
		q.add(root);
		
		TreeNode tmpNode;
		int tmp = 1;
		while(q.size() > 0) {
			tmpNode = q.remove(0);
			
			if(tmpNode.left == null && tmpNode.right == null) {
				break;
			}
			
			if(tmpNode.left != null) {
				q.add(tmpNode.left);
			}
			if(tmpNode.right != null) {
				q.add(tmpNode.right);
			}
			
			tmp --;
			if(tmp == 0) {
				depth ++;
				tmp = q.size();
			}
		}
		
		return depth;
	}
}

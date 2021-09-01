package leetcode.from1to1000.from101to200;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class _145EBinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root != null) {
			postorder(root, result);
		}
		return result;
	}
	
	public void postorder(TreeNode node, List<Integer> result) {
		if(node.left != null) {
			postorder(node.left, result);
		}
		if(node.right != null) {
			postorder(node.right, result);
		}
		result.add(node.val);
	}
}

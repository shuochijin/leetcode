package leetcode.from101to200;

import util.BuildTree;
import util.TreeNode;

public class _104EMaximumDepthofBinaryTree {
	
	public static void main(String[] args) {
		Integer[] list = new Integer[] {3,9,20,null,null,15,7};
		TreeNode root = BuildTree.generator(list);
		
		_104EMaximumDepthofBinaryTree n = new _104EMaximumDepthofBinaryTree();
		System.out.println(n.maxDepth(root));
	}
	
	static int depth = 0;
	static int temp = 0;
	public int maxDepth(TreeNode root) {
		depth = 0;
		temp = 0;
		return recursion(root);
	}
	
	public int recursion(TreeNode root) {
		if(root == null) {
			return 0;
		}
		temp ++;
		if(temp > depth) {
			depth = temp;
		}
		if(root.left != null) {
			recursion(root.left);
			temp --;
		}
		if(root.right != null) {
			recursion(root.right);
			temp --;
		}
		return depth;
	}
}

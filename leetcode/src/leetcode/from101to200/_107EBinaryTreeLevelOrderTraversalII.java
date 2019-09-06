package leetcode.from101to200;

import java.util.ArrayList;
import java.util.List;

import util.BuildTree;
import util.TreeNode;

public class _107EBinaryTreeLevelOrderTraversalII {
	
	public static void main(String[] args) {
		Integer[] list = new Integer[] {3,9,20,null,null,15,7};
		TreeNode root = BuildTree.generator(list);
		_107EBinaryTreeLevelOrderTraversalII n = new _107EBinaryTreeLevelOrderTraversalII();
		System.out.println(n.levelOrderBottom(root).toString());
	}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(root == null) {
			return list;
		}
		List<TreeNode> level = new ArrayList<TreeNode>();
		List<Integer> e;
		level.add(root);
		int size = 1;
		while(level.size() != 0) {
			size = level.size();
			e = new ArrayList<Integer>();
			for(int i = 0; i < size; ++ i) {
				e.add(level.get(i).val);
				if(level.get(i).left != null) {
					level.add(level.get(i).left);
				}
				if(level.get(i).right != null) {
					level.add(level.get(i).right);
				}
			}
			list.add(0, e);
			while(size > 0) {
				level.remove(0);
				size --;
			}
		}
		
		return list;
	}
}

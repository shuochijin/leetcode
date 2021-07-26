package leetcode.from1to1000.from101to200;

import java.util.Stack;

import util.TreeNode;

public class _108EConvertSortedArraytoBinarySearchTree {
	
	public static void main(String[] args) {
		
		int i = 0;
		
		while(i < 100) {
			i = i << 1;
			System.out.println(i);
		}
		
//		_108EConvertSortedArraytoBinarySearchTree n = new _108EConvertSortedArraytoBinarySearchTree();
//		n.sortedArrayToBST(new int[] {});
	}
	
	public TreeNode sortedArrayToBST(int[] list) {
		TreeNode root = new TreeNode(list[list.length / 2], null, null);
		Stack stack = new Stack<Integer>();
		stack.push(list.length / 2);
		while(stack.size() > 0) {
			
		}
		return root;
	}
}

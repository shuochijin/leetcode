package leetcode.from1to1000.from101to200;

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
		TreeNode root = null;
		int i = list.length;
		int count = 1;
		i = i >> 1;
		while(i > 0) {
			i = i >> 1;
			count =  count << 1;
		}
		if(count < list.length) {
			count = count << 1;
		}
		
		Integer[] is = new Integer[count];
		return root;
	}
}

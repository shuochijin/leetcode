package leetcode.from1to1000.from101to200;

import java.util.LinkedList;

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
	public TreeNode sortedArrayToBST2(int[] nums) {
		TreeNode root = new TreeNode();
		return root;
	}
	
	public void createNode(int[] nums, int left, int right) {
		
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<Integer> index = new LinkedList<Integer>();
		
		int tmp = nums.length / 2;
		TreeNode root = new TreeNode(nums[tmp], null, null);
		left[tmp] = 0;
		right[tmp] = nums.length - 1;
		
		queue.add(root);
		index.add(tmp);
		
		TreeNode tmpRoot;
		TreeNode tmpNode;
		int tmpIndex;
		while(queue.size() > 0) {
			tmpRoot = queue.remove(0);
			tmp = index.remove(0);
			if(left[tmp] < tmp) {
				tmpIndex = (left[tmp] + tmp) / 2;
				left[tmpIndex] = left[tmp];
				right[tmpIndex] = tmp - 1;
				tmpNode = new TreeNode(nums[tmpIndex], null, null);
				
				queue.add(tmpNode);
				index.add(tmpIndex);
				
				tmpRoot.left = tmpNode;
			}
			if(tmp < right[tmp]) {
				tmpIndex = (tmp + right[tmp]) / 2 + 1;
				left[tmpIndex] = tmp + 1;
				right[tmpIndex] = right[tmp];
				tmpNode = new TreeNode(nums[tmpIndex], null, null);
				
				queue.add(tmpNode);
				index.add(tmpIndex);
				
				tmpRoot.right = tmpNode;
			}
		}
		
		return root;
	}
}

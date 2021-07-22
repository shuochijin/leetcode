package leetcode.from1to1000.from101to200;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class _101ESymmetricTree {
	
	public static void main(String[] args) {
		_101ESymmetricTree n = new _101ESymmetricTree();
		Integer[] list = new Integer[] {
				9,
				14,14,
				74,null,null,74,
				null,12,12,null,	63,null,null,63,
				-8,null,null,-8,	-53,null,null,-53,	null,-96,-96,null,	-65,null,null,-65,
				98,null,null,98,	50,null,null,50,	null,91,91,null,	41,-30,-30,41,		null,86,null,-36,	-36,null,86,null,	-78,null,9,null,	null,9,null,-78,
				
				47,null,48,-79,		-79,48,null,47,		-100,-86,null,47,	null,67,67,null,	47,null,-86,-100,	-28,11,null,56,		null,30,null,64,	64,null,30,null,
				56,null,11,-28,		43,54,null,-50,		44,-58,63,null,		null,-43,-43,null,	null,63,-58,44,		-50,null,54,43};
//		Integer[] list = new Integer[] {1,2,2,null,3,null,3};
//		Integer[] list = new Integer[] {1,2,2,3,null,null,3};
		TreeNode[] treeNodeList = new TreeNode[list.length];
		for(int i = list.length - 1; i >= 0; -- i) {
			if(list[i] != null) {
				treeNodeList[i] = new TreeNode(list[i]);
				if((i * 2 + 1) < list.length) {
					treeNodeList[i].left = treeNodeList[i * 2 + 1];
					treeNodeList[i].right = treeNodeList[i * 2 + 2];
				} else {
					treeNodeList[i].left = null;
					treeNodeList[i].right = null;
				}
			} else {
				treeNodeList[i] = null;
			}
		}
		TreeNode root = treeNodeList[0];
		long start = System.nanoTime();
//		System.out.println(n.isSymmetric(root));
		long end = System.nanoTime();
//		System.out.println(end - start);
		start = System.currentTimeMillis();
		System.out.println(n.isSymmetric2(root));
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public boolean isSymmetric2(TreeNode root) {
		if(root == null || (root.left == null && root.right == null)) {
			return true;
		}
		if(root.left == null || root.right == null) {
			return false;
		}
		Stack<TreeNode> leftNode = new Stack<TreeNode>();
		Stack<TreeNode> rightNode = new Stack<TreeNode>();
		Stack<Integer> directFlag = new Stack<Integer>();
		
		leftNode.push(root.left);
		rightNode.push(root.right);
		directFlag.push(0);
		
		TreeNode leftTemp;
		TreeNode rightTemp;
		int tempDirectFlag = -1;
		while(directFlag.size() > 0) {
			leftTemp = leftNode.peek();
			rightTemp = rightNode.peek();
			if(leftTemp.val != rightTemp.val) {
				return false;
			}
			if(directFlag.peek() == 0) {
				if(leftTemp.left == null && rightTemp.right == null) {
					directFlag.pop();
					directFlag.push(1);
				} else if(leftTemp.left != null && rightTemp.right != null) {
					leftNode.push(leftTemp.left);
					rightNode.push(rightTemp.right);
					directFlag.push(0);
				} else {
					return false;
				}
			} else {
				if(leftTemp.right == null && rightTemp.left == null) {
					while(directFlag.size() > 0 && (tempDirectFlag = directFlag.pop()) == 1) {
						leftNode.pop();
						rightNode.pop();
					}
					if(tempDirectFlag == 0) {
						directFlag.push(1);
					}
				} else if(leftTemp.right != null && rightTemp.left != null){
					leftNode.push(leftTemp.right);
					rightNode.push(rightTemp.left);
					directFlag.push(0);
				} else {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}
		
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		list.add(root);
		
		int size;
		boolean flag = true;
		while(flag) {
			flag = false;
			size = list.size();
			for(int i = 0; i <= size - 1 - i; ++ i) {
				if(list.get(i) == null && list.get(size - 1 - i) == null) {
					continue;
				}
				if(list.get(i) != null && list.get(size - 1 - i) != null) {
					if(list.get(i).val == list.get(size - 1 - i).val) {
						//do nothing
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
			for(int i = 0; i < size; ++ i) {
				if(list.get(0) == null) {
					list.add(null);
					list.add(null);
				} else {
					list.add(list.get(0).left);
					list.add(list.get(0).right);
					flag = true;
				}
				list.remove(0);
			}
		}
		
		return true;
	}
	
}

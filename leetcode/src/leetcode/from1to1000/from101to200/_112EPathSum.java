package leetcode.from1to1000.from101to200;

import java.util.LinkedList;
import java.util.Stack;

import util.TreeNode;

public class _112EPathSum {
	
	public static void main(String[] args) {
		
	}
	/*
		[
			5
			4				8
			11		null	13				4
			7	2			null	null	null	1]
	 */
    public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null) {
			return false;
		}
		
        boolean result = false;
		
		Stack<TreeNode> ns = new Stack<TreeNode>();
		Stack<Integer> lrDone = new Stack<Integer>();
		
		ns.push(root);
		lrDone.push(0);
		
		TreeNode tmpNode;
		int tmpB;
		int tmpSum = 0;
		while(ns.size() > 0) {
			tmpNode = ns.pop();
			tmpB = lrDone.pop();
			
			if(tmpB == 0) {//节点push进来没处理
				tmpSum += tmpNode.val;
				if(tmpNode.left != null) {
					ns.push(tmpNode);
					lrDone.push(-1);
					
					ns.push(tmpNode.left);
					lrDone.push(0);
				} else {
					if(tmpNode.right != null) {
						ns.push(tmpNode);
						lrDone.push(1);
						
						ns.push(tmpNode.right);
						lrDone.push(0);
					} else {
						if(tmpSum == targetSum) {
							return true;
						} else {
							tmpSum -= tmpNode.val;
						}
					}
				}
			} else if(tmpB == -1){
				if(tmpNode.right != null) {
					tmpSum -= tmpNode.val;
					ns.push(tmpNode);
					lrDone.push(1);
					
					ns.push(tmpNode.right);
					lrDone.push(0);
				} else {
					if(tmpSum == targetSum) {
						return true;
					} else {
						tmpSum -= tmpNode.val;
					}
				}
			} else {
				tmpSum -= tmpNode.val;
			}
			System.out.println(tmpSum);
		}
		
        
        
        return result;
    }
}

package leetcode.from1to1000.from101to200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import util.TreeNode;

public class _112EPathSum {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.right = null;
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left.left = null;
		root.right.left.right = null;
		root.right.right.left = null;
		root.right.right.right = new TreeNode(1);
		System.out.println(hasPathSum(root, 22));
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = null;
		System.out.println(hasPathSum(root2, 1));
		System.out.println(hasPathSum2(root, 22));
		System.out.println(hasPathSum2(root2, 1));
		
		
		
		int size = 10;
		int times = 10000000;
		
		TreeNode root3 = new TreeNode(1);
		createTree(root3, size);
		
		long start = System.nanoTime();
		for(int i = 0; i < times; ++ i)
			hasPathSum(root3, 1);
		long cur = System.nanoTime();
		System.out.println(cur - start);
		start = System.nanoTime();
		for(int i = 0; i < times; ++ i)
			hasPathSum2(root3, 1);
		cur = System.nanoTime();
		System.out.println(cur - start);
		start = System.nanoTime();
		for(int i = 0; i < times; ++ i)
			hasPathSum3(root3, 1);
		cur = System.nanoTime();
		System.out.println(cur - start);
		start = System.nanoTime();
		for(int i = 0; i < times; ++ i)
			hasPathSum4(root3, 1);
		cur = System.nanoTime();
		System.out.println(cur - start);
		
	}
	static boolean flag = false;
    public static boolean hasPathSum3(TreeNode root, int targetSum) {
        pathSum( root, targetSum , 0);
        return flag;
    }
    public static void pathSum(TreeNode root , int target , int curr)
    {
        if(root != null)
        {
            curr = curr + root.val;
            if(root.left == null && root.right == null)
            {
                if(curr == target)
                {
                    flag = true;
                }
            }
            pathSum(root.left, target , curr);   
            pathSum(root.right, target , curr);
        }
    }
    public static boolean hasPathSum2(TreeNode root, int targetSum) {
		if(root == null) {
			return false;
		}
		
		LinkedList<TreeNode> rootq = new LinkedList<TreeNode>();
		LinkedList<Integer> sumq = new LinkedList<Integer>();
		
		TreeNode tmpNode;
		int tmpSum;
		
		rootq.add(root);
		sumq.add(root.val);
		
		while(rootq.size() != 0) {
			tmpNode = rootq.remove(0);
			tmpSum = sumq.remove(0);
			
			if(tmpNode.left == null && tmpNode.right == null && tmpSum == targetSum) {
				return true;
			}
			if(tmpNode.left != null) {
				rootq.add(tmpNode.left);
				sumq.add(tmpSum + tmpNode.left.val);
			}
			if(tmpNode.right != null) {
				rootq.add(tmpNode.right);
				sumq.add(tmpSum + tmpNode.right.val);
			}
		}
        
        return false;
    }
    public static boolean hasPathSum4(TreeNode root, int targetSum) {
		if(root == null) {
			return false;
		}
		
		ArrayList<TreeNode> rootq = new ArrayList<TreeNode>(11);
		ArrayList<Integer> sumq = new ArrayList<Integer>(11);
		int head = 0;
		TreeNode tmpNode;
		int tmpSum;
		
		rootq.add(root);
		sumq.add(root.val);
		
		while(head < rootq.size()) {
			tmpNode = rootq.get(head);
			tmpSum = sumq.get(head);
			
			head ++;
			
			if(tmpNode.left == null && tmpNode.right == null && tmpSum == targetSum) {
				return true;
			}
			if(tmpNode.left != null) {
				rootq.add(tmpNode.left);
				sumq.add(tmpSum + tmpNode.left.val);
			}
			if(tmpNode.right != null) {
				rootq.add(tmpNode.right);
				sumq.add(tmpSum + tmpNode.right.val);
			}
		}
        
        return false;
    }
    
    
    
    
    
    
	public static void createTree(TreeNode root, int size) {
		TreeNode tmp = root;
		for(int i = 0; i < size; ++ i) {
			tmp.left = null;
			tmp.right = new TreeNode(1);
			tmp = tmp.right;
		}
	}
	/*
	[
		5
		4				8
		11		null	13				4
		7	2			null	null	null	1]
 */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
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
//					tmpSum -= tmpNode.val;
					ns.push(tmpNode);
					lrDone.push(1);
					
					ns.push(tmpNode.right);
					lrDone.push(0);
				} else {
					if(tmpNode == null && tmpSum == targetSum) {
						return true;
					} else {
						tmpSum -= tmpNode.val;
					}
				}
			} else {
				tmpSum -= tmpNode.val;
			}
		}
		
        
        
        return result;
    }
}

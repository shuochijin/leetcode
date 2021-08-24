package leetcode.from1to1000.from101to200;

import java.util.Stack;

import util.TreeNode;

public class _110EBalancedBinaryTree {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		root = null;
		System.out.println(isBalanced(root));
	}
	
	public static boolean isBalanced(TreeNode root) {
		isBalanced2(root);
		return isBalanced;
	}
	
	public static boolean isBalanced = true;
	public static int isBalanced2(TreeNode root) {
		if(!isBalanced) {
			return 0;
		}
		if(root == null) {
			return 0;
		}
		int l,r;
		l = isBalanced2(root.left);
		r = isBalanced2(root.right);
		if(Math.abs(l - r) > 1) {
			isBalanced = false;
			return 0;
		} else {
			return Math.max(l, r) + 1;
		}
	}
	
	public static boolean isBalanced3(TreeNode root) {
		boolean result = true;
		Stack<TreeNode> ns = new Stack<TreeNode>();
		Stack<Integer> hs = new Stack<Integer>();
		
		TreeNode tmp;
		int tmph;
		
		ns.push(root);
		
		while(ns.size() > 0) {
			tmp = ns.pop();
			if(tmp.left != null) {//ջ��������ǰ�ڵ�����������
				ns.push(tmp);
				hs.push(0);
				tmp.left = null;
			} else {
				if(ns.size() != hs.size()) {//��ǰ�ڵ����������Ļ������ջ��ֵ���ڵ�ջ����֮������ջ�Ĵ�С��һ��
					
				} else {
					tmph = 1;
				}
			}
		}
		return result;
	}
	
	public static boolean isBalanced4(TreeNode root) {
		boolean result = true;
		Stack<TreeNode> ns = new Stack<TreeNode>();
		Stack<Integer> lh = new Stack<Integer>();
		Stack<Integer> rh = new Stack<Integer>();
		
		TreeNode tmp;
		int tmpl;
		int tmpr;
		
		ns.push(root);
		lh.push(-1);
		rh.push(-1);
		
		while(ns.size() > 0) {
			tmp = ns.pop();
			tmpl = lh.pop();
			tmpr = rh.pop();
			if(tmp.left == null) {//ջ��������ǰ�ڵ�����������
				if(tmpl == -1) {
				} else {
					tmpl = 1;
				}
			} else {
				ns.push(tmp.left);
				lh.push(-1);//-1��ʾû�д��������
				rh.push(-1);
				tmp.left = null;
			}
		}
		return result;
	}
}

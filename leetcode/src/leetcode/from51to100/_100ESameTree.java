package leetcode.from51to100;

import java.util.LinkedList;
import java.util.List;

import util.TreeNode;

public class _100ESameTree {
	
	public static void main(String[] args) {
		_100ESameTree n = new _100ESameTree();
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null || q == null) {
			if(p == null && q == null) {
				return true;
			} else {
				return false;
			}
		}
		List<TreeNode> pList = new LinkedList<TreeNode>();
		List<TreeNode> qList = new LinkedList<TreeNode>();
		
		pList.add(p);
		qList.add(q);
		TreeNode tempP;
		TreeNode tempQ;
		while(pList.size() > 0 && qList.size() > 0) {
			tempP = pList.get(0);
			tempQ = qList.get(0);
			
			if(tempP.val == tempQ.val) {
				if(tempP.left == null) {
					if(tempQ.left == null) {
						//null left child, do nothing
					} else {
						return false;
					}
				} else {
					if(tempQ.left == null) {
						return false;
					} else {
						pList.add(tempP.left);
						qList.add(tempQ.left);
					}
				}
				if(tempP.right == null) {
					if(tempQ.right == null) {
						//null right child, do nothing
					} else {
						return false;
					}
				} else {
					if(tempQ.right == null) {
						return false;
					} else {
						pList.add(tempP.right);
						qList.add(tempQ.right);
					}
				}
				pList.remove(0);
				qList.remove(0);
			} else {
				return false;
			}
		}
		
		return true;
	}
}
package leetcode.from1to1000.from001to100.from51to100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class _94EBinaryTreeInorderTraversal {
	
	public static void main(String[] args) {
		TreeNode[] root = new TreeNode[3];
		root[2] = new TreeNode(3, null, null);
		root[1] = new TreeNode(2, root[2], null);
		root[0] = new TreeNode(1, null, root[1]);
		List<Integer> list = inorderTraversal(root[0]);
		for(int i = 0; i < list.size(); ++ i) {
			System.out.println(list.get(i));
		}
	}
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode tmp = null;
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			tmp = stack.peek();
			if(tmp == null) {
				break;
			}
			if(tmp.left != null) {
				stack.push(tmp.left);
				tmp.left = null;
			} else {
				result.add(tmp.val);
				stack.pop();
				if(tmp.right != null) {
					stack.push(tmp.right);
				}
			}
		}
		return result;
	}

}

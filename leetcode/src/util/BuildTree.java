package util;

public class BuildTree {
	
	public static TreeNode generator(Integer[] list) {
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
		return root;
	}
}

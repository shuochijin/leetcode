package leetcode.from21to30;

import util.ListNode;

public class No23MergekSortedLists {
	
	public static void main(String[] args) {
		No23MergekSortedLists n = new No23MergekSortedLists();
		
		int[][] nums = new int[][] {
			{1,4,5},
			{1,3,4},
			{2,6}
		};
		
		ListNode[] lists = new ListNode[nums.length];
		ListNode p = null;
		for(int i = 0; i < lists.length; ++ i) {
			for(int j = 0; j < nums[i].length; ++ j) {
				if(lists[i] == null) {
					p = new ListNode(nums[i][0]);
					lists[i] = p;
				} else {
					p.next = new ListNode(nums[i][j]);
					p = p.next;
				}
			}
		}
		
		ListNode s = n.mergeKLists(lists);
		while(s != null) {
			System.out.println(s.val);
			s = s.next;
		}
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode result = new ListNode(0);
		ListNode resultP = result;
		
		ListNode temp = null;
		int repeat;
		
		while(isNotAllNull(lists)) {
			int index = -1;
			temp = null;
			repeat = 0;
			for(int i = 0; i < lists.length; ++ i) {
				if(temp == null && lists[i] != null) {
					temp = lists[i];
					index = i;
				}
				if(temp != null && lists[i] != null && temp.val > lists[i].val) {
					temp = lists[i];
					index = i;
				}
			}
			for(int i = 0; i < lists.length; ++ i) {
				if(lists[i] != null && temp.val == lists[i].val) {
					repeat ++;
				}
			}
			if(index != -1) {
				lists[index] = lists[index].next;
			}
			while(repeat > 0) {
				resultP.next = temp;
				resultP = resultP.next;
				resultP.next = null;
				repeat --;
			}
			
		}
		
		return result.next;
	}
	
	boolean isNotAllNull(ListNode[] lists) {
		boolean result = false;
		for(int i = 0; i < lists.length; ++ i) {
			if(lists[i] != null) {
				result = true;
			}
		}
		return result;
	}
}
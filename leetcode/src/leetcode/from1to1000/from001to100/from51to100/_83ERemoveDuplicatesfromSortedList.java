package leetcode.from1to1000.from001to100.from51to100;

import util.ListNode;

public class _83ERemoveDuplicatesfromSortedList {
	
	public static void main(String[] args) {
		_83ERemoveDuplicatesfromSortedList n = new _83ERemoveDuplicatesfromSortedList();
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		ListNode p = head;
		while(p != null && p.next != null) {
			if(p.val == p.next.val) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}
		}
		
		return head;
	}
}

package leetcode.from1to1000.from201to300;

import util.ListNode;

public class _206EReverseLinkedList {
	
	public ListNode reverseList(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode result = new ListNode();
		ListNode handle = new ListNode();
		ListNode tmp;
		handle.next = head;
		while(handle.next != null) {
			tmp = handle.next;
			handle.next = handle.next.next;
			tmp.next = result.next;
			result.next = tmp;
		}
		return result.next;
	}
}

package leetcode.from1to1000.from201to300;

import util.ListNode;

public class _203ERemoveLinkedListElements {
	
	public ListNode removeElements(ListNode head, int val) {
		ListNode tmp = new ListNode(-1);
		ListNode p = new ListNode();
		tmp.next = head;
		p.next = tmp;
		while(p.next.next != null) {
			if(p.next.next.val != val) {
				p.next = p.next.next;
			} else {
				p.next.next = p.next.next.next;
			}
		}
		return tmp.next;
	}
}

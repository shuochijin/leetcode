package leetcode.from1to1000.from101to200;

import util.ListNode;

public class _141ELinkedListCycle {
	
	public static void main(String[] args) {
		int[] n = {3,2,0,-4};
		ListNode head = new ListNode();
		ListNode.buildLinkedList(head, n);
		ListNode.printLinkedList(head);
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(0);
		ListNode n4 = new ListNode(-4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2;
		System.out.println(hasCycle(n1));
	}
	
	public static boolean hasCycle(ListNode head) {
		if(head == null) {
			return false;
		}
		boolean result = false;
		ListNode tmpHead = new ListNode();
		ListNode tmpTail = new ListNode();
		tmpHead.next = head;
		tmpTail.next = head.next;
		while(tmpTail.next != null) {
			while(tmpHead.next != tmpTail.next && tmpHead.next != tmpTail.next.next) {
				tmpHead.next = tmpHead.next.next;
			}
			if(tmpHead.next == tmpTail.next.next) {
				return true;
			} else {
				tmpHead.next = head;
				tmpTail.next = tmpTail.next.next;
			}
		}
		return result;
	}
}

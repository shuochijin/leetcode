package leetcode.from1to1000.from101to200;

import util.ListNode;

public class _141ELinkedListCycle {
	
	public static void main(String[] args) {
		int[] n = {3,2,0,-4};
		ListNode head = new ListNode();
		ListNode.buildLinkedList(head, n);
		ListNode.printLinkedList(head);
		System.out.println(hasCycle(head));
	}
	
	public static boolean hasCycle(ListNode head) {
		boolean result = false;
		ListNode tmpHead = head, tmpTail = head.next;
		while(tmpTail != null) {
			while(tmpHead != tmpTail && tmpHead != tmpTail.next) {
				tmpHead = tmpHead.next;
			}
			if(tmpHead == tmpTail.next) {
				return true;
			} else {
				tmpTail = tmpTail.next;
			}
		}
		return result;
	}
}

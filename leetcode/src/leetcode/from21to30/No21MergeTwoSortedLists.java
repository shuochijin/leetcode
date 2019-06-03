package leetcode.from21to30;

import util.ListNode;

public class No21MergeTwoSortedLists {
	
	public static void main(String[] args) {
		No21MergeTwoSortedLists n = new No21MergeTwoSortedLists();
		ListNode l1 = new ListNode(1);
		(l1.next = new ListNode(3))
		.next = new ListNode(4);
		ListNode l2 = new ListNode(1);
		(l2.next = new ListNode(2))
		.next = new ListNode(4);
		
		l1 = n.mergeTwoLists(l1, l2);
		
		while(l1 != null) {
			System.out.println(l1.val);
			l1 = l1.next;
		}
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode resultP = result;
		ListNode temp;
		
		while(l1 != null || l2 != null) {
			if(l1 != null) {
				if(l2 != null && l1.val > l2.val) {
					temp = l2;
					l2 = l2.next;
				} else {
					temp = l1;
					l1 = l1.next;
				}
			} else {
				temp = l2;
				l2 = l2.next;
			}
			resultP.next = temp;
			resultP = temp;
			resultP.next = null;
		}
		
		return result.next;
	}
}

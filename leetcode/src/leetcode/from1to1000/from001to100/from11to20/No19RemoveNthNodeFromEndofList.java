package leetcode.from1to1000.from001to100.from11to20;

import util.ListNode;

public class No19RemoveNthNodeFromEndofList {
	
	public static void main(String[] args) {
		No19RemoveNthNodeFromEndofList n = new No19RemoveNthNodeFromEndofList();
		ListNode head = new ListNode(1);
		
		System.out.println(n.removeNthFromEnd(head, 1));
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int count = 1;
		ListNode tmp = head;
		while(tmp.next != null) {
			count ++;
			tmp = tmp.next;
		}
		tmp = head;
		if(n == count) {
			head = head.next;
		}else {
			n = count - n - 1;
			while(n > 0) {
				tmp = tmp.next;
				n --;
			}
			tmp.next = tmp.next.next;
		}
		return head;
	}
}
package leetcode.from1to1000.from001to100.from21to30;

import util.ListNode;

public class No25ReverseNodesinkGroup {
	
	public static void main(String[] args) {
		No25ReverseNodesinkGroup n = new No25ReverseNodesinkGroup();
		int[] nums = new int[] {2,3,4,5};
		
		ListNode head = new ListNode(1);
		ListNode p = head;
		for(int j = 0; j < nums.length; ++ j) {
			p.next = new ListNode(nums[j]);
			p = p.next;
		}
		ListNode s = n.reverseKGroup(head, 3);
		while(s != null) {
			System.out.print(s.val + " ");
			s = s.next;
		}
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode result = new ListNode(-1);
		
		ListNode p = result;
		ListNode temp;
		int c;
		a:while(head != null) {
			c = 0;
			temp = head;
			while(c < k - 1) {
				if(temp.next == null) {
					while(head != null) {
						p.next = head;
						head = head.next;
						p = p.next;
					}
					break a;
				}
				temp = temp.next;
				c ++;
			}
			c = 0;
			while(c < k && head != null) {
				temp = head;
				head = head.next;
				temp.next = p.next;
				p.next = temp;
				c ++;
			}
			while(p.next != null) {
				p = p.next;
			}
		}
		
		return result.next;
	}
}

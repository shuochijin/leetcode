package leetcode.from1to1000.from001to100.from21to30;

import util.ListNode;

public class No24SwapNodesinPairs {
	
	public static void main(String[] args) {
		No24SwapNodesinPairs n = new No24SwapNodesinPairs();
		int[] nums = new int[] {1,2,3,4};
		
		ListNode list = new ListNode(0);
		ListNode p = list;
		for(int j = 0; j < nums.length; ++ j) {
			p.next = new ListNode(nums[j]);
			p = p.next;
		}
		ListNode s = n.swapPairs(list);
		while(s != null) {
			System.out.println(s.val);
			s = s.next;
		}
	}
	
	public ListNode swapPairs(ListNode head) {
		ListNode result = new ListNode(0);
		result.next = head;
		head = result;
		
		ListNode temp;
		while(head.next != null && head.next.next != null) {
			temp = head.next;
			head.next = temp.next;
			head = head.next;
			temp.next = head.next;
			head.next = temp;
			head = head.next;
		}
		
		return result.next;
	}
}

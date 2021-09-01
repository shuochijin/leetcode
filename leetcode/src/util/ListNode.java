package util;

public class ListNode {
	public int val;
	public ListNode next = null;
	public ListNode(int x) { val = x; }
	public ListNode() {}
	
	public static void buildLinkedList(ListNode head, int[] n) {
		for(int i = 0; i < n.length; ++ i) {
			head.val = n[i];
			if(i < n.length - 1) {
				head.next = new ListNode();
				head = head.next;
			}
		}
	}
	
	public static void printLinkedList(ListNode head) {
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}

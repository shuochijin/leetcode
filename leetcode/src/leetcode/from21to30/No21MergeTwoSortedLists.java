package leetcode.from21to30;

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
		result.next = l1;
		l1 = result;
		
		ListNode p = new ListNode(0);
		p = l2;
		ListNode tmp;
		while(p != null) {
			if(l1.next != null) {
				break;
			}
			if(l1.next.val > p.val) {
				tmp = p;
				p = p.next;
				tmp.next = l1.next;
				l1.next = tmp;
			}
			l1 = l1.next;
		}
		l1.next = p;
		
		return result.next;
	}
}
class ListNode {
	int val;
	ListNode next = null;
	ListNode(int x) { val = x; }
}

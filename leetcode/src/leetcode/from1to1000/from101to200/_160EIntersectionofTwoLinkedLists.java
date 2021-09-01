package leetcode.from1to1000.from101to200;

import java.util.ArrayList;

import util.ListNode;

public class _160EIntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	ListNode result = null;
    	ArrayList<ListNode> listA = new ArrayList<ListNode>();
    	ArrayList<ListNode> listB = new ArrayList<ListNode>();
    	boolean noSameNode = true;
    	
    	ListNode tmp = headA;
    	while(tmp != null) {
    		listA.add(tmp);
    		tmp = tmp.next;
    	}
    	tmp = headB;
    	while(tmp != null) {
    		listB.add(tmp);
    		tmp = tmp.next;
    	}
    	int i = listA.size() - 1, j = listB.size() - 1;
    	for(; i >= 0 && j >= 0; --i, --j) {
    		if(listA.get(i) != listB.get(j)) {
    			if(!noSameNode) {
    				result = listA.get(i + 1);
    				break;
    			}
    		} else {
    			noSameNode = false;
    		}
    	}
    	if(!noSameNode) {
    		if(i < 0) {
				result = listA.get(0);
    		} else if(j < 0) {
    			result = listB.get(0);
    		}
    	}
    	return result;
    }
    
}

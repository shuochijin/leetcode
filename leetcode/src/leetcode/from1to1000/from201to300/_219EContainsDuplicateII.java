package leetcode.from1to1000.from201to300;

import java.util.HashMap;
import java.util.Map;

public class _219EContainsDuplicateII {
	
	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[] {1,2,3,1}, 3));
		System.out.println(containsNearbyDuplicate(new int[] {1,0,1,1}, 1));
		System.out.println(containsNearbyDuplicate(new int[] {1,2,3,1,2,3}, 2));
		
	}
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		
		int front = 0;
		int end = 0;
		while(end < nums.length) {
			if(end - front == k) {
				count.put(nums[front], count.get(nums[front]) - 1);
				front ++;
			}
			if(count.get(nums[end]) != null && count.get(nums[end]) > 0) {
				return true;
			} else {
				if(count.get(nums[end]) != null) {
					count.put(nums[end], count.get(nums[end]) + 1);
				} else {
					count.put(nums[end], 1);
				}
			}
			end ++;
			System.out.println("front:" + front + ",end:" + end);
		}
		
		return false;
	}

}

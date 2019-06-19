package leetcode.from31to40;

import java.util.Arrays;

public class No34FindFirstandLastPositionofElementinSortedArray {
	
	public static void main(String[] args) {
		No34FindFirstandLastPositionofElementinSortedArray n = new No34FindFirstandLastPositionofElementinSortedArray();
		System.out.println(Arrays.toString(n.searchRange(new int[] {}, 0)));
	}
	
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[] {-1, -1};
		
		int front = 0;
		int tail = nums.length - 1;
		while(front <= tail) {
			if(target < nums[(front + tail) / 2]) {
				tail = (front + tail) / 2 - 1;
			} else {
				front = (front + tail) / 2 + 1;
			}
		}
		
		return result;
	}
}

package leetcode.from1to1000.from001to100.from31to40;

import java.util.Arrays;

public class No34FindFirstandLastPositionofElementinSortedArray {
	
	public static void main(String[] args) {
		No34FindFirstandLastPositionofElementinSortedArray n = new No34FindFirstandLastPositionofElementinSortedArray();
		System.out.println(Arrays.toString(n.searchRange(new int[] {5,7,7,8,8,10}, 8)));
		System.out.println(Arrays.toString(n.searchRange(new int[] {5,7,7,8,8,10}, 6)));
		System.out.println(Arrays.toString(n.searchRange(new int[] {2,2}, 2)));
	}
	
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[] {-1, -1};
		
		int front = 0;
		int tail = nums.length - 1;
		while(front <= tail) {
			if(target < nums[(front + tail) / 2]) {
				tail = (front + tail) / 2 - 1;
			} else if(target > nums[(front + tail) / 2]) {
				front = (front + tail) / 2 + 1;
			} else {
				result[0] = (front + tail) / 2;
				result[1] = (front + tail) / 2;
				break;
			}
		}
		
		front = 0;
		while(front < result[0]) {
			if(nums[(front + result[0]) / 2] != target) {
				front = (front + result[0]) / 2 + 1;
			} else {
				result[0] = (front + result[0]) / 2;
			}
		}
		
		tail = nums.length - 1;
		while(result[1] < tail) {
			if(nums[(result[1] + tail + 1) / 2] == target) {
				result[1] = (result[1] + tail + 1) / 2;
			} else {
				tail = (result[1] + tail + 1) / 2 - 1;
			}
		}
		
		return result;
	}
}

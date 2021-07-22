package leetcode.from1to1000.from001to100.from31to40;

import java.util.ArrayList;
import java.util.Arrays;

public class No31NextPermutation {
	
	public static void main(String[] args) {
		No31NextPermutation n = new No31NextPermutation();
		int[] nums = new int[] {1, 2, 3};
		Arrays.sort(nums = new int[] {5, 4, 3, 2, 1}, 1, nums.length);
		System.out.println(Arrays.toString(nums));
		n.nextPermutation(nums = new int[] {1, 2, 3});
		System.out.println(Arrays.toString(nums));
		n.nextPermutation(nums = new int[] {1, 3, 2});
		System.out.println(Arrays.toString(nums));
	}
	
	public void nextPermutation(int[] nums) {
		boolean sort = true;
		for(int i = nums.length - 1; i > 0; -- i) {
			if(nums[i] > nums[i - 1]) {
				int min = i;
				for(int j = i; j < nums.length; ++ j) {
					if(nums[j] < nums[min] && nums[j] > nums[i - 1]) {
						min = j;
					}
				}
				int temp = nums[min];
				nums[min] = nums[i - 1];
				nums[i - 1] = temp;
				Arrays.sort(nums, i, nums.length);
				sort = false;
				break;
			}
		}
		if(sort) {
			Arrays.sort(nums);
		}
	}
}

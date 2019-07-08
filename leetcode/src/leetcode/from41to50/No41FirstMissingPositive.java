package leetcode.from41to50;

import java.util.Arrays;

public class No41FirstMissingPositive {
	
	public static void main(String[] args) {
		No41FirstMissingPositive n = new No41FirstMissingPositive();
		System.out.println(n.firstMissingPositive(new int[] {1}));
	}
	
	public int firstMissingPositive(int[] nums) {
		int result = 1;
		boolean[] flag = new boolean[nums.length];
		int max = -1;
		int i;
		for(i = 0; i < nums.length; ++ i) {
			if(nums[i] > 0 && nums[i] <= nums.length) {
				flag[nums[i] - 1] = true;
				if(nums[i] > max) {
					max = nums[i];
				}
			}
		}
		for(i = 0; i < max; ++ i) {
			if(flag[i] == false) {
				result = i + 1;
				break;
			}
		}
		if(i == max) {
			result = max + 1;
		}
		return result;
	}
}

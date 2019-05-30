package leetcode.from11to20;

import java.util.Arrays;

public class No163SumClosest {
	
	public static void main(String[] args) {
		No163SumClosest n = new No163SumClosest();
		int[] nums;
		nums = new int[] {-1, 2, 1, -4};
		System.out.println(n.threeSumClosest(nums, 2));
		System.out.println(n.threeSumClosest(nums, 1));
	}
	
	public int threeSumClosest(int[] nums, int target) {
		long result = Integer.MIN_VALUE + 1;
		
		Arrays.sort(nums);
		
		a:for(int i = 0; i < nums.length - 2; ++ i) {
			int front = i + 1;
			int tail = nums.length - 1;
			while(front < tail) {
				if(nums[i] + nums[front] + nums[tail] == target) {
					result = target;
					break a;
				}
				if(Math.abs(nums[i] + nums[front] + nums[tail] - target)
						< Math.abs(result - target)) {
					result = nums[i] + nums[front] + nums[tail];
				}
				if(nums[i] + nums[front] + nums[tail] > target) {
					tail --;
				}else {
					front ++;
				}
			}
		}
		
		return (int)result;
	}

}

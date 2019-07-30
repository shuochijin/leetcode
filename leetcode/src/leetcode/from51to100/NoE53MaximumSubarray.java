package leetcode.from51to100;

public class NoE53MaximumSubarray {
	
	public static void main(String[] args) {
		NoE53MaximumSubarray n = new NoE53MaximumSubarray();
		System.out.println(n.maxSubArray(new int[] {1}));
		System.out.println(n.maxSubArray(new int[] {-1,-2}));
		System.out.println(n.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println(n.maxSubArray(new int[] {-2,-1,-3,-4,-1,-2,-1,-5,-4}));
	}
	
	public int maxSubArray(int[] nums) {
		int result = nums[0];
		
		int temp = nums[0];
		for(int i = 1; i < nums.length; ++ i) {
			if(temp < 0) {
				temp = nums[i];
			} else {
				temp += nums[i];
				if(temp < 0) {
					temp = nums[i];
				}
			}
			if(temp > result) {
				result = temp;
			}
		}
		
		return result;
	}
}

package leetcode.from51to60;

public class No55JumpGame {
	
	public static void main(String[] args) {
		No55JumpGame n = new No55JumpGame();
		System.out.println(n.canJump2(new int[] {1,2,3}));
		System.out.println(n.canJump2(new int[] {3,2,1,0,4}));
	}
	
	public boolean canJump(int[] nums) {
		boolean result = false;
		
		int max = 0;
		for(int i = 0; i < nums.length; ++i) {
			if(max >= i && max < i + nums[i]) {
				max = i + nums[i];
			}
		}
		
		if(max >= nums.length - 1) {
			result = true;
		}
		
		return result;
	}
	
	public boolean canJump2(int[] nums) {
		boolean result = false;
		
		int max = nums[0];
		for(int i = 0; i <= max && i < nums.length; ++i) {
			if(max >= i && max < i + nums[i]) {
				max = i + nums[i];
			}
		}
		
		if(max >= nums.length - 1) {
			result = true;
		}
		
		return result;
	}
}

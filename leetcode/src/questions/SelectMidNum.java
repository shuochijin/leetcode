package questions;

public class SelectMidNum {
	
	public static int select(int[] nums) {
		int lCount = 0;
		int rCount = 0;
		int left = -1;
		int mid = -1;
		int right = -1;
		for(int i = 0; i < nums.length; ++ i) {
			if(mid == -1) {
				mid = nums[i];
				continue;
			}
			if(nums[i] < mid) {
				if(lCount == 0) {
					left = nums[i];
					lCount ++;
					continue;
				}
				if(lCount > rCount) {
					right = mid;
					mid = nums[i];
					rCount ++;
					continue;
				} else {
					left = nums[i];
					lCount ++;
					continue;
				}
			} else {
				if(rCount == 0) {
					right = nums[i];
					rCount ++;
					continue;
				}
				if(rCount > lCount) {
					left = mid;
					mid = nums[i];
					lCount ++;
					continue;
				} else {
					right = nums[i];
					rCount ++;
					continue;
				}
			}
		}
		return mid;
	}
	
	public static void main(String[] args) {
		System.out.println(select(new int[] {1,2,3,4,5,6,7}));
	}

}

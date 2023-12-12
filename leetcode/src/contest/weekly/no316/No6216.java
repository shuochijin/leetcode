package contest.weekly.no316;

public class No6216 {
	
	public static void main(String[] args) {
		No6216 n = new No6216();
		System.out.println(n.minCost(new int[] {1,2}, new int[] {1,100}));
//		System.out.println(n.minCost(new int[] {1,3,5,2}, new int[] {2,3,1,14}));
//		System.out.println(n.minCost(new int[] {2,2,2,2,2}, new int[] {4,2,8,1,3}));
//		System.out.println(n.minCost(new int[] {735103,366367,132236,133334,808160,113001,49051,735598,686615,665317,999793,426087,587000,649989,509946,743518},
//				new int[] {724182,447415,723725,902336,600863,287644,13836,665183,448859,917248,397790,898215,790754,320604,468575,825614}));
	}
	
    public long minCost(int[] nums, int[] cost) {
    	long result = 0;
    	
    	long min = nums[0];
    	long max = nums[0];
    	for(int i = 0; i < nums.length; ++ i) {
    		if(min > nums[i]) {
    			min = nums[i];
    		}
    		if(max < nums[i]) {
    			max = nums[i];
    		}
    	}
    	
    	long tmp = 0;
    	for(long i = min; i <= max; ++ i) {
    		tmp = 0;
    		for(int j = 0; j < nums.length; ++ j) {
    			tmp += Math.abs(nums[j] - i) * cost[j];
    		}
    		if(result == 0 || tmp < result) {
    			result = tmp;
    		}
    	}
    	
    	return result;
    }

}

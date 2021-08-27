package leetcode.from1to1000.from101to200;

import java.util.HashMap;
import java.util.Map;

public class _136ESingleNumber {
	
	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length / 2 + 1);
		for(int i = 0; i < nums.length; ++ i) {
			if(map.containsKey(nums[i])) {
				map.remove(nums[i]);
			} else {
				map.put(nums[i], 1);
			}
		}
		return map.entrySet().iterator().next().getKey();
	}

}

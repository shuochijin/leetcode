package leetcode.from11to20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No153Sum {
	
	public static void main(String[] args) {
		int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
		Arrays.sort(nums);
		System.out.println(nums);
		No153Sum n = new No153Sum();
		System.out.println(n.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
		System.out.println(n.threeSum(new int[] {-1,0,1,2,-1,-4}));
	}

	private List<List<Integer>> result;
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		int zeroOrP = -1;
		for(int i = 0; i < nums.length; ++ i) {
			if(nums[i] >= 0) {
				zeroOrP = i;
			}
		}
		result  = new ArrayList<List<Integer>>();
		for(int i = 0; i < nums.length - 2; ++ i) {
			for(int j = i + 1; j < nums.length - 1; ++ j) {
				for(int k = j + 1; k < nums.length; ++ k) {
					if(nums[i] + nums[j] + nums[k] == 0) {
						checkAndSet(nums[i], nums[j], nums[k]);
					}
				}
			}
		}
		return result;
	}
	
	public boolean checkAndSet(int i, int j, int k) {
		boolean flag = false;
		List<Integer> piece = createList(i, j, k);
		List<Integer> ele;
		for(int size = 0; size < result.size(); ++ size) {
			ele = result.get(size);
			if(ele.get(0) == piece.get(0)
					&& ele.get(1) == piece.get(1)
					&& ele.get(2) == piece.get(2)) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			result.add(piece);
		}
		return flag;
	}
	
	public List<Integer> createList(int i, int j, int k){
		List<Integer> list = new ArrayList<Integer>();
		if(i < j) {
			if(i < k) {
				list.add(i);
				if(j < k) {
					list.add(j);
					list.add(k);
				}else {
					list.add(k);
					list.add(j);
				}
			}else {
				list.add(k);
				list.add(i);
				list.add(j);
			}
		}else {
			if(i < k) {
				list.add(j);
				list.add(i);
				list.add(k);
			}else {
				if(j < k) {
					list.add(j);
					list.add(k);
				}else {
					list.add(k);
					list.add(j);
				}
				list.add(i);
			}
		}
		return list;
	}
}

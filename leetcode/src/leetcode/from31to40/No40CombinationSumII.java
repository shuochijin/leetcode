package leetcode.from31to40;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No40CombinationSumII {
	
	public static void main(String[] args) {
		No40CombinationSumII n = new No40CombinationSumII();
		System.out.println(n.combinationSum2(new int[] {10,1,2,7,6,1,5}, 8).toString());
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		System.out.println(Arrays.toString(candidates));
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		
		int index = -1;
		int sum = 0;
		int[] indexes = new int[target];
		int count = 0;
		List<Integer> temp;
		int pre = -1;
		while(index < candidates.length) {
			if(sum < target) {
				while(pre != -1 && index < candidates.length && pre == candidates[index]) {
					index ++;
				}
				indexes[count ++] = index;
				sum += candidates[index];
				while(count > 0 && index >= candidates.length - 1){
					index = indexes[count - 1];
					count --;
					sum -= candidates[index];
				}
				index ++;
				pre = -1;
			} else {
				if(sum == target) {
					temp = new LinkedList<Integer>();
					for(int i = 0; i < count; ++ i) {
						temp.add(candidates[indexes[i]]);
					}
					result.add(temp);
				}
				while(count > 0 && index >= candidates.length - 1){
					index = indexes[count - 1];
					count --;
					sum -= candidates[index];
				}
				pre = candidates[index];
				index ++;
			}
		}
		
		return result;
	}
}

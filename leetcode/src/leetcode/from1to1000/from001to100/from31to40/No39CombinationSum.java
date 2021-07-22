package leetcode.from1to1000.from001to100.from31to40;

import java.util.LinkedList;
import java.util.List;

public class No39CombinationSum {
	
	public static void main(String[] args) {
		No39CombinationSum n = new No39CombinationSum();
		System.out.println(n.combinationSum2(new int[] {2,3,6,7}, 7).toString());
		System.out.println(n.combinationSum2(new int[] {2,3,5}, 8).toString());
		System.out.println(n.combinationSum2(new int[] {2,3,4,5,6,7}, 50).toString());
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		
		int index = 0;
		int sum = 0;
		List<Integer> e = new LinkedList<Integer>();
		List<Integer> temp;
		while(index < candidates.length) {
			if(sum < target) {
				e.add(index);
				sum += candidates[index];
			} else {
				if(sum == target) {
					temp = new LinkedList<Integer>();
					for(int i = 0; i < e.size(); ++ i) {
						temp.add(candidates[e.get(i)]);
					}
					result.add(temp);
				}
				do {
					index = e.remove(e.size() - 1);
					sum -= candidates[index];
				}while(e.size() > 0 && index >= candidates.length - 1);
				index ++;
			}
		}
		
		return result;
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		
		int index = 0;
		int sum = 0;
		int[] indexes = new int[target];
		int count = 0;
		List<Integer> temp;
		while(index < candidates.length) {
			if(sum < target) {
				indexes[count ++] = index;
				sum += candidates[index];
			} else {
				if(sum == target) {
					temp = new LinkedList<Integer>();
					for(int i = 0; i < count; ++ i) {
						temp.add(candidates[indexes[i]]);
					}
					result.add(temp);
				}
				do {
					index = indexes[count - 1];
					count --;
					sum -= candidates[index];
				}while(count > 0 && index >= candidates.length - 1);
				index ++;
			}
		}
		
		return result;
	}
	
	public List<List<Integer>> combinationSum3(int[] candidates, int target) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		
		int index = 0;
		int sum = 0;
		int[] indexes = new int[target];
		int[] values = new int[target];
		int count = 0;
		List<Integer> temp;
		while(index < candidates.length) {
			if(sum < target) {
				indexes[count ++] = index;
				sum += candidates[index];
			} else {
				if(sum == target) {
					temp = new LinkedList<Integer>();
					for(int i = 0; i < count; ++ i) {
						temp.add(candidates[indexes[i]]);
					}
					result.add(temp);
				}
				do {
					index = indexes[count - 1];
					count --;
					sum -= candidates[index];
				}while(count > 0 && index >= candidates.length - 1);
				index ++;
			}
		}
		
		return result;
	}
}

package leetcode.from1to1000.from101to200;

public class _167ETwoSumIIInputarrayissorted {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[]{0, numbers.length - 1};
		
		while(result[0] < result[1]) {
			if(numbers[result[0]] + numbers[result[1]] > target) {
				result[1] --;
			} else if(numbers[result[0]] + numbers[result[1]] < target) {
				result[0] ++;
			} else {
				break;
			}
		}
		result[0] ++;
		result[1] ++;
		return result;
	}
}

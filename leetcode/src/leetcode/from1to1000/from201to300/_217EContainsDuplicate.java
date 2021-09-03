package leetcode.from1to1000.from201to300;

public class _217EContainsDuplicate {
	
	public static void main(String[] args) {
		System.out.println(containsDuplicate2(new int[] {1,2,3,1}));
		System.out.println(containsDuplicate2(new int[] {1,2,3,4}));
		System.out.println(containsDuplicate2(new int[] {1,1,1,3,3,4,3,2,4,2}));
	}
	
	public boolean containsDuplicate(int[] nums) {
		boolean result = false;
		for(int i = 0, j; i < nums.length; ++ i) {
			for(j = 0; j < i; ++ j) {
				if(nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return result;
	}
	
	public static boolean containsDuplicate2(int[] nums) {
		boolean result = false;
		
		int hashSeed = nums.length * 2 + 1;
		boolean[] hashFlag = new boolean[hashSeed];
		int[] hashTable = new int[hashSeed];
		
		for(int i = 0, hash; i < nums.length; ++ i) {
			hash = Math.abs(nums[i] % hashSeed);
			while(hashFlag[hash]) {
				if(hashTable[hash] != nums[i]) {
					hash = (hash + 1) % hashSeed;
				} else {
					return true;
				}
			}
			hashFlag[hash] = true;
			hashTable[hash] = nums[i];
		}
		return result;
	}
}

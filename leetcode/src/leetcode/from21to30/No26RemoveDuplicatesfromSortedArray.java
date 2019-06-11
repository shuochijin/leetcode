package leetcode.from21to30;

public class No26RemoveDuplicatesfromSortedArray {
	
	public static void main(String[] args) {
		No26RemoveDuplicatesfromSortedArray n = new No26RemoveDuplicatesfromSortedArray();
		System.out.println(n.removeDuplicates(new int[] {1,1,2}));
		System.out.println(n.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
		System.out.println(n.removeDuplicates(new int[] {}));
	}
	
	public int removeDuplicates(int[] nums) {
		int result = 0;
		long temp = Long.MAX_VALUE;
		int front = 0;
		
		for(int i = 0; i < nums.length; ++ i) {
			if(temp != nums[i]) {
				result ++;
				temp = nums[i];
				nums[front] = nums[i];
				front ++;
			}
		}
		
		return result;
	}
	
}

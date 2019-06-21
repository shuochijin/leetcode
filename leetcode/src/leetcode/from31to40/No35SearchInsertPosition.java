package leetcode.from31to40;

public class No35SearchInsertPosition {
	
	public static void main(String[] args) {
		No35SearchInsertPosition n = new No35SearchInsertPosition();
		System.out.println(n.searchInsert(new int[] {1,3,5,6}, 5));
		System.out.println(n.searchInsert(new int[] {1,3,5,6}, 2));
		System.out.println(n.searchInsert(new int[] {1,3,5,6}, 7));
		System.out.println(n.searchInsert(new int[] {1,3,5,6}, 0));
	}
	
	public int searchInsert(int[] nums, int target) {
		int front = 0;
		int tail = nums.length - 1;
		
		while(front <= tail) {
			if(nums[(front + tail) / 2] < target) {
				front = (front + tail) / 2 + 1;
			} else {
				tail = (front + tail) / 2 - 1;
			}
		}
		
		return front;
	}
}

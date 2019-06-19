package leetcode.from31to40;

public class No33SearchinRotatedSortedArray {
	
	public static void main(String[] args) {
		No33SearchinRotatedSortedArray n = new No33SearchinRotatedSortedArray();
		System.out.println(n.search(new int[] {1, 3, 5}, 3));
		System.out.println(n.search(new int[] {4,5,6,7,0,1,2}, 0));
		System.out.println(n.search(new int[] {4,5,6,7,0,1,2}, 3));
	}
	
	public int search(int[] nums, int target) {
		if(nums.length == 0) {
			return -1;
		}
		int front = 0;
		int tail = nums.length - 1;
		while(nums[front] > nums[tail]) {
			if(nums[(front + tail) / 2] < nums[tail]) {
				tail = (front + tail) / 2;
			} else {
				front = (front + tail) / 2 + 1;
			}
			if(nums[front] <= nums[tail]) {
				break;
			}
		}
		tail = nums.length - 1 + front;
		
		int temp;
		int remain;
		while(front <= tail) {
			temp = (front + tail) / 2;
			remain = temp % nums.length;
			if(target < nums[remain]) {
				tail = temp - 1;
			} else if(target > nums[remain]) {
				front = temp + 1;
			} else {
				front = remain;
				break;
			}
		}
		
		if(front <= tail) {
			return front % nums.length;
		} else {
			return -1;
		}
		
	}
}

package leetcode.from1to1000.from001to100.from51to100;

public class _88EMergeSortedArray {
	
	public static void main(String[] args) {
		_88EMergeSortedArray n = new _88EMergeSortedArray();
		System.out.println(11111);
	}
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		while(m > 0 || n > 0) {
			if(m > 0 && n > 0) {
				if(nums1[m - 1] > nums2[n - 1]) {
					nums1[m + n - 1] = nums1[m - 1];
					m --;
				} else {
					nums1[m + n - 1] = nums2[n - 1];
					n --;
				}
			} else {
				if(n == 0) {
					nums1[m + n - 1] = nums1[m - 1];
					m --;
				} else {
					nums1[m + n - 1] = nums2[n - 1];
					n --;
				}
			}
		}
	}
}

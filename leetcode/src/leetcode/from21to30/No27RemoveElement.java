package leetcode.from21to30;

public class No27RemoveElement {
	
	public static void main(String[] args) {
		No27RemoveElement n = new No27RemoveElement();
		System.out.println(n.removeElement(new int[] {3,2,2,3}, 3));
		System.out.println(n.removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));
		System.out.println(n.removeElement(new int[] {}, 1));
	}
	
	public int removeElement(int[] nums, int val) {
		int result = 0;
		int front = 0;
		
		for(int i = 0; i < nums.length; ++ i) {
			if(val != nums[i]) {
				result ++;
				nums[front] = nums[i];
				front ++;
			}
		}
		
		return result;
	}
}

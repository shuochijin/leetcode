package leetcode.from1to1000.from001to100.from41to50;

public class No42TrappingRainWater {
	
	public static void main(String[] args) {
		No42TrappingRainWater n = new No42TrappingRainWater();
				System.out.println(n.trap(new int[] {5,2,1,2,1,5}));
		System.out.println(n.trap(new int[] {2,0,2}));
		System.out.println(n.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println(n.trap(new int[] {4,2,0,3,2,5}));
	}
	public int trap(int[] height) {
		int sum = 0;
		
		int[] sideHighest = new int[height.length];
		
		int tmp, i;
		for(i = 0, tmp = 0; i < sideHighest.length; ++ i) {
			if(tmp < height[i]) {
				tmp = height[i];
			}
			sideHighest[i] = tmp;
		}
		
		for(i = height.length - 1, tmp = 0; i >= 0; -- i) {
			if(tmp < height[i]) {
				tmp = height[i];
			}
			if(tmp > sideHighest[i]) {
				tmp = sideHighest[i];
			}
			sideHighest[i] = tmp;
		}

		for(i = 0; i < height.length; ++ i) {
			sum += sideHighest[i] - height[i];
		}
		
		return sum;
	}
	
	public void print(int[] n) {
		for(int i = 0; i < n.length; ++ i) {
			System.out.print(n[i] + " ");
		}
		System.out.println();
	}
}

package leetcode.from1to1000.from001to100.from41to50;

public class No42TrappingRainWater {
	
	public static void main(String[] args) {
		No42TrappingRainWater n = new No42TrappingRainWater();
				System.out.println(n.trap(new int[] {5,2,1,2,1,5}));
		System.out.println(n.trap(new int[] {2,0,2}));
		System.out.println(n.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
	}
	public int trap(int[] height) {
		int sum = 0;
		
		int leftPeek = 0;
		int rightPeek = 0;
		int hor = 0;
		int i;
		for(i = 0; i < height.length; ++ i) {
			if(height[i] >= height[rightPeek]) {
				rightPeek = i;
			} else {
				leftPeek = rightPeek;
				break;
			}
		}
		boolean isDown = true;
		for(; i < height.length || (i == height.length && !isDown); ++ i) {
			if(isDown) {
				if(height[i] > height[rightPeek]) {
					isDown = false;
				}
				rightPeek = i;
			} else {
				if(i != height.length && height[i] >= height[rightPeek]) {
					rightPeek = i;
				} else {
					if(height[leftPeek] < height[rightPeek]) {
						hor = height[leftPeek];
					} else {
						hor = height[rightPeek];
					}
					while(leftPeek < rightPeek) {
						if(height[leftPeek] < hor) {
							sum += hor - height[leftPeek];
						}
						leftPeek ++;
					}
					-- i;
					isDown = true;
				}
			}
		}
		
		return sum;
	}
}

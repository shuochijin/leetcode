package questions;

import java.util.Arrays;

public class PickBalls {
	
	public static void main(String[] args) {
		PickBalls p = new PickBalls();
		p.recursion(new int[] {1,2,3,4,5}, 0, new int[3], 0);
	}
	
	public void recursion(int[] balls, int ballIndex, int[] result, int index) {
		while(ballIndex < balls.length) {
			result[index] = balls[ballIndex];
			if(index == result.length - 1) {
				System.out.println(Arrays.toString(result));
			} else {
				recursion(balls, ballIndex, result, index + 1);
			}
			ballIndex ++;
		}
	}
}

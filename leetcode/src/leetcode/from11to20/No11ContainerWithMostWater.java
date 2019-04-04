package leetcode.from11to20;

import java.util.ArrayList;
import java.util.List;

public class No11ContainerWithMostWater {
	
	public static void main(String[] args) {
		No11ContainerWithMostWater n = new No11ContainerWithMostWater();
		System.out.println(n.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
	}
	
	public int maxArea(int[] height) {
		int result = 0;
        int[] forwards = new int[height.length];
        int[] backwards = new int[height.length];
        int forwardLength = 0;
        int backwardLength = 0;
        int forwardtemp = 0;
        int backwardtemp = 0;
        for(int i = 0; i < height.length; ++ i) {
        	if(height[i] > forwardtemp) {
        		forwardtemp = height[i];
        		forwards[forwardLength ++] = i;
        	}
        }
        for(int j = height.length - 1; j >= 0; -- j) {
        	if(height[j] > backwardtemp) {
        		backwardtemp = height[j];
        		backwards[backwardLength ++] = j;
        	}
        }
        for(int i = 0; i < forwardLength; ++ i) {
        	for(int j = 0; j < backwardLength && forwards[i] < backwards[j]; ++ j) {
        		forwardtemp = height[forwards[i]];
        		backwardtemp = height[backwards[j]];
        		int heightTemp = forwardtemp < backwardtemp ? forwardtemp : backwardtemp;
        		int lengthTemp = backwards[j] - forwards[i];
        		if(heightTemp * lengthTemp > result) {
        			result = heightTemp * lengthTemp;
        		}
        	}
        }
        return result;
	}
}

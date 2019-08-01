package leetcode.from51to100;

import java.util.Arrays;

public class _66EPlusOne {
	
	public static void main(String[] args) {
		_66EPlusOne n = new _66EPlusOne();
		System.out.println(Arrays.toString(n.plusOne(new int[] {8,9,9,9})));
		System.out.println(Arrays.toString(n.plusOne(new int[] {9,8,7,6,5,4,3,2,1,0})));
	}
	
	public int[] plusOne(int[] digits) {
		int [] result;
		
		int carry = 0;
		for(int i = digits.length - 1; i >= 0; -- i) {
			if(digits[i] + carry == 10 || (digits[i] + carry ==  9 && i == digits.length - 1)) {
				digits[i] = 0;
				carry = 1;
			} else {
				if(i == digits.length - 1) {
					digits[i] = digits[i] + 1;
				}
				digits[i] += carry;
				carry = 0;
			}
		}
		
		result = new int[digits.length + carry];
		int i = 0;
		if(carry == 1) {
			result[i] = 1;
			i ++;
		}
		for(; i < result.length; ++ i) {
			result[i] = digits[i - carry];
		}
		
		return result;
	}
}

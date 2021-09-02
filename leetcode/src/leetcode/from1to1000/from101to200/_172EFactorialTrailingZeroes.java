package leetcode.from1to1000.from101to200;

public class _172EFactorialTrailingZeroes {
	
	public int trailingZeroes(int n) {
		int result = 0;
		
		while(n > 0) {
			result += n / 5;
			n /= 5;
		}
		return result;
	}

}

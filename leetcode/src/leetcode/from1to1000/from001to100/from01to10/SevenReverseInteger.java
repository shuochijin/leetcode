package leetcode.from1to1000.from001to100.from01to10;

public class SevenReverseInteger {
	
	public static void main(String[] args) {
		SevenReverseInteger s = new SevenReverseInteger();
		System.out.println(s.reverse(1534236469));
		System.out.println(s.reverse(-123));
	}
	
	public int reverse(int x) {
		long xx = x;
		long resultx = 0;
		long temp;
		while(xx != 0) {
			temp = xx % 10;
			resultx = 10 * resultx + temp;
			xx = xx / 10;
		}
		
		if(resultx > Integer.MAX_VALUE || resultx < Integer.MIN_VALUE){
			return 0;
		}
		
		return (int) resultx;
	}
	
}

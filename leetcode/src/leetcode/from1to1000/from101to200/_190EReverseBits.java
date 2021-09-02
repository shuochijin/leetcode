package leetcode.from1to1000.from101to200;

public class _190EReverseBits {
	
	public static void main(String[] args) {
		int n = buildBinaryInt("11111111111111111111111111111101");
		System.out.println(reverseBits(n));
	}
	
	public static int buildBinaryInt(String s) {
		int n = 0;
		for(int i = 0; i < 32; ++ i) {
			n <<= 1;
			if(s.charAt(i) == '1') {
				n += 1;
			}
		}
		return n;
	}
	
	public static int reverseBits(int n) {
		if(n < 0) {
			n &= Integer.MAX_VALUE;
			n += Integer.MAX_VALUE + 1;
		}
		return n;
	}
}

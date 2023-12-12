package leetcode.from1to1000.from101to200;

public class _191ENumberof1Bits {
	
	public static void main(String[] args) {
		System.out.println(hammingWeight(1));
		System.out.println(hammingWeight(2));
		System.out.println(hammingWeight(3));
		System.out.println(hammingWeight(4));
		System.out.println(hammingWeight(-1));
	}

	public static int hammingWeight(int n) {
		int i = 0;
		while(n != 0) {
			if(n % 2 == 1 || n % 2 == -1 ) {
				++ i;
			}
			n >>>= 1;
		}
		return i;
	}
}

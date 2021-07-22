package leetcode.from1to1000.from001to100.from21to30;

public class No29DivideTwoIntegers {
	
	public static void main(String[] args) {
		No29DivideTwoIntegers n = new No29DivideTwoIntegers();
		System.out.println(n.divide(10, 3));
		System.out.println(n.divide(7, -3));
		System.out.println(n.divide(-2147483648, 1));
	}
	
	public int divide(int dividend, int divisor) {
		long ded = dividend;
		long sor = divisor;
		long result = 0;
		boolean dedFlag = true;
		boolean sorFlag = true;
		boolean resultFlag = true;
		
		if(ded < 0) {
			dedFlag = false;
			ded = 0 - ded;
		}
		if(divisor < 0) {
			sorFlag = false;
			sor = 0 - sor;
		}
		resultFlag = !(dedFlag ^ sorFlag);
		
		long[] q = new long[32];
		q[0] = sor;
		int i = 1;
		while(i < q.length && q[i - 1] < Integer.MAX_VALUE) {
			q[i] = q[i - 1] << 1;
			 ++ i;
		}
		i --;
		while(i >= 0) {
			result <<= 1;
			if(ded > q[i]) {
				result ++;
				ded -= q[i];
			}
			i --;
		}
		if(ded == q[0]) {
			result ++;
		}
		
		if(!resultFlag) {
			result = 0 - result;
		}
		if(result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		return (int)result;
	}
}

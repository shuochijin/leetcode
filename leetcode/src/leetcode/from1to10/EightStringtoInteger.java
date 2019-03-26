package leetcode.from1to10;

public class EightStringtoInteger {
	
	public static void main(String[] args) {
		EightStringtoInteger e = new EightStringtoInteger();
		System.out.println(e.myAtoi("+4+2"));
		System.out.println(e.myAtoi("42"));
		System.out.println(e.myAtoi("   -42"));
		System.out.println(e.myAtoi("4193 with words"));
		System.out.println(e.myAtoi("words and 987"));
		System.out.println(e.myAtoi("-91283472332"));
		System.out.println(e.myAtoi("9223372036854775808"));
		System.out.println(e.myAtoi("18446744073709551617"));
	}
	
	public int myAtoi(String str) {
		long result = 0;
		int noro = 1;
		boolean flag = false;
		boolean numberTouched = false;
		boolean signTouched = false;
		char c;
		for(int i = 0; i < str.length(); ++ i) {
			c = str.charAt(i);
			if(c == ' ' && !numberTouched && !signTouched) {
				continue;
			}else if(c == ' ' && (numberTouched || signTouched)) {
				break;
			}else if(c == '-') {
				if(numberTouched || signTouched) {
					break;
				}else {
					noro = -1;
					signTouched = true;
				}
			}else if(c == '+') {
				if(numberTouched || signTouched) {
					break;
				}else {
					signTouched = true;
				}
			}else if(c >= '0' && c <= '9') {
				if(!numberTouched || noro > 0) {
					result = 10 * result - '0' + c;
					result *= noro;
				}else {
					result = 10 * result - c + '0';
				}
				numberTouched = true;
				if(noro > 0 && result > Integer.MAX_VALUE) {
					result = Integer.MAX_VALUE;
					break;
				}
				if(noro < 0 && result < Integer.MIN_VALUE) {
					result = Integer.MIN_VALUE;
					break;
				}
			}else {
				break;
			}
		}
		return (int) result;
	}
}

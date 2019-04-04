package leetcode.from11to20;

public class No13RomantoInteger {
	
	public static void main(String[] args) {
		No13RomantoInteger n = new No13RomantoInteger();
		System.out.println(n.romanToInt("III"));
		System.out.println(n.romanToInt("IV"));
		System.out.println(n.romanToInt("IX"));
		System.out.println(n.romanToInt("LVIII"));
		System.out.println(n.romanToInt("MCMXCIV"));
	}
	
	public int romanToInt(String s) {
		int result = 0;
//		char[] syb = new char[] {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
//		int[] bits = new int[] {1, 5, 10, 50, 100, 500, 1000};
		for(int i = 0; i < s.length(); ++ i) {
			switch(s.charAt(i)) {
			case 'I':
				if(i != s.length() - 1) {
					if(s.charAt(i + 1) == 'V') {
						result += 3;
						i ++;
					}else if(s.charAt(i + 1) == 'X') {
						result += 8;
						i ++;
					}
				}
				result += 1;
				break;
			case 'V':
				result += 5;
				break;
			case 'X':
				if(i != s.length() - 1) {
					if(s.charAt(i + 1) == 'L') {
						result += 30;
						i ++;
					}else if(s.charAt(i + 1) == 'C') {
						result += 80;
						i ++;
					}
				}
				result += 10;
				break;
			case 'L':
				result += 50;
				break;
			case 'C':
				if(i != s.length() - 1) {
					if(s.charAt(i + 1) == 'D') {
						result += 300;
						i ++;
					}else if(s.charAt(i + 1) == 'M') {
						result += 800;
						i ++;
					}
				}
				result += 100;
				break;
			case 'D':
				result += 500;
				break;
			case 'M':
				result += 1000;
				break;
			}
		}
		return result;
	}
}

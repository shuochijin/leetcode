package leetcode.from11to20;

public class No12IntegertoRoman {
	
	public static void main(String[] args) {
		No12IntegertoRoman n = new No12IntegertoRoman();
		System.out.println(n.intToRoman(3));
		System.out.println(n.intToRoman(4));
		System.out.println(n.intToRoman(9));
		System.out.println(n.intToRoman(58));
		System.out.println(n.intToRoman(1994));
	}
	
	public String intToRoman(int num) {
		String result = "";
		char[] syb = new char[] {'I', 'I', 'V', 'X', 'L', 'C', 'D', 'M'};
		int[] bits = new int[] {1, 1, 5, 10, 50, 100, 500, 1000};
		int r = num / bits[syb.length - 1];
		int t = num % bits[syb.length - 1];
		for(int j = 0; j < num / bits[syb.length - 1]; ++ j) {
			result = result + syb[syb.length - 1];
		}
		r = t / bits[syb.length - 2];
		t = t % bits[syb.length - 1];
		
		for(int i = syb.length - 2; i > 0; -- i) {
			r = t / bits[i];
			if(r != 0) {
				if(i % 2 == 0) {
					if(t / bits[i - 1] == 9) {
						result = result + syb[i - 1] + syb[i + 1];
						i --;
					}else {
						result = result + syb[i];
					}
				}else {
					if(t / bits[i] == 4) {
						result = result + syb[i] + syb[i + 1];
					}else {
						for(int j = 0; j < t / bits[i]; ++ j) {
							result = result + syb[i];
						}
					}
				}
			}
			t = t % bits[i];
		}
		return result;
	}
	
	public String intToRoman2(int num) {
		StringBuilder result = new StringBuilder();
		char[] syb = new char[] {'I', 'I', 'V', 'X', 'L', 'C', 'D', 'M'};
		int[] bits = new int[] {1, 1, 5, 10, 50, 100, 500, 1000};
		int r = num / bits[syb.length - 1];
		int t = num % bits[syb.length - 1];
		for(int j = 0; j < num / bits[syb.length - 1]; ++ j) {
			result.append(syb[syb.length - 1]);
		}
		r = t / bits[syb.length - 2];
		t = t % bits[syb.length - 1];
		
		for(int i = syb.length - 2; i > 0; -- i) {
			r = t / bits[i];
			if(r != 0) {
				if(i % 2 == 0) {
					if(t / bits[i - 1] == 9) {
						result.append(syb[i - 1]);
						result.append(syb[i + 1]);
						i --;
					}else {
						result.append(syb[i]);
					}
				}else {
					if(t / bits[i] == 4) {
						result.append(syb[i]);
						result.append(syb[i + 1]);
					}else {
						for(int j = 0; j < t / bits[i]; ++ j) {
							result.append(syb[i]);
						}
					}
				}
			}
			t = t % bits[i];
		}
		return result.toString();
	}
}

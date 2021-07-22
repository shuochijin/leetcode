package leetcode.from1to1000.from001to100.from01to10;

public class SixZigZagConversion {
	
	public static void main(String[] args) {
		SixZigZagConversion o = new SixZigZagConversion();
		System.out.println(o.convert("PAYPALISHIRING", 2));
//		System.out.println(o.convert("PAYPALISHIRING", 3));
//		System.out.println(o.convert("PAYPALISHIRING", 4));
		System.out.println(o.convert("AB", 2));
	}
	
	public String convert(String s, int numRows) {
		String result;
		if(numRows == 1) {
			return s;
		}
		int loopSize = numRows + numRows - 2;
		int C = s.length() / (loopSize);
		if(s.length() % loopSize != 0) {
			C++;
		}
//		System.out.println(C + ":" + loopSize + ":" + s.length());
		
		StringBuilder sb = new StringBuilder(s);
		for(int i = loopSize - s.length() % loopSize; i > 0 && i < loopSize; -- i) {
			sb.append(" ");
		}
		s = sb.toString();
		char[] chars = new char[s.length()];
		
		for(int i = 0; i < C; ++ i) {
			chars[i] = s.charAt(loopSize * i);
			chars[s.length() - C + i] = s.charAt(loopSize * i + numRows - 1);
//			System.out.println("f:" + i + ":" + (loopSize * i));
//			System.out.println("t:" + (s.length() - C + i) + ":" + (loopSize * i + numRows - 1));
			for(int j = 1; j < numRows - 1; ++ j) {
				chars[C + (C * 2) * (j - 1) + 2 * i ] = s.charAt(i * loopSize + j);
//				System.out.println((C + (C * 2) * (j - 1) + 2 * i) + ":" + (i * loopSize + j));
			}
			for(int j = numRows + 1; j <= loopSize; ++ j) {
				chars[C + (C * 2) * (loopSize - j) + 2 * i + 1] = s.charAt(i * loopSize + j - 1);
//				System.out.println((C + (C * 2) * (loopSize - j) + 2 * i + 1) + ":" + (i * loopSize + j - 1));
			}
		}
		
		result = new String(chars);
//		System.out.println(chars);
		
		String[] ss = result.split(" ");
		
		sb = new StringBuilder();
		for(int i = 0; i < ss.length; ++ i) {
			sb.append(ss[i]);
//			System.out.println(ss[i]);
		}
		result = sb.toString();
		return result;
	}
}

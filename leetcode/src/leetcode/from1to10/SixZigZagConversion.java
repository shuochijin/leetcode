package leetcode.from1to10;

public class SixZigZagConversion {
	
	public static void main(String[] args) {
		SixZigZagConversion o = new SixZigZagConversion();
		System.out.println(o.convert("PAYPALISHIRING", 3));
	}
	
	public String convert(String s, int numRows) {
		StringBuilder sb = new StringBuilder(s);
		for(int i = numRows - s.length() % numRows; i > 0 && i < numRows; -- i) {
			sb.append(" ");
		}
		s = sb.toString();
		
		String result;
		char[] chars = new char[s.length()];
		
		int loopSize = numRows + numRows - 2;
		int C = s.length() / (loopSize);
		
		for(int i = 0; i < C; ++ i) {
			chars[i] = s.charAt(numRows * i + 1);
			chars[s.length() - numRows + i] = s.charAt(loopSize * i + numRows);
			for(int j = 1; j < numRows - 1; ++ j) {
				chars[C + (C * 2) * (j - 1) + 2 * i ] = s.charAt(i * loopSize + j);
			}
			for(int j = numRows + 1; j <= loopSize; ++ j) {
				chars[C + (C * 2) * (loopSize - j) + 2 * i + 1] = s.charAt(i * loopSize + j);
			}
		}
		
		result = new String(chars);
		System.out.println(chars);
		
		String[] ss = result.split(" ");
		
		sb = new StringBuilder();
		for(int i = 0; i < ss.length; ++ i) {
			sb.append(ss[i]);
			System.out.println(ss[i]);
		}
		result = sb.toString();
		return result;
	}
}

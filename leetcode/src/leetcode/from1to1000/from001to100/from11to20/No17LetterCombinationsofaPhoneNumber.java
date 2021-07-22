package leetcode.from1to1000.from001to100.from11to20;

import java.util.ArrayList;
import java.util.List;

public class No17LetterCombinationsofaPhoneNumber {
	
	public static void main(String[] args) {
		No17LetterCombinationsofaPhoneNumber n = new No17LetterCombinationsofaPhoneNumber();
		System.out.println(n.letterCombinations("23"));
		System.out.println(n.letterCombinations(""));
	}
	
	public List<String> letterCombinations(String digits) {
		char[][] syb = new char[][] {
			{},
			{},
			{'a', 'b' ,'c'},
			{'d', 'e' ,'f'},
			{'g', 'h' ,'i'},
			{'j', 'k' ,'l'},
			{'m', 'n' ,'o'},
			{'p', 'q' ,'r', 's'},
			{'t', 'u' ,'v'},
			{'w', 'x' ,'y', 'z'}
		};
		List<String> result = new ArrayList<String>();
		if(digits.length() == 0) {
			return result;
		}
		int[] stackint = new int[digits.length()];
		int stacksize = 0;
		
		
		char[] buffer = new char[digits.length()];
		for(int i = 0; i < syb[digits.charAt(stacksize) - '0'].length;) {
			buffer[stacksize] = syb[digits.charAt(stacksize) - '0'][i];
			stackint[stacksize] = i;
			stacksize ++;
			i = 0;
			if(digits.length() == stacksize) {
				StringBuilder sb = new StringBuilder();
				for(int k = 0; k < buffer.length; ++ k) {
					sb.append(buffer[k]);
				}
				result.add(sb.toString());
				i = stackint[-- stacksize] + 1;
				while(stacksize > 0
						&& i == syb[digits.charAt(stacksize) - '0'].length) {
					i = stackint[-- stacksize] + 1;
				}
			}
			
		}
		
		return result;
	}
}

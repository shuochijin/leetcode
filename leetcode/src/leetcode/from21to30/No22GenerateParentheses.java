package leetcode.from21to30;

import java.util.ArrayList;
import java.util.List;

public class No22GenerateParentheses {
	
	public static void main(String[] args) {
		No22GenerateParentheses n = new No22GenerateParentheses();
		System.out.println(n.generateParenthesis(3));
	}
	
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();

		char[] seq = new char[n*2];
		
		for(int i = 0; i < n; ++ i) {
			seq[i] = '(';
			seq[n + i] = ')';
		}
		
		int l = 0;
		int r = 0;
		int index = seq.length - 1;
		
		while(index >= 0) {
			if(index == seq.length - 1) {
				result.add(new String(seq));
				a:while(index >= 0) {
					if(seq[index] == ')') {
						r ++;
						index --;
					} else {
						l ++;
						index --;
					}
					if(index >= 0 && seq[index] == '(' && l + 1 <= r - 1) {
						seq[index] = ')';
						l ++;
						r --;
						break a;
					}
				}
			} else {
				for(int i = 0; i < l; ++ i) {
					seq[++ index] = '(';
				}
				for(int i = 0; i < r; ++ i) {
					seq[++ index] = ')';
				}
				l = 0;
				r = 0;
			}
		}
		
		return result;
	}
}

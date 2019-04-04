package leetcode.from1to10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No10RegularExpressionMatching2 {
	
	public static void main(String[] args) {
		No10RegularExpressionMatching2 n = new No10RegularExpressionMatching2();
		String s = "01234567";
		System.out.println(s.substring(1, 2));
		System.out.println(n.isMatch("aa", "a"));
		System.out.println(n.isMatch("aa", "a*"));
		System.out.println(n.isMatch("aa", ".*"));
	}
	
	public boolean isMatch(String s, String p) {
		boolean result = false;
		List<String> array = new ArrayList<String>();
		char[] pchars = p.toCharArray();
		for(int i = 0; i < pchars.length; ++ i) {
			if(pchars[i] == '*') {
				char temp = pchars[i];
				pchars[i] = pchars[i - 1];
				pchars[i - 1] = temp;
			}
		}
		p = new String(pchars);
		for(int front = 0, tail = front, i = 0; i < p.length(); ++ i) {
			if(p.charAt(i) == '*') {
				if(front != tail) {
					array.add(p.substring(front, tail));
				}
				front = i;
				tail = i + 2;
				array.add(p.substring(front, tail));
				front = i + 2;
				tail = front;
			}else {
				tail ++;
				if(tail == p.length()) {
					array.add(p.substring(front, tail));
				}
			}
		}
		return result;
	}
}

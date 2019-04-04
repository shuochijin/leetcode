package leetcode.from1to10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No10RegularExpressionMatching {
	
	public static void main(String[] args) {
		No10RegularExpressionMatching n = new No10RegularExpressionMatching();
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
		
		Stack<Integer> stack = new Stack<Integer>();
		int point = 0;
		for(int i = 0; i < array.size(); ++ i) {
			String node = array.get(i);
			if(node.equals("*.")) {
				if(stack.get(i) == null) {
					stack.add(point);
				}else {
					point = stack.pop();
					point ++;
					stack.push(point);
				}
			}else if(node.startsWith("*")) {
				char c = node.charAt(1);
				point = stack.pop();
				point ++;
				if(s.charAt(point) != c) {
					break;
				}
				stack.push(point);
			}else {
				
			}
			if(point == pchars.length) {
				break;
			}
			if(i == array.size() - 1 && point == pchars.length) {
				result = true;
			}
		}
		
		return result;
	}
}

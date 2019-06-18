package leetcode.from31to40;

import java.util.Stack;

public class No32LongestValidParentheses {
	
	public static void main(String[] args) {
		No32LongestValidParentheses n = new No32LongestValidParentheses();
		System.out.println(n.longestValidParentheses("()(()"));
	}
	
	public int longestValidParentheses(String s) {
		int max = 0;
		int tmp = 0;
		Stack<Character> stack = new Stack<Character>();
		char c;
		for(int i = 0; i < s.length(); ++ i) {
			c = s.charAt(i);
			if(c == '(') {
				stack.push(c);
			} else {
				if(stack.size() > 0 && stack.peek() == '(') {
					tmp += 2;
					stack.pop();
				} else {
					if(max < tmp) {
						max = tmp;
					}
					tmp = 0;
					stack.push(c);
				}
			}
		}
		if(max < tmp) {
			max = tmp;
		}
		return max;
	}
}

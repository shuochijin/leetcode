package leetcode.from31to40;

import java.util.Arrays;
import java.util.Stack;

public class No32LongestValidParentheses {
	
	public static void main(String[] args) {
		No32LongestValidParentheses n = new No32LongestValidParentheses();
		System.out.println(n.longestValidParentheses("(()"));
	}
	
	public int longestValidParentheses(String s) {
		int result = 0;
		boolean[] flags = new boolean[s.length()];
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < s.length(); ++ i) {
			if(s.charAt(i) =='(') {
				stack.push(i);
			} else {
				if(stack.size() > 0 && s.charAt(stack.peek()) == '(') {
					flags[stack.peek()] = true;
					flags[i] = true;
					stack.pop();
				} else {
					stack.push(i);
				}
			}
		}
		
		int temp = 0;
		for(int i = 0; i < flags.length; ++ i) {
			if(flags[i]) {
				temp ++;
			} else {
				if(result < temp) {
					result = temp;
				}
				temp = 0;
			}
		}
		if(result < temp) {
			result = temp;
		}
		
		return result;
	}
	
}

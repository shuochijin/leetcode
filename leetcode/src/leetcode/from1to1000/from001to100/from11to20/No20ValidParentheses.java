package leetcode.from1to1000.from001to100.from11to20;

public class No20ValidParentheses {
	
	public static void main(String[] args) {
		No20ValidParentheses n = new No20ValidParentheses();
		System.out.println(n.isValid("()"));
		System.out.println(n.isValid("()[]{}"));
		System.out.println(n.isValid("(]"));
		System.out.println(n.isValid("([)]"));
		System.out.println(n.isValid("{[]}"));
		System.out.println(n.isValid("}"));
	}
	
	public boolean isValid(String s) {
		boolean result = true;
		
		char[] stack = new char[s.length()];
		int p = 0;
		
		for(int i = 0; i < s.length(); ++ i) {
			switch(s.charAt(i)) {
			case '{':
			case '[':
			case '(':
				stack[p ++] = s.charAt(i);
				break;
			case '}':
				if(p == 0 || stack[-- p] != '{') {
					result = false;
				}
				break;
			case ']':
				if(p == 0 || stack[-- p] != '[') {
					result = false;
				}
				break;
			case ')':
				if(p == 0 || stack[-- p] != '(') {
					result = false;
				}
				break;
			}
		}
		if(p != 0) {
			result = false;
		}
		
		return result;
	}
	
}

package leetcode.from1to1000.from001to100.from51to100;

import java.util.Stack;

public class _70EClimbingStairs {
	
	public static void main(String[] args) {
		_70EClimbingStairs n = new _70EClimbingStairs();
		System.out.println(n.climbStairs2(2));
		System.out.println(n.climbStairs2(3));
		System.out.println(n.climbStairs3(4));
		System.out.println(n.climbStairs3(10));
		System.out.println(n.climbStairs3(35));
	}
	
	public int climbStairs(int n) {
		int result = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		int sum = 0;
		int step = 0;
		
		while(!(step == 2 && stack.size() == 0)) {
			if(sum < n) {
				step ++;
				sum += step;
				stack.push(step);
				step = 0;
			} else {
				if(sum == n) {
					result ++;
					int s = 0;
					for(int i = 0; i < stack.size(); ++ i) {
						s += stack.get(i);
						System.out.print(stack.get(i));
					}
					System.out.println(" " + s);
				}
				do {
					step = stack.pop();
					sum -= step;
				}while(step == 2 && stack.size() != 0);
			}
		}
		
		return result;
	}
	
	public int climbStairs2(int n) {
		long result = 0;
		
		long temp;
		for(int i = 0; 2 * i <= n; ++ i) {
			temp = 1;
			for(int j = 1; j <= i; ++ j) {
				temp = temp * ((long)n - i - j + 1) / j;
			}
			result += temp;
		}
		
		return (int)result;
	}
	
	public int climbStairs3(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		int dp1 = 1;
		int dp2 = 2;
		
		for(int i = 3; i <= n; ++ i) {
			dp2 += dp1;
			dp1 = dp2 - dp1;
		}
		
		return dp2;
	}
	
}

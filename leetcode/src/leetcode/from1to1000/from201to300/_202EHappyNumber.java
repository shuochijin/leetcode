package leetcode.from1to1000.from201to300;

public class _202EHappyNumber {
	
	public static void main(String[] args) {
		System.out.println(isHappy(19));
		System.out.println(isHappy(2));
	}
	
	public static boolean isHappy(int n) {
		boolean result = true;
		int[] loopFlag = new int[1000];
		for(int i = 0; i < loopFlag.length; ++ i) {
			loopFlag[i] = 0;
		}
		
		int tmp;
		int sum;
		int digit;
		while(n != 1) {
			tmp = n;
			sum = 0;
			while(tmp != 0) {
				digit = tmp % 10;
				sum += digit * digit;
				tmp /= 10;
			}
			n = sum;
			if(loopFlag[sum] != 0) {
				return false;
			} else {
				loopFlag[sum] = 1;
			}
		}
		
		return true;
	}
}

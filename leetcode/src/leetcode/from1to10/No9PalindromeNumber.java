package leetcode.from1to10;

public class No9PalindromeNumber {
	
	public static void main(String[] args) {
		No9PalindromeNumber n = new No9PalindromeNumber();
		System.out.println(n.isPalindrome(121));
		System.out.println(n.isPalindrome(-121));
	}
	
	public boolean isPalindrome(int x) {
		if(x < 0) {
			return false;
		}
		int temp = x;
		int convert = 0;
		while(temp != 0) {
			convert =10 * convert + temp % 10;
			temp /= 10;
		}
		if(convert == x) {
			return true;
		}else {
			return false;
		}
	}
	
}

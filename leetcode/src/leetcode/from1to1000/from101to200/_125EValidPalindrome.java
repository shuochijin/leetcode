package leetcode.from1to1000.from101to200;

public class _125EValidPalindrome {
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("ab2a"));
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("0P"));
		System.out.println(isPalindrome2("ab2a"));
		System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome2("0P"));
	}

	public static boolean isPalindrome(String s) {
		int head = 0, tail = s.length() - 1;
		char hc, tc;
		int gap = 'a' - 'A';
		while(head < tail){
			hc = s.charAt(head);
			if(!(hc >= 'a' && hc <='z')
					&& !(hc >= 'A' && hc <='Z')
					&& !(hc <= '9' && hc >= '0')) {
				head ++;
				continue;
			}
			tc = s.charAt(tail);
			if(!(tc >= 'a' && tc <='z')
					&& !(tc >= 'A' && tc <='Z')
					&& !(tc <= '9' && tc >= '0')) {
				tail --;
				continue;
			}
			if((((hc <= '9' && hc >= '0') || (tc <= '9' && tc >= '0')) && hc != tc)
					|| (hc >= 'A' && tc >= 'A' && (hc != tc && (hc - tc) != gap && (tc - hc) != gap))) {
				return false;
			}
			head ++;
			tail --;
		}
		return true;
	}

	public static boolean isPalindrome2(String s) {
		int head = 0, tail = s.length() - 1;
		char hc, tc;
		while(head < tail){
			hc = s.charAt(head);
			if(!(hc >= 'a' && hc <='z')
					&& !(hc >= 'A' && hc <='Z')
					&& !(hc <= '9' && hc >= '0')) {
				head ++;
				continue;
			}
			tc = s.charAt(tail);
			if(!(tc >= 'a' && tc <='z')
					&& !(tc >= 'A' && tc <='Z')
					&& !(tc <= '9' && tc >= '0')) {
				tail --;
				continue;
			}
			if(hc >= 'a' && hc <= 'z') {
				hc -= 32;
			}
			if(tc >= 'a' && tc <= 'z') {
				tc -= 32;
			}
			if((((hc <= '9' && hc >= '0') || (tc <= '9' && tc >= '0')) && hc != tc)
					|| (hc >= 'A' && tc >= 'A' && hc != tc)) {
				return false;
			}
			head ++;
			tail --;
		}
		return true;
	}
}

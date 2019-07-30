package leetcode.from51to100;

public class NoE58LengthofLastWord {
	
	public static void main(String[] args) {
		NoE58LengthofLastWord n = new NoE58LengthofLastWord();
		System.out.println(n.lengthOfLastWord("a "));
		System.out.println(n.lengthOfLastWord("Hello World"));
	}
	
	public int lengthOfLastWord(String s) {
		int result = 0;
		
		boolean flag = false;
		for(int i = s.length() - 1; i >= 0; -- i) {
			if(!flag && s.charAt(i) != ' ') {
				flag = true;
				result = 1;
			} else if(flag && s.charAt(i) != ' ') {
				result ++;
			} else if(flag && s.charAt(i) == ' '){
				break;
			}
		}
		
		return result;
	}
	
}

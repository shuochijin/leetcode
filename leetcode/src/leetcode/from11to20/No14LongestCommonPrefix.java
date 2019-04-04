package leetcode.from11to20;

public class No14LongestCommonPrefix {
	
	public static void main(String[] args) {
		No14LongestCommonPrefix n = new No14LongestCommonPrefix();
//		System.out.println(n.longestCommonPrefix(new String[]{"flower","flow","flight"}));
//		System.out.println(n.longestCommonPrefix(new String[]{"dog","racecar","car"}));
		System.out.println(n.longestCommonPrefix2(new String[]{"flower","flow","flight"}));
	}
	
	public String longestCommonPrefix(String[] strs) {
		String result = "";
		if(strs.length == 0) {
			return "";
		}
		char temp;
		int index = 0;
		a:while(true) {
			temp = '\0';
			for(int i = 0; i < strs.length; ++ i) {
				if(strs[i] == null || strs[i].length() <= index) {
					break a;
				}else {
					if(temp == '\0') {
						temp = strs[i].charAt(index);
					}else if(strs[i].charAt(index) != temp) {
						break a;
					}
				}
			}
			result = result + strs[0].charAt(index);
			index ++;
		}
		return result;
	}
	
	public String longestCommonPrefix2(String[] strs) {
		if(strs.length == 0) {
			return "";
		}
		String result = "";
		char temp;
		a:for(int i = 0; i < strs[0].length(); ++ i) {
			temp = '\0';
			for(int j = 0; j < strs.length; ++ j) {
				if(strs[j] == null || strs[j].length() <= i) {
					break a;
				}else {
					if(temp == '\0') {
						temp = strs[j].charAt(i);
					}else if(strs[j].charAt(i) != temp) {
						break a;
					}
				}
			}
			if(strs[0].length() > i) {
				result = result + strs[0].charAt(i);
			}
		}
		return result;
	}
}

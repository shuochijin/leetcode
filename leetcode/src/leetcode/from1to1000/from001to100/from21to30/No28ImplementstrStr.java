package leetcode.from1to1000.from001to100.from21to30;

public class No28ImplementstrStr {
	
	public static void main(String[] args) {
		No28ImplementstrStr n = new No28ImplementstrStr();
		System.out.println(n.strStr("", ""));
	}
	
	public int strStr(String haystack, String needle) {
		return haystack.indexOf(needle);
	}
}

package leetcode.from1to1000.from101to200;

import java.util.HashMap;
import java.util.Map;

public class _171EExcelSheetColumnNumber {
	public static void main(String[] args) {
		System.out.println(titleToNumber("A"));
		System.out.println(titleToNumber("Z"));
		System.out.println(titleToNumber("AB"));
		System.out.println(titleToNumber("ZY"));
		System.out.println(titleToNumber("FXSHRXW"));
	}
	
	public static int titleToNumber(String columnTitle) {
		
		int digits = 26;
		int temp = 0;
		int i = 0;
		for(; i < columnTitle.length() - 1; ++ i) {
			temp = (columnTitle.charAt(i) - 'A' + 1) + temp * digits;
		}
		temp =  temp * digits + columnTitle.charAt(i) - 'A' + 1;
		return temp;
	}
}

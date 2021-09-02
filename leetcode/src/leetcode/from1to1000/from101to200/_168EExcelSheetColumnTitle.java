package leetcode.from1to1000.from101to200;

public class _168EExcelSheetColumnTitle {
	
	public static void main(String[] args) {
		System.out.println(convertToTitle(28));
	}
	//����һ���������λ27���ƣ���λ26���ơ�����������������������
	public static String convertToTitle(int columnNumber) {
		if(columnNumber == 1) {
			return "A";
		}
		StringBuffer sb = new StringBuffer();
		
		while(columnNumber > 0) {
			sb.append((char)(columnNumber % 27 + 'A'));
			columnNumber /= 27;
		}
		return sb.reverse().toString();
	}
}

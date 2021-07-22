package leetcode.from1to1000.from001to100.from31to40;

public class No38CountandSay {
	
	public static void main(String[] args) {
		No38CountandSay n = new No38CountandSay();
		//System.out.println(n.countAndSay(1));
		//System.out.println(n.countAndSay(2));
		System.out.println(n.countAndSay(3));
		System.out.println(n.countAndSay(4));
		System.out.println(n.countAndSay(5));
	}
	
	public String countAndSay(int n) {
		StringBuffer sb = new StringBuffer("1");
		String v = "1";
		for(int i = 1; i < n; ++ i) {
			sb = new StringBuffer();
			char pre = v.charAt(0);
			int count = 1;
			for(int j = 1; j < v.length(); ++ j) {
				if(v.charAt(j) == pre) {
					count ++;
				} else {
					sb.append(count + "" + pre);
					pre = v.charAt(j);
					count = 0;
					-- j;
				}
			}
			if(count > 0) {
				sb.append(count + "" + pre);
			}
			v = sb.toString();
		}
		
		return sb.toString();
	}
}

package leetcode.from31to40;

public class No38CountandSay {
	
	public static void main(String[] args) {
		No38CountandSay n = new No38CountandSay();
		System.out.println(n.countAndSay(1));
		System.out.println(n.countAndSay(2));
		System.out.println(n.countAndSay(3));
		System.out.println(n.countAndSay(4));
		System.out.println(n.countAndSay(5));
	}
	
	public String countAndSay(int n) {
		StringBuilder result = new StringBuilder();
		result.append(1);
		
		int seq;
		int digit;
		int temp;
		int count;
		while(n > 1) {
			seq = Integer.parseInt(result.toString());
			result = new StringBuilder();
			digit = seq % 10;
			count = 0;
			while(seq > 0) {
				temp = seq % 10;
				seq = seq / 10;
				if(digit == temp && seq > 0) {
					count ++;
				} else {
					if(digit == temp && seq == 0) {
						count ++;
						result.append(digit + "" + count);
					} else {
						result.append(digit + "" + count);
						count = 1;
						digit = temp;
					}
				}
			}
			result = result.reverse();
			n --;
		}
		
		return result.reverse().toString();
	}
}

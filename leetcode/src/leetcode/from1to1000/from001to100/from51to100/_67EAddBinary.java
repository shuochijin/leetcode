package leetcode.from1to1000.from001to100.from51to100;

public class _67EAddBinary {
	
	public static void main(String[] args) {
		_67EAddBinary n = new _67EAddBinary();
		System.out.println(n.addBinary("1010", "1011"));
	}
	
	public String addBinary(String a, String b) {
		StringBuffer sb = new StringBuffer();
		
		int carry = 0;
		int ac;
		int bc;
		for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; --i, --j) {
			if(i >= 0) {
				ac = a.charAt(i) - '0';
			} else {
				ac = 0;
			}
			if(j >= 0) {
				bc = b.charAt(j) - '0';
			} else {
				bc = 0;
			}
			
			sb.append((ac + bc + carry) % 2);
			carry = (ac + bc + carry) / 2;
		}
		if(carry != 0) {
			sb.append(carry);
		}
		
		sb.reverse();
		
		return sb.toString();
	}
	
}

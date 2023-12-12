package contest.weekly.no313;

public class No6192NumberofCommonFactors {
	
	public static void main(String[] args) {
		No6192NumberofCommonFactors o = new No6192NumberofCommonFactors();
		System.out.println(o.commonFactors(6, 8));
		System.out.println(o.commonFactors(14, 21));
		System.out.println(o.commonFactors(3, 7));
		System.out.println(o.commonFactors(6, 12));
	}
	
	public int commonFactors(int a, int b) {
		int result = 0;
		int min = 1;
		if(a < b) {
			min = a;
		} else {
			min = b;
		}
		for(int i = 1; i <= min; ++ i) {
			if(a % i == 0 && b % i == 0) {
				result ++;
			}
		}
		
		return result;
	}
}

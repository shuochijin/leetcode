package leetcode.from1to1000.from001to100.from51to100;

public class _69ESqrtx {
	
	public static void main(String[] args) {
		_69ESqrtx n = new _69ESqrtx();
		System.out.println(n.mySqrt(2147483647));
		System.out.println(n.mySqrt(2147395599));
		System.out.println(n.mySqrt(1));
		System.out.println(n.mySqrt(4));
		System.out.println(n.mySqrt(8));
	}
	
	public int mySqrt(int x) {
		long front = 0;
		long tail = ((long)x + 1) / 2;
		long temp;
		while(tail > front) {
			temp = (tail + front + 1) / 2;
			if(temp * temp > x) {
				tail = temp - 1;
			} else if(temp * temp < x) {
				front = temp;
			} else {
				return (int)temp;
			}
		}
		
		
		return (int)front;
	}
}

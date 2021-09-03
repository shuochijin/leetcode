package leetcode.from1to1000.from201to300;

public class _205EIsomorphicStrings {
	
	public static void main(String[] args) {
		System.out.println(isIsomorphic("",""));
		System.out.println(isIsomorphic("egg","add"));
		System.out.println(isIsomorphic("paper","title"));
		System.out.println(isIsomorphic("a","s"));
		System.out.println(isIsomorphic("foo","bar"));
	}
	
	public static boolean isIsomorphic(String s, String t) {
		boolean flag = true;
		
		int[] index = new int[128];
		int[] seq = new int[s.length()];
		int count = 0;
		for(int i = 0; i < s.length(); ++ i) {
			if(index[s.charAt(i)] == 0) {
				count ++;
				index[s.charAt(i)] = count;
			}
			seq[i] = index[s.charAt(i)];
		}
		index = new int[128];
		count = 0;
		for(int i = 0; i < t.length(); ++ i) {
			if(index[t.charAt(i)] == 0) {
				count ++;
				index[t.charAt(i)] = count;
			}
			if(seq[i] != index[t.charAt(i)]) {
				return false;
			}
		}
		return flag;
	}
}

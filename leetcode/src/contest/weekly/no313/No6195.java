package contest.weekly.no313;

public class No6195 {
	
	public static void main(String[] args) {
		int i = 3, j = 4;
		System.out.println(deleteString("abcabcdabc"));
		System.out.println(deleteString("aaabaab"));
		System.out.println(deleteString("aaaaa"));
	}
	
    public static int deleteString(String s) {
    	int result = 0;
    	
    	StringBuffer sb = new StringBuffer();
    	sb.append(s);
    	
    	while(sb.length() > 0) {
    		s = sb.toString();
    		System.out.println(s);
    		b:for(int i = 0; i < s.length(); ++ i) {
    			int j = 1, k = 0;
    			boolean flag = false;
    			a:for(j = 1; i + 2 * j <= s.length(); ++ j) {
    				flag = false;
    				for(k = 0; k < j; ++ k) {
    					if(s.charAt(i + k) != s.charAt(i + j + k)) {
    						continue a;
    					}
    				}
    				flag = true;
    				break a;
    			}
    			if(flag) {
    				sb.delete(0, sb.length());
    				sb.append(s.substring(0, i));
    				sb.append(s.substring(i + j, s.length()));
    				break b;
    			} else {
    				sb.delete(0, sb.length());
    			}
    		}
    		result ++;
    	}
    	return result;
    }

}

package contest.weekly.no313;

import java.util.ArrayList;
import java.util.List;

public class No6194MinimizeXOR {
	
	public static void main(String[] args) {
		System.out.println(minimizeXor(3, 5));
		System.out.println(minimizeXor(1, 12));
	}
	
    public static int minimizeXor(int num1, int num2) {
        int result = 0;
        
        int count0 = 0;
        int count1 = 0;
        while(num2 > 0) {
        	if(num2 % 2 == 0) {
        		count0 ++;
        	} else {
        		count1 ++;
        	}
        	num2 /= 2;
        }
        
        List<Integer> num1List = new ArrayList<Integer>();
        while(num1 > 0) {
        	if(num1 % 2 == 0) {
        		num1List.add(0);
        	} else {
        		num1List.add(1);
        	}
        	num1 /= 2;
        }
        
        if(count0 + count1 > num1List.size()) {
        	while(num1List.size() != count0 + count1) {
        		num1List.add(0);
        	}
        } else {
        	count0 += num1List.size() - count0 - count1;
        }
        
        List<Integer> rL = new ArrayList<Integer>();
        a:for(int i = 0; i < num1List.size(); ++ i) {
        	if(num1List.get(num1List.size() - 1 - i) == 0) {
        		if(count0 > 0) {
        			rL.add(0);
        			count0 --;
        		} else {
        			for(int j = 0; j < count1; ++ j) {
        				rL.add(1);
        			}
    				break a;
        		}
        	} else {
        		if(count1 > 0) {
        			rL.add(1);
        			count1 --;
        		} else {
        			for(int j = 0; j < count0; ++ j) {
        				rL.add(0);
        			}
    				break a;
        		}
        	}
        }
        
        for(int i = 0; i < rL.size(); ++ i) {
        	result = 2 * result + rL.get(i);
        }
        
        return result;
    }
}

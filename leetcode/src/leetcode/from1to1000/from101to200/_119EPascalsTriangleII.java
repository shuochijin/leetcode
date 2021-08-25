package leetcode.from1to1000.from101to200;

import java.util.ArrayList;
import java.util.List;

public class _119EPascalsTriangleII {
	
	public static void main(String[] args) {
		List<Integer> list = getRow(1);
		print(list);
		list = getRow(2);
		print(list);
		list = getRow(3);
		print(list);
	}
	
	public static void print(List<Integer> list) {
		for(int i = 0; i < list.size(); ++ i) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
    public static List<Integer> getRow(int rowIndex) {

        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(1);
        int left,right;
        for(int i = 0; i < rowIndex; ++ i) {
        	for(int j = tmp.size(); j >= 0; -- j) {
        		if(j != 0 && j != tmp.size()) {
        			left = tmp.get(j - 1);
        			right = tmp.get(j);
        			tmp.set(j, left + right);
        		} else if(j == 0) {
        			left = 0;
        			right = tmp.get(j);
        			tmp.set(j, left + right);
        		} else {
        			left = tmp.get(j - 1);
        			right = 0;
            		tmp.add(left + right);
        		}
        	}
        }
        return tmp;
    
    }
}

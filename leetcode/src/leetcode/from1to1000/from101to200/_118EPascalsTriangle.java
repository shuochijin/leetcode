package leetcode.from1to1000.from101to200;

import java.util.ArrayList;
import java.util.List;

public class _118EPascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(1);
        list.add(tmp);
        List<Integer> tmp2;
        int left,right;
        for(int i = 1; i < numRows; ++ i) {
        	tmp = list.get(i - 1);
        	tmp2 = new ArrayList<Integer>();
        	for(int j = 0; j <= tmp.size(); ++ j) {
        		if(j != 0 && j != tmp.size()) {
        			left = tmp.get(j - 1);
        			right = tmp.get(j);
        		} else if(j == 0) {
        			left = 0;
        			right = tmp.get(j);
        		} else {
        			left = tmp.get(j - 1);
        			right = 0;
        		}
        		tmp2.add(left + right);
        	}
        	list.add(tmp2);
        }
        return list;
    }
}

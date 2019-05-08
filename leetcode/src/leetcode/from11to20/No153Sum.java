package leetcode.from11to20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No153Sum {
	
	public static void main(String[] args) {
		int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
		Arrays.sort(nums);
		System.out.println(nums);
		No153Sum n = new No153Sum();
		System.out.println(n.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
		System.out.println(n.threeSum(new int[] {-1,0,1,2,-1,-4}));
		System.out.println(n.threeSum(new int[] {3,0,-2,-1,1,2}));
		System.out.println(n.threeSum(new int[] {1,2,-2,-1}));
		System.out.println(n.threeSum(new int[] {0,0,0,0,0}));
		System.out.println(n.threeSum(new int[] {-2,1,1,1,1}));
	}

	private List<List<Integer>> result;
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
               }
            }
        }
        return res;
    }
	
	public boolean checkAndSet(int i, int j, int k) {
		boolean flag = false;
		List<Integer> piece = createList(i, j, k);
		List<Integer> ele;
		for(int size = 0; size < result.size(); ++ size) {
			ele = result.get(size);
			if(ele.get(0) == piece.get(0)
					&& ele.get(1) == piece.get(1)
					&& ele.get(2) == piece.get(2)) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			result.add(piece);
		}
		return flag;
	}
	
	public List<Integer> createList(int i, int j, int k){
		List<Integer> list = new ArrayList<Integer>();
		if(i < j) {
			if(i < k) {
				list.add(i);
				if(j < k) {
					list.add(j);
					list.add(k);
				}else {
					list.add(k);
					list.add(j);
				}
			}else {
				list.add(k);
				list.add(i);
				list.add(j);
			}
		}else {
			if(i < k) {
				list.add(j);
				list.add(i);
				list.add(k);
			}else {
				if(j < k) {
					list.add(j);
					list.add(k);
				}else {
					list.add(k);
					list.add(j);
				}
				list.add(i);
			}
		}
		return list;
	}
}

package leetcode.from1to1000.from101to200;

import java.util.ArrayList;
import java.util.LinkedList;

public class MinStack {
	
	public static void main(String[] args) {

		ArrayList<Integer> ss = new ArrayList<Integer>();
		ss.add(1);
		System.out.println(ss.get(0));
		
		MinStack s = new MinStack();
		s.push(-2);
		s.push(0);
		s.push(3);
		s.pop();
		System.out.println(s.top());
		System.out.println(s.getMin());
	}
	
	public LinkedList<Integer> s = new LinkedList<Integer>();
	
	public int min = 0;
	
	public boolean needReMin = true;
	
    public MinStack() {
    }
    
    public void push(int val) {
    	s.add(val);
    	needReMin = true;
    }
    
    public void pop() {
        s.remove(s.size() - 1);
        needReMin = true;
    }
    
    public int top() {
        return s.get(s.size() - 1);
    }
    
    public int getMin() {
    	if(needReMin) {
        	int tmp = s.get(0);
        	for(int i = 0; i < s.size(); ++ i) {
        		if(tmp > s.get(i)) {
        			tmp = s.get(i);
        		}
        	}
        	min = tmp;
        	needReMin = false;
    	}
        return min;
    }
}

class MinStack2{
	
	public static void main(String[] args) {

		ArrayList<Integer> ss = new ArrayList<Integer>();
		ss.add(1);
		System.out.println(ss.get(0));
		
		MinStack s = new MinStack();
		s.push(-2);
		s.push(0);
		s.push(3);
		s.pop();
		System.out.println(s.top());
		System.out.println(s.getMin());
	}
	
	public LinkedList<int[]> s = new LinkedList<int[]>();
	
    public MinStack2() {
    }
    
    public void push(int val) {
    	s.add(new int[]{val, Math.min(val, s.size() != 0 ? s.get(s.size() - 1)[1] : val)});
    }
    
    public void pop() {
        s.remove(s.size() - 1);
    }
    
    public int top() {
        return s.get(s.size() - 1)[0];
    }
    
    public int getMin() {
        return s.get(s.size() - 1)[1];
    }
}

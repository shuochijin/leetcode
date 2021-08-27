package leetcode.from1to1000.from101to200;

public class _122EBestTimetoBuyandSellStockII {
	
	public static void main(String[] args) {
		int[] i = {7,1,5,3,6,4};
		System.out.println(maxProfit(i));
		int[] i2 = {1,2,3,4,5};
		System.out.println(maxProfit(i2));
		int[] i3 = {2,4,1};
		System.out.println(maxProfit(i3));
	}
	
	public static int maxProfit(int[] prices) {
		int result = 0;
		
		int min = prices[0],tmp = 0;
		
		for(int i = 0; i < prices.length; ++ i) {
			if(prices[i] <= min) {
				min = prices[i];
			} else {
				if(prices[i] - min >= tmp) {
					tmp = prices[i] - min;
					if(i == prices.length - 1) {
						result += tmp;
					}
				} else {
					result += tmp;
					tmp = 0;
					min = prices[i];
				}
			}
		}
		return result;
	}
	
	public static int maxProfit2(int[] prices) {
		int result = 0;
		
		int i = 1;
		
		while(i < prices.length) {
			if(prices[i - 1] < prices[i]) {
				result += prices[i] - prices[i - 1];
			}
			++ i;
		}
		return result;
	}
}
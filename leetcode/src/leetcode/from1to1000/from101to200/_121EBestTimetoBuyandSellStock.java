package leetcode.from1to1000.from101to200;

public class _121EBestTimetoBuyandSellStock {
	
	public static void main(String[] args) {
		
	}
	
	public static int maxProfit(int[] prices) {
		int result = 0;
		int min = prices[0],max = prices[0];
		for(int i = 0; i < prices.length; ++ i) {
			if(prices[i] < min) {
				min = prices[i];
				max = min;
			} else if(prices[i] > max) {
				max = prices[i];
			}
			if(max - min > result) {
				result = max - min;
			}
		}
		return result;
	}
	
	public static int maxProfit2(int[] prices) {
		int result = 0;
		int min = prices[0];
		for(int i = 0; i < prices.length; ++ i) {
			if(prices[i] < min) {
				min = prices[i];
			} else if(prices[i] - min > result) {
				result = prices[i] - min;
			}
		}
		return result;
	}
}

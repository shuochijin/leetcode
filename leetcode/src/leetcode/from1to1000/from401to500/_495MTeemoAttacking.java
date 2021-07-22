package leetcode.from1to1000.from401to500;

public class _495MTeemoAttacking {
	
	public static void main(String[] args) {
		_495MTeemoAttacking n = new _495MTeemoAttacking();
		System.out.println(n.findPoisonedDuration(new int[] {1,4}, 2));
		System.out.println(n.findPoisonedDuration(new int[] {1,2}, 2));
	}
	
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		int last = 0;
		int sum = 0;
		for(int i = 0; i < timeSeries.length; ++ i) {
			if(timeSeries[i] >= last) {
				sum += duration;
			} else {
				sum += timeSeries[i] + duration - last;
			}
			last = timeSeries[i] + duration;
		}
		
		return sum;
	}
}

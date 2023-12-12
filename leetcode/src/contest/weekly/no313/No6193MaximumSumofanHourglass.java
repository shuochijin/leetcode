package contest.weekly.no313;

public class No6193MaximumSumofanHourglass {
	
	public static void main(String[] args) {
		System.out.println(maxSum(new int[][] {{6,2,1,3},{4,2,1,5},{9,2,8,7},{4,1,2,9}}));
	}
	
    public static int maxSum(int[][] grid) {
        int result = 0;
        
        int tmp;
        for(int i = 0; i < grid.length - 2; ++ i) {
        	for(int j = 0; j < grid[0].length - 2; ++ j) {
        		tmp = grid[i][j] + grid[i][j + 1] + grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
        		if(tmp > result) {
        			result = tmp;
        		}
        	}
        }
        
        return result;
    }
}

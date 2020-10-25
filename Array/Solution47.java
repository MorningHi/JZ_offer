/*
面试题47：礼物的最大价值
*/

class Solution47 {
    public int maxValue(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
		// 动态规划：f(i,j) = max(f(i-1,j),f(i,j-1)) + g(i,j)
		// 利用滚动数组优化空间复杂度
        int[] maxValue = new int[grid[0].length + 1];
        for(int i = 0; i < grid.length; i++){
            for(int j = 1; j <= grid[0].length; j++){
                maxValue[j] = Math.max(maxValue[j], maxValue[j - 1]) + grid[i][j - 1];
            }
        }
        return maxValue[grid[0].length];
    }
}
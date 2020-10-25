/*
面试题13：机器人的运动范围
*/

public class Solution13{
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold < 0 || rows <=0 || cols <= 0){
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];  // 访问记录
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }
    
    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited){
        int count = 0;
        if(check(threshold, rows, cols, row, col, visited)){ // 检查当前格子是否可以进入
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                      + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                      + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                      + movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }
    
    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited){
        if(row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && getDigitSum(row) + getDigitSum(col) <= threshold){
            return true;
        }
        return false;
    }
    
    // 求数位和
    private int getDigitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
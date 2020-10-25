public class Solution12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix.length <= 0 || rows < 1 || cols < 1 || str.length <= 0){
            return false;
        }
        
        boolean[] visited = new boolean[rows * cols]; // 用来标记矩阵的格子是否被访问过
        
        int pathLength = 0;  // 路径长度表示匹配到第几个字符
        //遍历每一个起点
        for(int i = 0; i < rows; i++){  
            for(int j = 0; j < cols; j++){
                if(hasPathCore(matrix, rows, i, cols, j, str, pathLength, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathCore(char[] matrix, int rows, int row, int cols, int col, char[] str, int pathLength, boolean[] visited){
        if(pathLength == str.length){
            return true;
        }
        boolean hasPath = false;
        // 如果当前字符匹配，则路径长度+1,标记visited中当前位置为true,并且递归地去寻找后面的路径
        if(row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[pathLength] && !visited[row * cols + col]){
            pathLength++;
            visited[row * cols + col] = true;
            hasPath = hasPathCore(matrix, rows, row+1, cols, col, str, pathLength, visited)
                      || hasPathCore(matrix, rows, row-1, cols, col, str, pathLength, visited)
                      || hasPathCore(matrix, rows, row, cols, col+1, str, pathLength, visited)
                      || hasPathCore(matrix, rows, row, cols, col-1, str, pathLength, visited);
            // 如果递归返回的是false（没有路径）则进行回溯
            if(!hasPath){
                pathLength--;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }
}
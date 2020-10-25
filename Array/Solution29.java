/*
面试题29：顺时针打印矩阵
*/

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        
        ArrayList<Integer> list = new ArrayList();
        int start = 0;
        // 每次打印一圈，start为左上角起始坐标
        while(matrix.length > start * 2 && matrix[0].length > start * 2){
            printMatrixInCircle(matrix, list, start);
            start++;
        }
        return list;
    }
    
    private void printMatrixInCircle(int[][] matrix, ArrayList list, int start){
        int rows = matrix.length, cols = matrix[0].length;
        int endX = cols - start - 1;
        int endY = rows - start - 1;
        // 从左向右打印一行
        for(int i = start; i <= endX; i++){
            list.add(matrix[start][i]);
        }
        //从上向下打印一列(如果这一圈大于一行)
        if(start < endY){
            for(int i = start + 1; i <= endY; i++){
                list.add(matrix[i][endX]);
            }
        }
        //从右向左打印一行(如果这一圈大于一行并且大于一列)
        if(start < endX && start < endY){
            for(int i = endX - 1; i >= start; i--){
                list.add(matrix[endY][i]);
            }
        }
        // 从下向上打印一列(如果这一圈大于三行两列)
        if(start < endX && start < endY - 1){
            for(int i = endY - 1; i > start; i--){
                list.add(matrix[i][start]);
            }
        }
    }
}
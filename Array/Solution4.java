/*
面试题4：二位数组中的查找
*/

public class Solution4 {
	
    public boolean Find(int target, int [][] array) {
        boolean found = false;
        
        int rows = array.length;
        int columns = array[0].length;
        if(array != null && rows > 0 && columns > 0){   // 空数组处理
            int row = rows - 1, col = 0;
            while(row >= 0 && col < columns){
                if(array[row][col] == target){   // 找到target
                    found = true;
                    break;
                }
                else if(array[row][col] < target){
                    col++;     // target大于本列最大值，则在右边的列找
                }
                else{
                    row--;   // 否则在本列上边的值里面找
                }
            }
        }
        return found;
    }
}
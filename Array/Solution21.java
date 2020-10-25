/*
面试题21调整数组顺序使奇数位于偶数前面
*/

public class Solution21 {
	
	// 左右指针交换的解法，会改变奇数内部偶数内部的相对位置
	public void reOrderArray1(int [] array) {
        if(array.length <= 1)  return;
        
        int left = 0, right = array.length - 1;
        while(left < right){
            // 每次找到最左边的偶数和最右边的奇数
            while(left < right && (array[left] & 0x01) == 1){
                left++;
            }
            while(right > left && (array[right] & 0x01) == 0){
                right--;
            }
            int temp = array[left];    // 交换最左边偶数和最右边奇数的位置
            array[left] = array[right];
            array[right] = temp;
        }
    }
	
	// 确保调整前后奇数和奇数，偶数和偶数的相对位置不变的解法
    public void reOrderArray2(int [] array) {
        if(array.length <= 1)  return;
        for(int i = 0; i < array.length; i++){
            if((array[i] & 0x01) == 1){  // 遍历到奇数值
                int value = array[i];  // 记录当前奇数值
                int currIndex = i;
                //将此奇数前面的偶数依次向后移动，这样确保相对位置不变
                while(currIndex > 0 && (array[currIndex - 1] & 0x01) == 0){
                    array[currIndex] = array[currIndex - 1];
                    currIndex--;
                }
                array[currIndex] = value;
            }
        }
    }
}
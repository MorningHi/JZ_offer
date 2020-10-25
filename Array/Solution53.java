/*
面试题53_1：数字在排序数组中出现的位置
*/

public class Solution53 {
	// 二分查找
    public int GetNumberOfK(int [] array , int k) {
        if(array.length <= 0 || k < array[0] || k > array[array.length - 1]){
            return 0;
        }
        int length = array.length;
        int left = getLeftK(array, 0, length - 1, k);
        int right = getRightK(array, 0, length - 1, k);
        return right - left + 1;
    }
    
    private int getLeftK(int[] array, int start, int end, int k){
        if(array[start] == k){
            return 0;
        }
        while(start < end){
            int middle = start + (end - start) / 2;
            if(array[middle] < k){
                start = middle + 1;
            }
            else{
                end = middle;
            }
        }
        return start;
    }
    
    private int getRightK(int[] array, int start, int end, int k){
        if(array[end] == k){
            return end;
        }
        while(start < end){
            int middle = start + (end - start + 1) / 2;
            if(array[middle] > k){
                end = middle - 1;
            }
            else{
                start = middle;
            }
        }
        return start;
    }
}
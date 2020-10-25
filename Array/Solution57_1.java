/*
面试题57_1：数组中和为s的两个数字
*/

import java.util.ArrayList;
public class Solution57_1 {
	
	// 由于数组是排好序的，前后指针逼近就可以
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        if(array.length <= 1){
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0, j = array.length - 1;
        while(i < j){
            if(array[i] + array[j] == sum){
                list.add(array[i]);
                list.add(array[j]);
                break;
            }
            else if(array[i] + array[j] > sum){
                j--;
            }
            else{
                i++;
            }
        }
        return list;
    }
}
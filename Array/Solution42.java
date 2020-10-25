/*
面试题42：连续子数组的最大和
*/

public class Solution42 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length <= 0){
            return 0;
        }
        int currSum = 0, currGreatestSum = array[0];
        for(int i = 0; i < array.length; i++){
            currSum += array[i];
            if(currSum < array[i]){ //如果累计到当前数的和都小于当前数，则重新从当前数开始累计
                currSum = array[i];
            }
            if(currGreatestSum < currSum){
                currGreatestSum = currSum;
            }
        }
        return currGreatestSum;
    }
}
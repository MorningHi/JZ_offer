/*
面试题39：数组中出现超过一半的数字
*/

public class Solution39 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length <= 0){
            return 0;
        }
        int result = array[0];
        int times = 0;
        for(int i = 0; i < array.length; i++){
            if(times == 0){
                result = array[i];
                times++;
            }
            else if(array[i] == result){
                times++;
            }
            else{
                times--;
            }
        }
        if(!CheckMoreThanHalf(array, result)){   // 判断result在数组中出现次数是否大于数组长度一半
            result = 0;
        }
        return result;
    }
    
    private boolean CheckMoreThanHalf(int[] array, int result){
        int times = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == result){
                times++;
            }
        }
        boolean isMoreThanHalf = false;
        if(times > array.length / 2){
            isMoreThanHalf = true;
        }
        return isMoreThanHalf;
    }
}
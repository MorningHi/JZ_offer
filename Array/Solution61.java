/*
面试提61: 扑克牌中的顺子
*/

import java.util.Arrays;
public class Solution61 {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length <= 4 || numbers.length > 13){
            return false;
        }
         
        Arrays.sort(numbers);
        int max = numbers[numbers.length - 1], min = 14;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] < min && numbers[i] > 0){
                min = numbers[i];
            }
            if(i > 1 && numbers[i] != 0 && numbers[i] == numbers[i - 1]){
                return false;
            }
        }
        if(max - min >= numbers.length){
            return false;
        }
        return true;
    }
}
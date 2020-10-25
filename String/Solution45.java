/*
面试题45：把数组排成最小的数
*/


import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length <= 0){
            return "";
        }
        // 需要先将numbers数组转化为Integer类型的数组，才能传给Arrays.sort()函数
        Integer[] nums = new Integer[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            nums[i] = numbers[i];
        }
        Arrays.sort(nums, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        String s = "";
        for(int i = 0; i < nums.length; i++){
            s += nums[i];
        }
        return s;
    }
}
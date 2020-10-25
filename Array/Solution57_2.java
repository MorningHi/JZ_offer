/*
面试题57_2：和为s的连续正数序列
*/

import java.util.ArrayList;
public class Solution57_2 {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       if(sum < 2){
           return new ArrayList<>();
       }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int left = 1, right = 2;
        int middle = (1 + sum) / 2;
        int currSum = 3;
        while(right <= middle){
            if(currSum == sum){
                ArrayList<Integer> ls = toList(left, right);
                list.add(ls);
            }
            while(currSum > sum && left < right){
                currSum -= left;
                left++;
                if(currSum == sum){
                    ArrayList<Integer> ls = toList(left, right);
                    list.add(ls);
                }
            }
            right++;
            currSum += right;
        }
        return list;
    }
    
    private ArrayList<Integer> toList(int left, int right){
        ArrayList<Integer> ls = new ArrayList<Integer>();
        while(left <= right){
            ls.add(left++);
        }
        return ls;
    }
}
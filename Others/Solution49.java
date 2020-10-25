/*
面试题49：丑数
*/

public class Solution49 {
    public int GetUglyNumber_Solution(int index) {
        if(index < 7){
            return index;  // 小于7的第i个丑数就是i
        }
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for(int i = 1; i < index; i++){
            uglyNumbers[i] = Math.min(Math.min(uglyNumbers[t2] * 2, uglyNumbers[t3] * 3), uglyNumbers[t5] * 5);
            if(uglyNumbers[t2] * 2 == uglyNumbers[i])  t2++;
            if(uglyNumbers[t3] * 3 == uglyNumbers[i])  t3++;
            if(uglyNumbers[t5] * 5 == uglyNumbers[i])  t5++;
        }
        return uglyNumbers[index - 1];
    }
}
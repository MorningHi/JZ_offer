/*
面试题15：二进制中1的个数
*/

public class Solution {
    public int NumberOf1(int n) {
        int num = 0;
        while(n != 0){
            num++;
            n = n & (n-1);   // n & (n-1)会将最右边的1变成0
        }
        return num;
    }
}
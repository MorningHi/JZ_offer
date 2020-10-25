/*
面试题65：不用加减乘除做加法
*/

class Solution65 {
    public int add(int a, int b) {
        int sum, carry;
        while(b != 0){
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
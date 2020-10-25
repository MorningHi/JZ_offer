/*
面试题44：数字序列中某一位的数字
*/

class Solution44 {
    public int findNthDigit(int n) {
        if(n < 10){
            return n;
        }
        int digits = 1; // 标记是几位数
        long base = 9;  
        while(n - base * digits > 0){
            n -= base * digits;
            digits++;
            base *= 10;
        }
        n--;  // 一位数有10个，前面只算了9个
        
        // 要找的数字位于time中的第res位
        int time = (int)Math.pow(10, digits - 1) + n / digits;
        int res = n % digits;
        
        for(int i = 1; i < digits - res; i++){
            time /= 10;
        }
        return time % 10;
    }
}
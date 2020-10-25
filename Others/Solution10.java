/*
面试题10：斐波那契数列
*/

public class Solution10 {
    public int Fibonacci(int n) {
        if(n < 2) return n;
        int temp1 = 0;
        int temp2 = 1;
		// 利用Fib(n) = Fib(n-1) + Fib(n-2)的特点，每次只保存当前和前一个数，节省空间开销
        for(int i = 2; i <= n; i ++){
            temp2 += temp1;
            temp1 = temp2 - temp1;
        }
        return temp2;
    }
}
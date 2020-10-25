/*
面试题64：求 1 + 2 + ··· + n
          要求不能使用乘除法、for、while、if、else、switch、case等关键字以及条件判断语句
*/

class Solution64 {
    public int sumNums(int n) {
		//利用 && 操作符的短路特点
        boolean flag = (n > 0) && ((n += sumNums(n - 1)) > 0);
        return n;
    }
}
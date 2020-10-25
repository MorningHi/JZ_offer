/*
面试题58_2：左旋转字符串
*/

public class Solution58_2 {
    public String LeftRotateString(String str,int n) {
        if(str.length() <= 1 || n == 0){
            return str;
        }
        return str.substring(n, str.length()) + str.substring(0, n);
    }
}
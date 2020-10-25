/*
面试题58_1：反转单词顺序
*/

public class Solution58_1 {
	
	// 需要注意的是java中的字符串是不可变对象，修改字符串就相当于重新创建了一个新的字符串
    public String ReverseSentence(String str) {
        if(str.length() <= 1 || str.trim().equals("")){
            return str;
        }
        
        String[] strArr = str.trim().split(" ");
        int begin = 0, end = strArr.length - 1;
        while(begin < end){
            String temp = strArr[begin];
            strArr[begin] = strArr[end];
            strArr[end] = temp;
            begin++;
            end--;
        }
        String newStr = strArr[0];
        for(int i = 1; i < strArr.length; i++){
            newStr += " " + strArr[i];
        }
        return newStr;
    }
}
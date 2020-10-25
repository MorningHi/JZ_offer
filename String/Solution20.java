/*
面试题20：表示数值的字符串
*/

public class Solution {
	
	// 从前向后逐个字符判断
    public boolean isNumeric1(char[] str) {
        if(str.length <= 0){
            return false;
        }
        int start = 0, end = 0;   // [start, end)来标识一个待判断的整数部分，注意左闭右开
        // 先找到整数部分的起止下标
        while(end < str.length && (str[end] == '+' || str[end] == '-' ||(str[end] >= '0' && str[end] <= '9'))){
            end++;
        }
        boolean numeric = scanInteger(str, start, end);  // 判断整数部分
        
        // 判断小数部分(如果存在)
        if(end < str.length && str[end] == '.'){ // 遇到小数点开始小数点和e/E之间的部分进行判断
            start = end + 1;
            end = start;
            while(end < str.length && (str[end] >= '0' && str[end] <= '9')){
                end++;
            }      
            // 注意这一部分应该是无符号的
            // 使用||的原因是像 "11." 和 ".12"也是合法的 
            numeric = scanUnsignedInteger(str, start, end) || numeric;
        }
        // 判断指数部分(如果存在)
        if(end < str.length && (str[end] == 'e' || str[end] == 'E')){
            start = end + 1;
            end = str.length;  // 如果已经到了指数部分，那么 e/E 后面直到尾部必须是整数，可以是有符号
            // !(start == str.length)的原因在于对于像 "12e" 这种，指数符号后面没有数字部分不可以表示数值
            numeric =  !(start == str.length) && scanInteger(str, start, end) && numeric;
        }
        // 判断结束之后end应当移动到字符串末尾，反例："1a3.14",再判断完1为true后不会进入小数和指数判断部分
        return numeric && end == str.length; 
    }
    private boolean scanUnsignedInteger(char[] str, int start, int end){
        while(start < end && str[start] <= '9' && str[start] >= '0'){
            start++;
        }
        return start == end;
    }
    
    private boolean scanInteger(char[] str, int start, int end){
        if(str[start] == '+' || str[start] == '-'){  
            start++;
        } // 如果第一个字符是符号，则判断剩下连续的无符号整数部分
        return scanUnsignedInteger(str, start, end);
    }
	
	
	//方法2：正则表达式
	public boolean isNumeric(char[] str) {
        String s = new String(str);
        return s.matches("([-+]?\\d*(\\.\\d+)?([eE][-+]?\\d+)?)");
    }
}
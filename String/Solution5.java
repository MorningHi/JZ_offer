/*
面试题5：替换空格
*/

public class Solution5 {
    
	// 常规解法
    public String replaceSpace_1(StringBuffer str) {
        if(str == null){
            return null;
        }
        
        int len = str.length();
        int numSpace = 0;
        for(int i = 0; i < len; i++){     // 统计空格数量
            if(str.charAt(i) == ' '){
                numSpace++;
            }
        }
        if(numSpace == 0){
            return str.toString();   // 源字符串中没有空格则无需进行处理
        }
        
        int newLength = len + numSpace * 2; // 新的字符串的长度
        str.setLength(newLength);  
        for(int i = len - 1; i >= 0; i--){   //从后向前修改，减少字符移动次数
            if(str.charAt(i) == ' '){
                str.setCharAt(--newLength, '0');
                str.setCharAt(--newLength, '2');
                str.setCharAt(--newLength, '%');
            }
            else{
                str.setCharAt(--newLength, str.charAt(i));
            }
        }
        return str.toString();
    }
	
	
	// 借助java自带函数
	public String replaceSpace_2(StringBuffer str) {
		if(str == null){
			return null;
        return str.toString().replace(" ", "%20");
    }
}
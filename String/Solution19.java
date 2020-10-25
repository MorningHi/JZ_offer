/*
面试题19：正则表达式匹配
*/
public class Solution19 {
    public boolean match(char[] str, char[] pattern)
    {
        return matchCore(str, 0, pattern, 0);
    }
    
    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex){
        // pattern匹配到尾，str匹配完，说明str和pattern匹配
        if(strIndex == str.length && patternIndex == pattern.length){
            return true;
        }
        // pattern已经匹配完，还有字符未匹配
        if(patternIndex == pattern.length && strIndex < str.length){
            return false;
        }
        
        // 如果pattern的下一个字符是'*'
        if(patternIndex < pattern.length - 1 && pattern[patternIndex + 1] == '*'){
            // 如果当前字符匹配或当前pattern为'.'
            if(strIndex < str.length && (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.')){
                return matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                       || matchCore(str, strIndex + 1, pattern, patternIndex)
                       || matchCore(str, strIndex, pattern, patternIndex + 2);
            }
            else{  // pattern向后移动2，相当于忽略当前字符和后面的*
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        // 一般情况，如果当前字符匹配或当前pattern为'.'，则跳过当前字符，继续匹配后面的部分
        if(strIndex < str.length && (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.')){
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
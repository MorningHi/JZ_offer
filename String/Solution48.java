/*
面试题48：最长不含重复字符的子字符串
*/

class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        int currLength = 0;
        int maxLength = 0;
        int[] position = new int[26];  // 记录26个字母上一次出现的位置
        for(int i = 0; i < 26; i++){
            position[i] = -1;   // 初始化为-1
        }
        
        for(int i = 0; i < s.length(); i++){
            int prevIndex = position[s.charAt(i) - 'a'];  // 当前字符上一次在字符串中的位置
            if(prevIndex < 0 || i - prevIndex > currLength){ // 当前字符没有在当前最长子串中出现过
                currLength++;
            }
            else{
                currLength = i - prevIndex;
            }
            position[s.charAt(i) - 'a'] = i;  // 更新当前字符的位置
            if(currLength > maxLength){
                maxLength = currLength;
            }
        }
        return maxLength;
    }
}
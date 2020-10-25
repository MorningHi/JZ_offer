/*
面试题50_1：第一个只出现一次的字符
牛客网上题目略有不同，书中最后返回字符本身，牛客网上要求返回第一次出现的位置
*/

public class Solution50_1 {
    public int FirstNotRepeatingChar(String str) {
        int[] hashTable = new int[256];  // 用数组构建哈希表
        for(int i = 0; i < str.length(); i++){
            hashTable[str.charAt(i)]++;  // 统计每个字符出现次数，存入哈希表
        }
        for(int i = 0; i < str.length(); i++){
            if(hashTable[str.charAt(i)] == 1){  // 找到第一个出现一次的返回
                return i;
            }
        }
        
        return -1;
    }
}
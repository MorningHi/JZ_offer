/*
面试题38：字符串的的排列
*/

import java.util.ArrayList;
import java.util.Collections;
public class Solution38 {
    public ArrayList<String> Permutation(String str) {
        if(str.length() <= 0){
            return new ArrayList();
        }
        ArrayList<String> strList = new ArrayList();
        Permutation(str.toCharArray(), strList, 0);  
        Collections.sort(strList);  // 牛客网的题目要求所有排列按字典顺序打印
        return (ArrayList)strList;
    }
    
    private void Permutation(char[] strArr, ArrayList strList, int begin){
        if(begin == strArr.length - 1){   // 已经到了字符串末尾并且列表中没有当前字符串
            if(!strList.contains(new String(strArr))){   // 将其加入列表中
                strList.add(new String(strArr));
            }
            return;
        }
        for(int i = begin; i < strArr.length; i++){  // 依次交换头部字符和后面的每一个字符
                swap(strArr, i, begin);   
                Permutation(strArr, strList, begin + 1);  // 递归地对后面部分进行排列
                swap(strArr, i, begin);    // 复位操作，相当于回溯
            }
    }
    
    private void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
/*
面试题31：栈的压入、弹出序列
*/

import java.util.Stack;

public class Solution31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        boolean result = false;
        if(pushA.length > 0 && popA.length > 0 && pushA.length == popA.length){
            Stack<Integer> stack = new Stack();
            int popIndex = 0;
            
            // 每次从pushA序列像栈中添加ige元素，同时判断栈顶元素是不是等于popA的下一个元素
            // 如果等于就将栈顶元素弹出，继续判断后面的元素
            for(int pushIndex = 0; pushIndex < pushA.length; pushIndex++){
                stack.push(pushA[pushIndex]);
                while(!stack.isEmpty() && stack.peek() == popA[popIndex]){
                    stack.pop();
                    popIndex++;
                }
            } 
            if(stack.isEmpty()){
                result = true;
            }
        }
        return result;
    }
}
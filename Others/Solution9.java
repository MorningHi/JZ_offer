/*
面试题9：用两个栈实现队列
*/

import java.util.Stack;

public class Solution9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) { // 压入元素时直接向stack1中压栈
        stack1.push(node);
    }
    
    public int pop() throws Exception{
        if(stack2.isEmpty()){  //如果stack2为空，则从stack1中弹栈并压入stack2中，这样先压栈的元素就位于stack2的栈顶
            if(stack1.isEmpty()){
                throw new Exception("Queue is Empty!");
            }
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        int top = stack2.pop();  //stack2不为空的时候栈顶元素就是FistIn 的元素
        return top;
    }
}
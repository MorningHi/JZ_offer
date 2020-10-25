/*
面试题30：包含min函数的栈
*/

import java.util.Stack;

public class Solution {

    Stack<Integer> stack = new Stack();
    Stack<Integer> min_stack = new Stack();
    public void push(int val) {
        stack.push(val);
        if(min_stack.empty() || min_stack.peek() > val){  // 这样保证min_stack栈顶始终是当前stack中的最小值
            min_stack.push(val);
        }
        else{
            min_stack.push(min_stack.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        min_stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return min_stack.peek();
    }
}
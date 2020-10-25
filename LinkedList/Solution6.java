/*
面试题6：从尾到头打印链表
*/


/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/

import java.util.ArrayList;
import java.util.Stack;

public class Solution6 {
	
	// 解法1：借助栈的FILO特性
    public ArrayList<Integer> printListFromTailToHead_1(ListNode listNode) {
        Stack<Integer> s = new Stack();
        ListNode node = listNode;
        while(node != null){     // 将链表元素依次压入栈中
            s.push(node.val);
            node = node.next;
        }
        ArrayList<Integer> ls = new ArrayList();
        while(!s.empty()){
            ls.add(s.pop());    // 弹栈，将元素添加到列表
        }
        return ls;
    }
	
	// 解法2：借助ArrayList的函数
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ls = new ArrayList();
        while(listNode != null){
            ls.add(0, listNode.val);   // ArrayList.add(0, element)表示将元素添加到ArrayList头
            listNode = listNode.next;
        }
        return ls;
    }
}
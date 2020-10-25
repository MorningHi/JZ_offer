/*
面试题62：圆圈中最后剩下的数字
*/

import java.util.LinkedList;
 
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
}
public class Solution62 {
	
	// 解法一：通过链表进行模模拟
    public int LastRemaining1(int n, int m) {
        if(n <= 0 || m <= 0){
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<Integer>();   // 构建循环链表
        ListNode head = new ListNode(0);
        ListNode p = head;
        for(int i = 1; i < n; i++){
            ListNode node = new ListNode(i);
            p.next = node;
            p = p.next;
        }
        p.next = head;
         
        int k = 0;
        while(head.next != head){
            while(++k < m - 1){
                head = head.next;
            }
            head.next = head.next.next;
            head = head.next;
            k = 0;
        }
        return head.val;
    }
	
	/*
	// 解法二：寻找数学规律‘
	public int LastRemaining2(int n, int m) {
        if(n <= 0 || m <= 0){
            return -1;
        }
        int res = 0;
        for(int i = 2; i <= n; i++){
            res = (res + m) % i;
        }
        return res;
    }*/
}
/*
面试题24：反转链表
*/

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution24 {
	
	// 迭代解法
    public ListNode ReverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nex = curr.next; // 保存断链之后的头部节点指针
            curr.next = prev;  // 反转curr节点的指向
            prev = curr;     
            curr = nex;
        }
        return prev;
    }
	
	
	// 递归解法 https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
	public ListNode ReverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = ReverseList(head.next);
        head.next.next = head; // 以head为界，head后面的已经反转，head前面部分未反转
        head.next = null;
        return p;
    }
}
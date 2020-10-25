/*
面试题52：两个链表的第一个公共节点
*/

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
         if(pHead1 == null || pHead2 == null){
             return null;
         }
         // 首先获取链表的长度
        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);
        int diff = len1 - len2;
        ListNode p1, p2;
        if(diff > 0){
            p1 = pHead1;
            p2 = pHead2;
        }
        else{
            p1 = pHead2;
            p2 = pHead1;
            diff = -diff;
        }
        while(diff-- > 0){  // 较长的先走diff步
            p1 = p1.next;
        }
        while(p1 != null && p2 != null && p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
    
    private int getLength(ListNode head){
        int len =  0;
        ListNode p = head;
        while(p != null){
            p = p.next;
            len++;
        }
        return len;
    }
}
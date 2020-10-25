/*
面试题18：(2)删除链表中的重复节点
*/

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution18_2 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){ // 链表节点数小于1直接返回pHead
            return pHead;
        }
        ListNode newHead = new ListNode(-1);  // 哨兵节点
        ListNode curr, pre = newHead;
        newHead.next = pHead;
        curr = pre.next;   // pre用来记录当前节点的前一个节点
        while(curr != null){
            if(curr.next != null && curr.val == curr.next.val){
                //遇到重复节则curr指针不断后移
                while(curr.next != null && curr.val == curr.next.val){
                    curr = curr.next;
                }
                curr = curr.next; //退出循环时curr指向重复值的最后一个，继续后移
                pre.next = curr;  // pre的下一个指向此时的curr,已经跳过了中间的重复值
            }
            else{
                pre = pre.next;
                curr = curr.next;
            }
        }
        return newHead.next;  // 哨兵节点的下一个节点就是原来的头节点
    }
}
/*
面试题23：链表中环的入口节点
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
public class Solution23 {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        // 如果存在环找到环中任意一个节点
        ListNode meetingNode = MeetingNode(pHead);
        if(meetingNode == null){
            return null;
        }
        // 计算环中节点数目
        int nodesOfLoop = 1;
        ListNode p = meetingNode;
        while(p.next != meetingNode){
            p = p.next;
            nodesOfLoop++;
        }
        
        ListNode fast = pHead, slow = pHead;
        for(int i = 0; i < nodesOfLoop; i++){   // 快指针先向前移动nodesOfLoop
            fast = fast.next;
        }
        
        while(fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    
    private ListNode MeetingNode(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return null;
        }
        ListNode slow = pHead.next, fast = pHead.next.next;
        while(fast != null && slow != null){
            if(fast == slow){
                return fast;  // 存在环，返回快慢指针相遇的节点
            }
            slow = slow.next;
            fast = fast.next;   // fast每次后移之后先判断是否为null再继续后移，避免空指针异常
            if(fast != null){
                fast = fast.next;
            }
        }
        return null;
    }
}
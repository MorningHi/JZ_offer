/*
面试题25：合并两个排序的链表
*/

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution25 {
	
	// 迭代法
    public ListNode Merge1(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        // 两个链表都不为null时，按大小关系添加到新链表即可
        while(list1 != null && list2 != null){
            if(list2.val <= list1.val){
                p.next = list2;
                list2 = list2.next;
            }
            else{
                p.next = list1;
                list1 = list1.next;
            }
            p = p.next;
        }
        // 当其中一个链表已经到末尾时，只需要将另一个链表添加到新链表的末尾
        p.next = (list1 == null) ? list2 : list1;
        return head.next;
    }
	
	// 递归法
	public ListNode Merge2(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        else if(list2 == null){
            return list1;
        }
        
        ListNode head;
        if(list1.val <= list2.val){
            head = list1;
            head.next = Merge(list1.next, list2);
        }
        else{
            head = list2;
            head.next = Merge(list1, list2.next);
        }
        return head;
    }
}
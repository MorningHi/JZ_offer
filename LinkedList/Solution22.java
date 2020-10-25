/*
面试题22：链表中倒数第k个节点
*/

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution22 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0){
            return null;
        }
        ListNode first = head, last = head;
        int i = 0;
        while(++i < k){
            if(last.next != null){ // last先前进k个节点
                last = last.next;
            }
            else{  // last为null说明k大于链表的长度
                return null;
            }
        }
        // first和last同时向后遍历，last到达尾节点的时候first就是倒数第k个节点
        while(last.next != null){
            first = first.next;
            last = last.next;
        }
        return first;
    }
}
/*
面试题18：(1)删除链表的节点
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

public class Solution18_1 {
	public ListNode deleteNode(ListNode head, ListNode toDelete){
		if(head == null || toDelete == null){
			return null;
		}  
		if(toDelete.next != null){  //要删除的节点不是尾节点 
			toDelete.val = toDelete.next.val;
			toDelete.next = toDelete.next.next;
		}
		else if(toDelete == head){ // 要删除的节点是尾节点并且是头节点直接让其为null
			head = null;
		}
		else{
			ListNode p = head; // 要删除的节点是尾节点则需要顺序查找
			while(p.next != toDelete){
				p = p.next;
			}
			p.next = null;
		}
		return head;
	}
}
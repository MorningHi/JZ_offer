/*
面试题35：复杂链表的复制
*/

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution35 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        CloneNodes(pHead);    // 复制节点
        SetRandomPoint(pHead);  // 设置复制节点的random指针
        return SplitList(pHead);  // 分离原链表和复制的节点
    }
    
    private void CloneNodes(RandomListNode pHead){
        RandomListNode node = pHead;
        while(node != null){
            RandomListNode copyNode = new RandomListNode(node.label);
            copyNode.next = node.next;  // 生成当前节点的副本节点位于当前节点之后
            node.next = copyNode;
            node = copyNode.next; // 后移
        }
    }
    
    private void SetRandomPoint(RandomListNode pHead){
        RandomListNode node = pHead, copyNode;
        while(node != null){
            copyNode = node.next;
            if(node.random != null){
                copyNode.random = node.random.next;
            }
            node = copyNode.next;
        }
    }
    
    private RandomListNode SplitList(RandomListNode pHead){
        RandomListNode copyHead = pHead.next;
        RandomListNode node = pHead;
        RandomListNode temp = copyHead;
        
        node.next = temp.next;
        node = node.next;
        while(node != null){
            temp.next = node.next;
            temp = temp.next;
            node.next = temp.next;
            node = node.next;
        }
        return copyHead;
    }
}
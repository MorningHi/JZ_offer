/*
面试题8：二叉树中序遍历的下一个节点
*/

/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;  // 父节点

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null){
            return null;
        }
        // 右子树不为空，下一个节点就是右子树的最左节点
        if(pNode.right != null){
            TreeLinkNode curr = pNode.right;
            while(curr.left != null){
                curr = curr.left;
            }
            return curr;
        }
        else{
            //右子树为空向上找这样一个节点：它是他父节点的左孩子节点，这个父节点就是下一个节点
            TreeLinkNode curr = pNode;
            TreeLinkNode parent = pNode.next;
            while(parent != null && parent.right == curr){
                curr = parent;
                parent = parent.next;
            }
            return parent;
        }
       
    }
}
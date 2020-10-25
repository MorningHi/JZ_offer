/*
面试题36：二叉搜索树与双向链表
*/

/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution36 {
    TreeNode preNode = null;  //双向链表的头节点
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        Convert(pRootOfTree.right);  // 先转换根节点的右子树，转换后右半部分链表的头节点为preNode
        if(preNode == null){     // 根节点右子树为空
            preNode = pRootOfTree;
        }
        else{   // 否则将转换后的部分链接到根节点
            pRootOfTree.right = preNode; 
            preNode.left = pRootOfTree;
            preNode = pRootOfTree;
        }
        // 转换左子树
        Convert(pRootOfTree.left);
        // 从右子树开始转换，完成后preNode就是双向链表的头节点
        return preNode;
    }
}
/*
面试题26：树的子结构
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
public class Solution26 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        // 一开始如果有任意一棵树是null,不用进行接下来的判断
        if(root1 != null && root2 != null){
            if(root1.val == root2.val){ // 如果根节点值相同判断树的子结构
                result = DoesTree1HaveTree2(root1, root2);
            }
            // 根节点值不一样则再A树的左右子树中匹配
            if(!result){
                result = HasSubtree(root1.left, root2);
            }
            if(!result){
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }
    
    private boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2){
        if(root2 == null){  // B树的所有节点已经匹配完
            return true;
        }
        if(root1 == null){ // A树已经匹配完，B树还未匹配完，肯定不是子结构
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
    }
}
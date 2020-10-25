/*
面试题27：二叉树的镜像
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
public class Solution27 {
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        TreeNode temp = root.left;   // 交换root的左右子节点
        root.left = root.right;
        root.right = temp;
       // 递归地交换root子树中所有节点的左右关系
        Mirror(root.left);
        Mirror(root.right);
    }
}
/*
面试题54：二叉搜索树的第k小节点
*/

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    int tempK; 
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null || k == 0){
            return null;
        }
        tempK = k;
        return FindKthNode(pRoot);
    }
    
	// 利用二叉搜索树的性质——中序遍历序列是排序序列，计数得到第k小节点
    private TreeNode FindKthNode(TreeNode root){
        TreeNode target = null;
        if(root.left != null){
            target = FindKthNode(root.left);
        }
        if(target != null){
            return target;
        }
        if(--tempK == 0){
            return root;
        }
        if(target == null && root.right != null){
            target = FindKthNode(root.right);
        }
        return target;
    }


}
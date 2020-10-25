/*
面试题55_2：平衡二叉树
*/

public class Solution55_2 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        return IsBalanced(root) != -1;
    }
    
	// 自底向上，后序遍历的方式得到左右子树的深度，判断
    private int IsBalanced(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = 0, right = 0;
        int temp = IsBalanced(root.left);
        if(temp != -1){
            left += temp;
        }
        else{
            return -1;
        }
        temp = IsBalanced(root.right);
        if(temp != -1){
            right += temp;
        }
        else{
            return -1;
        }
        if(right - left <= 1 && right - left >= -1){
            return 1 + (right > left ? right : left);
        }
        return -1;
    }
}
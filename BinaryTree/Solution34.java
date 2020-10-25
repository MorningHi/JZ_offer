/*
面试题34：二叉树中和为某一值的路径
*/

import java.util.ArrayList;
import java.util.Stack;
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
public class Solution34 {
    
    ArrayList<ArrayList<Integer>> paths = new ArrayList();
    Stack<Integer> path = new Stack();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null){
            return new ArrayList();
        }
        int sum = 0;
        FindPathCore(root, target, sum);
        return paths;
    }
    
    private void FindPathCore(TreeNode root, int target, int sum){
        sum += root.val;
        path.push(root.val);
        
        boolean isLeaf = (root.left == null && root.right == null); // 判断root节点是不是叶节点
        if(isLeaf && (sum == target)){   // 找到路径
            paths.add(new ArrayList(path));
        }
        
        // 如果不是叶子节点则在左右子树中寻找路径
        if(root.left != null){
            FindPathCore(root.left, target, sum);
        }
        if(root.right != null){
            FindPathCore(root.right, target, sum);
        }
        // 返回父节点之前从路径上删除当前节点
        path.pop();
    }
}
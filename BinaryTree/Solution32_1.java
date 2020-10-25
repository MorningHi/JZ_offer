/*
面试题32：不分行从上到下打印二叉树
*/

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
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
public class Solution32_1 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList(); // 用LinkedList实现队列
        queue.offer(root);  // 根节点添加进队列
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();  // 队头元素值添加到list
            list.add(temp.val);
            // 添加temp节点的子节点到队列
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
        return list;
    }
}
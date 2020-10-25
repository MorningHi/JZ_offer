import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;


/*
面试题32_2：分行从上到下打印二叉树
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
public class Solution32_2 {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if(pRoot == null){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(pRoot);
        while(!queue.isEmpty()){
			// 区分出来同一层的节点。内层循环处理同一层的节点，外层循环处理不同层
            int size = queue.size();
            ArrayList<Integer> ls = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                ls.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            list.add(ls);
        }
        return list;
    }
    
}
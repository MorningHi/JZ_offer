/*
面试题7：从前序遍历和中序遍历构建二叉树
*/


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution7 {
    public TreeNode reConstructBinaryTree1(int [] pre,int [] in) {
        if(pre.length <= 0 || in.length <= 0 || pre.length != in.length){
            return null;
        }
        return Construct(pre, in, 0, pre.length-1, 0, in.length-1);
    }
    
    private TreeNode Construct(int[] pre, int[] in, int startPre, int endPre, int startIn, int endIn){
        int rootValue = pre[startPre]; // 前序遍历的第一个数就是根节点的值
        TreeNode root = new TreeNode(rootValue);
        if(startPre == endPre){    // 表明构建完成
            return root;
        }
        int rootIn = startIn;  // 找到中序遍历中根节点的位置
        while(rootIn <= endIn && in[rootIn] != rootValue){
            rootIn++;
        }
        int leftLength = rootIn - startIn;  //左子树序列的长度
        int leftPreEnd = startPre + leftLength;   // 前序遍历序列中左子树的结束位置
        if(leftLength > 0){
            //构建左子树
            root.left = Construct(pre, in, startPre+1, leftPreEnd, startIn, rootIn-1);
        }
        if(leftLength < endPre - startPre){
            // 构建右子树
            root.right = Construct(pre, in, leftPreEnd+1, endPre, rootIn+1, endIn);
        }
        return root;
    }
	
	// 借助Arrays的数组拷贝函数，更简短直观的代码，但拷贝数组存在额外的空间消耗
	public TreeNode reConstructBinaryTree2(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        // 在中序中找到前序的根
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }
}
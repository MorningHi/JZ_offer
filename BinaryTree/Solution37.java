/*
面试题37：序列化二叉树
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
public class Solution37 {
    int index = -1;
    String Serialize(TreeNode root) {
        // 递归地序列化左子树和右子树，null节点序列化为"#"
        if(root == null){
            return "#";
        }
        return root.val + "!" + Serialize(root.left) + "!" + Serialize(root.right);
    }
    
    TreeNode Deserialize(String str) {
        return Deserialize(str.split("!"));  
    }
    private TreeNode Deserialize(String[] strArr){
        index++;  // index为当前要处理的字符下标
        if(index > strArr.length){
            return null;
        }
        TreeNode node = null;
        if(!strArr[index].equals("#")){  // 遇到#表示为叶节点，跳出递归
            node = new TreeNode(Integer.parseInt(strArr[index]));
            node.left = Deserialize(strArr);
            node.right = Deserialize(strArr);
        }
        return node;
    }
}
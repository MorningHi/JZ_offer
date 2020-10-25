/*
面试题33：二叉搜索树的后序遍历序列
*/

public class Solution33 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        return SquenceOfBST(sequence, 0, sequence.length - 1);
    }
    
    private boolean SquenceOfBST(int [] sequence, int start, int end){
        if(end < start){
            return false;
        }
        
        int root = sequence[end];  // 后序遍历序列的最后一个元素是根节点
        int sep = start;  // 左右子树序列的分割点
        while(sep < end && sequence[sep] < root){
            sep++;
        }
        
        // 如果分割点后半部分某个值比根节点值小，那不是二叉搜索树
        for(int i = sep; i < end; i++){
            if(sequence[i] < root){
                return false;
            }
        }
        //递归地判断左右子序列
        boolean left = true, right = true;
        if(sep > start){
            left = SquenceOfBST(sequence, start, sep - 1);
        }
        if(sep < end){
            right = SquenceOfBST(sequence, sep, end - 1);
        }
        return left && right;
    }
}
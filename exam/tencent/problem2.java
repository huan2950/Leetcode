package exam.tencent;
import java.util.*;
import utils.TreeNode;
public class problem2 {
    
}

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param preOrder int整型ArrayList 
     * @param inOrder int整型ArrayList 
     * @return TreeNode类ArrayList
     */
    // Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    public ArrayList<TreeNode> getBinaryTrees (ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        // write code here
        // for ()
        return build(preOrder, 0, preOrder.size() - 1, inOrder, 0, inOrder.size() - 1);
    }

    ArrayList<TreeNode> build(ArrayList<Integer> preOrder,int preStart, int preEnd, ArrayList<Integer> inOrder, int inStart,int inEnd){
        ArrayList<TreeNode> res = new ArrayList<>();
        if (preStart > preEnd || inStart > inEnd){
            res.add(null);
            return res;
        }
        int rootVal = preOrder.get(preStart);
        ArrayList<Integer> indexs = new ArrayList<>();
        for (int i = inStart; i <= inEnd; i++){
            if (inOrder.get(i) == rootVal){
                indexs.add(i);
            } 
        }
        
        for (Integer index : indexs) {
            int leftSize = index - inStart;
            ArrayList<TreeNode> left = build(preOrder, preStart + 1, preStart + leftSize, inOrder, inStart, index - 1);
            ArrayList<TreeNode> right = build(preOrder, preStart + leftSize + 1, preEnd, inOrder, index + 1, inEnd);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(rootVal);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
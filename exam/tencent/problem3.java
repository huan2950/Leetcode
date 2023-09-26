package exam.tencent;
import utils.TreeNode;

public class problem3 {
    public int getTreeSum (TreeNode tree) {
        // write code here
        return (int)( traverse(tree) % 1000000007 );
    }

    public long traverse(TreeNode root){
        if (root == null){
            return 0;
        }
        long left = traverse(root.left);
        long right = traverse(root.right);
        return 1 + 2 * Math.max(left, right);
    }
}

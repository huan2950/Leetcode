/*
 * 将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 
 * 对于双向循环列表，你可以将左右孩子指针作为双向循环链表的前驱和后继指针
 * 第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 */

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

/*
//  * 对于每一个节点来说，它的前驱节点都是左子树的最右下节点
//  * 后继节点是右子树的最左下节点
 * 这里不能用前序遍历，会改变左右指针指向
 * 中序遍历的顺序就是双向链表的建立顺序
 * 只能用中序遍历——定义pre和cur指针来表示中序遍历过程中相邻的两个节点
 */
class Solution {
    Node head, pre;
    public Node treeToDoublyList(Node root){
        if(root==null) return null;
        traverse(root);
        //进行头节点和尾节点的相互指向，这两句的顺序也是可以颠倒的
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void traverse (Node cur){
        if(cur==null) return;
        traverse(cur.left);

        //pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur,当pre==null时，cur左侧没有节点,即此时cur为双向链表中的头节点
        if(pre==null) head = cur;
        //反之，pre!=null时，cur左侧存在节点pre，需要进行pre.right=cur的操作。
        else pre.right = cur;
       
        cur.left = pre;//pre是否为null对这句没有影响,且这句放在上面两句if else之前也是可以的。

        pre = cur;//pre指向当前的cur
        traverse(cur.right);//全部迭代完成后，pre指向双向链表中的尾节点
    }
}

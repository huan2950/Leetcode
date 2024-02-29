/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 随机链表的复制
 */

// @lc code=start
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
/*
 * 本题的难点在于random指针的建立
 * 常规的遍历链表并建立的方式无法建立起random指针的指向
 * 所以可以考虑先建立链表的所有的节点，再去建立指针指向关系
 * 采用hash表来保存新的节点和原链表对应节点的映射
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        // 先创建所有新节点，并使用hash表建立与原链表的映射关系，便于找到
        while (cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        // 再建立所有新节点之间的next和random指针关系
        cur = head;
        while(cur != null){
            // cur为原链表的当前节点
            // 注意新节点一定指向的是新节点
            // 新节点next指向为对应原节点(cur)的next节点所对应的新节点
            map.get(cur).next = map.get(cur.next);
            //新节点random指向的是对应原节点(cur)的random指针所对应的新节点
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
// @lc code=end


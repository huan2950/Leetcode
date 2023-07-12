package utils;
// * Definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createLinkedList(int[] vals) {
        // 定义头节点
        ListNode head = null;
        // 定义当前节点
        ListNode cur = null;
    
        for (int val : vals) {
            // 创建新节点
            ListNode newNode = new ListNode(val);
            if (head == null) {
                // 链表为空时，头结点和当前节点都指向新节点
                head = newNode;
                cur = newNode;
            } else {
                // 将新节点添加到链表尾部
                cur.next = newNode;
                // 更新当前节点为新节点
                cur = cur.next;
            }
        }
    
        // 最后将尾结点指向null
        cur.next = null;
    
        // 返回头结点
        return head;
    }
}
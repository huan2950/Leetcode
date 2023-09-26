/*
 * @lc app=leetcode.cn id=707 lang=java
 *
 * [707] 设计链表
 */

// @lc code=start
class MyLinkedList {

    private int size;
    private ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }
    
    public int get(int index) {
        if (index < 0 || index >= size){
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i <= index; i++){
            cur = cur.next;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size){
            return;
        }
        index = Math.max(0, index);
        size++;
        ListNode prev = head;
        // find the previous node of the inserted location
        for (int i = 0; i < index; i++){
            prev = prev.next;
        }
        // insert the new node
        ListNode node = new ListNode(val);
        node.next = prev.next;
        prev.next = node;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size){
            return;
        }
        size--;
        ListNode prev = head;
        for (int i = 0; i < index; i++){
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end


package utils;
// * Definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    // public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode bulid(int[] vals) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int val : vals) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }
}


class LinkedList {
    private ListNode head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /* 头插法 */
    public void addFirst(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        size++;
    }

    /* 获取链表元素 */
    public int get(int idx) {
        int cnt = 0;
        ListNode curr = head;
        while (curr != null) {
            if (cnt == idx) {
                return curr.val;
            }
            cnt++;
            curr = curr.next;
        }
        return -1;
    }

    /* 删除链表节点 */
    public boolean delete(int idx) {
        if (head == null || idx < 0 || idx >= size)
            return false;

        if (idx == 0) {
            head = head.next;
        } else {
            int cnt = 0;
            ListNode curr = head;
            while (cnt < idx - 1) {
                curr = curr.next;
                cnt++;
            }
            curr.next = curr.next.next;
        }
        size--;
        return true;
    }

    /* 插入元素 */
    public boolean insert(int idx, int val) {
        if (idx < 0 || idx > size)
            return false;

        if (idx == 0) {
            addFirst(val);
            return true;
        }

        int cnt = 0;
        ListNode curr = head;
        while (curr != null && cnt < idx - 1) {
            curr = curr.next;
            cnt++;
        }
        if (curr == null)
            return false;

        ListNode node = new ListNode(val);
        node.next = curr.next;
        curr.next = node;
        size++;
        return true;
    }
    
    /* 输出链表 */
    public void show() {
        if (head == null) {
            System.out.println("Link list is empty");
            return;
        }
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    }
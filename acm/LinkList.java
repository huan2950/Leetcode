package acm;

import java.util.Scanner;

public class LinkList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] vals = new int[n];
        for (int i = n-1; i >= 0; i--){
            vals[i] = in.nextInt();
        }
        ListNode head = ListNode.bulid(vals);
        int m = in.nextInt();
        for(int i = 0; i < m; i++){
           String op = in.next();
            if (op.equals("get")){
                int res = get(head, in.nextInt());
                if (res == -1){
                    System.out.println("get fail");
                }else{
                    System.out.println(res);
                }
            }else if (op.equals("delete")){
                boolean res = delete(head, in.nextInt());
                if (res){
                    System.out.println("delete OK");
                }else{
                    System.out.println("delete fail");
                }
            }else if (op.equals("insert")){
                boolean res = insert(head, in.nextInt(), in.nextInt());
                if (res){
                    System.out.println("insert OK");
                }else{
                    System.out.println("insert fail");
                }
            }else if (op.equals("show")){
                show(head);
            }
        }
        in.close();
    }

    public static int get(ListNode head, int index){
        ListNode dummy = new ListNode(-1);
        ListNode cur;
        dummy.next = head; 
        cur = dummy;
        int count = 0;
        while(cur != null){
            if (index == count){
                return cur.val;
            }
            count++;
            cur = cur.next;
        }
        return -1;
    }
    
    public static boolean delete(ListNode head, int index){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre;
        pre = dummy;
        int count = 1;
        while (pre.next != null){
            if (index == count){
                // find the position
                pre.next = pre.next.next;
                return true;
            }
            count++;
            pre = pre.next;
        }
        return false;
    }
    
    public static boolean insert(ListNode head, int index,int val){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre;
        pre = dummy;
        // cur = pre.next;
        int count = 1;
        while(pre.next != null){
            if (count == index){
                ListNode node = new ListNode(val); 
                node.next = pre.next;
                pre.next = node;
                return true;
            }    
        }
        return false;
    }

    public static void show(ListNode head){
        if (head == null){
            System.out.println("Link list is empty");
            return;
        }
        ListNode cur = head;
        while (cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}


class ListNode {
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

class LinkedList{
    ListNode head = null;
    
}
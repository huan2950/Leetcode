/*
 * @lc app=leetcode.cn id=86 lang=cpp
 *
 * [86] 分隔链表
 */

// @lc code=start

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

/**
 * 思路：
 * 使用两个链表，一个放小于x的节点，一个放大于等于x的节点，将两个链表进行合并
*/

class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode* small = new ListNode(-1);//构建虚拟头结点
        ListNode* p1 = small;//p1指针指向small链表末尾
        ListNode* large = new ListNode(-1);//构建虚拟头结点
        ListNode* p2 = large;//p2指针指向large链表末尾
        ListNode* p = head;//p指针遍历原链表
        while (p != nullptr){
            if (p->val >= x){//大于等于x的节点，放在large链表汇总
                p2->next = p;
                p2 = p2->next;
            }
            else{
                p1->next = p;
                p1 = p1->next;
            }
            ListNode* temp = p->next;//断开原链表中当前结点的next指针
            p->next = nullptr;
            p = temp;
        }
        //连接两个链表——small链表连接在large链表后面
        p1->next = large->next; 
        return small->next;
    }
};
// @lc code=end


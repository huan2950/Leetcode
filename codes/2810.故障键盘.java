/*
 * @lc app=leetcode.cn id=2810 lang=java
 *
 * [2810] 故障键盘
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String finalString(String s) {
        boolean head = false;
        Deque<Character> q = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == 'i'){
                head = !head;// 调转头部
            }
            else {
                if (head){// 往头部添加
                    q.addFirst(ch);
                }else{
                    q.addLast(ch);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        if (head){
            while (!q.isEmpty()){
                // 反序输出
                sb.append(q.pollLast());
            }
        }else{
            while (!q.isEmpty()) {
                sb.append(q.pollFirst());
            }
        }
        return sb.toString();
    }
}
// @lc code=end


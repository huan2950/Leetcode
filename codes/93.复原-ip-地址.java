/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> path = new ArrayList<>();
    List<String> res = new ArrayList<>();
    /**
     * 
     * @param s: the splited string
     * @param start: Initial partition point
     */
    public void backtrack(String s,int start, int num){
        // the end condition is end of string
        if (num == 3){
            if (checkNum(s, start, s.length()-1)){
                // join the former strings and concat the last string
                res.add(String.join(".",path) + "."+ s.substring(start, s.length()));
            }
            return;
        }

        // make a choice
        for (int i = start; i < s.length(); i++){
            if (checkNum(s,start,i)){
                num++;
                path.add(s.substring(start, i + 1));
                backtrack(s, i + 1, num);
                num--;
                path.remove(path.size() - 1);// removeLast
            }else{
                continue;
            }
        }
    }

    private Boolean checkNum(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() == 0) return res;
        backtrack(s, 0, 0);
        return res;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=241 lang=java
 *
 * [241] 为运算表达式设计优先级
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*'){
                // 遇到运算符,进行分割
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                
                // 治
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+'){
                            res.add(l + r);
                        }else if (c == '-'){
                            res.add(l - r);
                        }else if (c == '*'){
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        // 遍历完字符串,没有运算符,则说明expression为一个数
        if (res.isEmpty()){
            res.add(Integer.valueOf(expression));

        }
        return res;

    }
}
// @lc code=end


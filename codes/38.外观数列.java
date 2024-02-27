/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */
/*
* @Description: 
* @Author: timjoy
* @Date: 2023-10-24
* @LastEditTime: 2023-10-24
*/
// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String str = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int m = str.length();
        for (int i = 0; i < m; i++){
            char c = str.charAt(i);
            if (i + 1 < m && c == str.charAt(i + 1)){
                count++;
            }else{
                sb.append(count).append(c);
                count = 1;
            }
        }
        return sb.toString();
    }
    /**
     * String str = countAndSay(n - 1);
     * 
     */
}
// @lc code=end


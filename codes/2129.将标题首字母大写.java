/*
 * @lc app=leetcode.cn id=2129 lang=java
 *
 * [2129] 将标题首字母大写
 */

// @lc code=start
class Solution {
    public String capitalizeTitle(String title) {
        String[] strArr = title.split(" ");
        for (int i = 0; i < strArr.length; i++){
            String str = strArr[i].toLowerCase();
            if (str.length() > 2) str = str.substring(0, 1).toUpperCase() + str.substring(1);
            strArr[i] = str;
        }
        return String.join(" ", strArr);
    }
}
// @lc code=end


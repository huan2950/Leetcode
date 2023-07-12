/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) return 0;
        //使用Hashset来存储，用于判断比较
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        // 使用HashSet来存储deadends来降低复杂度
        Set<String> dead = new HashSet<>();
        for (String string : deadends) {
            dead.add(string);
        }
        q1.add("0000");
        q2.add(target);
        int step = 0;
        visited.add("0000");

        while (!q1.isEmpty() && !q2.isEmpty()) {
            Set<String> temp = new HashSet<>();
            // if(q1.size() > q2.size()){//保证只对size小的队列进行搜索
            //     temp = q1;
            //     q1 = q2;
            //     q2 = temp;
            // }

            for (String cur : q1) {
                if(dead.contains(cur))
                    continue;

                if(q2.contains(cur)){//两个集合有相交,说明找到最终结果
                    return step;
                }

                visited.add(cur);

                for (int j = 0; j < 4; j++) {
                    String up = addOne(cur,j);
                    String down = minusOne(cur,j);
                    if(!visited.contains(up))//避免重复拨动
                        temp.add(up);
                    if(!visited.contains(down))
                        temp.add(down);
                }
            }
            step++;
            if(temp.size() > q2.size()){//保证只对size小的队列进行搜索
                q1 = q2;
                q2 = temp;
            }else{
                q1 = temp;
            }
        }
        return -1;
    }

    /*
     * 向上拨动一次
     */
    public String addOne(String str,int j){
        //将字符串中的第j个字符加一
        char[] array = str.toCharArray();
        if(array[j] == '9')
            array[j] = '0';
        else array[j] += 1;
        return new String(array);
    }

    /**
     * 向下拨动一次
     */
    public String minusOne(String str,int j){
        //将字符串中的第j个字符加一
        char[] array = str.toCharArray();
        if(array[j] == '0')
            array[j] = '9';
        else array[j] -= 1;
        return new String(array);
    }
}
// @lc code=end


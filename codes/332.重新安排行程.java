/*
 * @lc app=leetcode.cn id=332 lang=java
 *
 * [332] 重新安排行程
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> path = new ArrayList<>();
    public List<String> res;
    public boolean[] used = new boolean[301];
    public boolean find = false;
    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort((o1, o2) -> o1.get(1).compareTo(o2.get(1)));// Arrange landing sites in ascending order
        path.add("JFK");
        backtrack(tickets);
        return res;

    }

    public void backtrack(List<List<String>> tickets){
        if (find) return;

        if (path.size() == tickets.size() + 1){// find a solution
            res = new ArrayList<>(path);
            find = true;
            return;
        }

        for (int i = 0; i < tickets.size(); i++){
            // get a correct ticket
            if (! used[i] && path.get(path.size()-1).equals(tickets.get(i).get(0)) ){
                used[i] = true;
                path.add(tickets.get(i).get(1));
                backtrack(tickets);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
// @lc code=end


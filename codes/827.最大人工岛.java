/*
 * @lc app=leetcode.cn id=827 lang=java
 *
 * [827] 最大人工岛
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    private Map<Integer,Integer> areas = new HashMap<>();
    Set<Integer> indexes;
    public int largestIsland(int[][] grid) {
        // First go through the island and store the area and the index of the island.
        int index = 2; // The initial index of the island starts at 2, because 0 and 1 are already occupied.
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) {
                    int area = traverse(grid, i, j, index);
                    areas.put(index, area);
                    index++;
                }
            }
        }
        // Then go through the sea and find the maximum area of the island around the sea.
        int res = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 0) {
                    // initialize the variables
                    indexes = new HashSet<>();
                    // check the areas around the current sea
                    int area = check(grid, i-1, j) + check(grid, i+1, j) + check(grid, i, j-1) + check(grid, i, j+1);
                    area += 1;
                    res = Math.max(res, area);
                } else {// island
                    res = Math.max(res, areas.get(grid[i][j]));
                }
            }
        }
        return res;
    }

    public int check(int[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return 0;
        // get the index and area of the island
        int index = grid[i][j];
        int area = areas.get(index);
        // the same island
        if (indexes.contains(index)){
            return 0;
        }else{
            indexes.add(index);
            return area;
        }
    }


    public int traverse(int[][] grid, int i, int j,int index) {
        // Reach the boundary, just return
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return 0;
        // If it is not an island, just return
        if (grid[i][j] != 1){
            return 0;
        }
        // Visit the island and mark it as visited
        grid[i][j] = index;
        // Traverse the islands around the current island
        return 1
        + traverse(grid, i - 1, j, index)
        + traverse(grid, i + 1, j, index)
        + traverse(grid, i, j - 1, index)
        + traverse(grid, i, j + 1, index);
    }
}
// @lc code=end


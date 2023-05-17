import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=354 lang=java
 *
 * [354] 俄罗斯套娃信封问题
 */

// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];//第一列升序排列
                }    
                else{
                    return o2[1] - o1[1];//第二列降序排列
                }
            }
        });

        List<Integer> d = new ArrayList<Integer>(); //这里d数组的含义和300题中的d数组的含义一致
        d.add(envelopes[0][1]);
        //以下逻辑和300完全一致
        for (int i = 1; i < envelopes.length; i++) {
            int num = envelopes[i][1];
            if (num > d.get(d.size() - 1)){
                d.add(num);
            }
            else{
                int index = binarySearch(d, num);
                d.set(index, num);
            }
        }
        return d.size(); 
    }

    public int binarySearch(List<Integer> f, int target) {
        int low = 0, high = f.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (f.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
// @lc code=end


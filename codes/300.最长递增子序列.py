#
# @lc app=leetcode.cn id=300 lang=python3
#
# [300] 最长递增子序列
#
from typing import List
# @lc code=start
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        d = []
        for n in nums:
            if not d or n > d[-1]:
                d.append(n)
            else:
                l ,r = 0, len(d) - 1
                loc = r
                while( l <= r):
                    mid = (l + r) // 2
                    if d[mid] >= n:
                        r = mid - 1
                        loc = mid
                    else:
                        l = mid + 1
                d[loc] = n
        return len(d)        
    
# @lc code=end


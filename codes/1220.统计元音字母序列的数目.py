#
# @lc app=leetcode.cn id=1220 lang=python3
#
# [1220] 统计元音字母序列的数目
#
import numpy as np
MOD = 10**9+7
# @lc code=start
class Solution:
    def countVowelPermutation(self, n: int) -> int:
        ans = np.ones(5, dtype=np.int64)
        mat= np.array([[0, 1, 1, 0, 1], [1, 0, 1, 0, 0], [0, 1, 0, 1, 0],
         [0, 0, 1, 0, 0], [0, 0, 1, 1, 0]],dtype=np.int64)
        n -= 1
        while n:
            if n & 1:
                ans = ans @ mat % MOD # @表示矩阵乘法
            mat = mat @ mat % MOD
            n >>= 1
        return int(ans.sum()) % MOD

# @lc code=end


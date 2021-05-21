# Time Complexity: O(n)
# Space Complexity: O(1)
# Ran on Leetcode: Yes

class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        if not n:
            return 0
        l_max = 0
        r_max = 0
        l = 0
        r = n-1
        res = 0
        while l <= r:
            if height[l] <= height[r]:
                if l_max > height[l]:
                    res += l_max - height[l]
                else:
                    l_max = max(l_max, height[l])
                l += 1
            else:
                if r_max > height[r]:
                    res += r_max - height[r]
                else:
                    r_max = max(r_max, height[r])
                r -= 1
        return res
                
        
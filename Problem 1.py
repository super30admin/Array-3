# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        l_max = []
        r_max = -1
        cur_max = -1
        for i in height:
            cur_max = max(i, cur_max)
            l_max.append(cur_max)
        cur_max = -1
        ans = 0
        for i in range(len(height)-1, -1, -1):
            r_max = max(r_max, height[i])
            ans += (min(l_max[i], r_max)-height[i])
        return ans
            
        

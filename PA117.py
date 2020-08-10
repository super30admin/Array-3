#Time Complexity - O(n)
#Space Complexity - O(1)
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        
        hm = 0
        lm = 0
        l = 0
        r = len(height) - 1
        ans = 0
        while l < r:
            if height[l] < height[r]:
                if height[l] > lm:
                    lm = height[l]
                else:
                    ans = ans + (lm - height[l])
                l = l + 1  
            else:
                if height[r] > hm:
                    hm = height[r]
                else:
                    ans = ans + (hm - height[r])
                r = r - 1
        return ans
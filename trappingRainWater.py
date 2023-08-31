#TC - O(n)
#SC - O(1)
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        l,r = 0, len(height)-1
        maxLeft,maxRight = height[l],height[r]
        res = 0 
        while l < r:
            if maxLeft < maxRight:
                l+=1
                maxLeft = max(height[l],maxLeft)
                res+=(maxLeft-height[l])
            else:
                r-=1
                maxRight = max(height[r],maxRight)
                res+=(maxRight-height[r])
        return res
        
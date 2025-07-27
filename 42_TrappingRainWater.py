"""
TC: O(n)
SC: O(1)
Logic: 2 pointer method. Maintain a left and right max
"""
class Solution:
    def trap(self, height: List[int]) -> int:
        leftMax = rightMax = 0
        l = 0
        r = len(height)-1
        total_water = 0
        while(l<r):
            #process smaller height first
            if height[l]<height[r]:
                #process left side
                if height[l]>leftMax:
                    leftMax = height[l]
                else:
                    total_water+= leftMax-height[l]
                l+=1
            else:
                #process right side
                if height[r]>rightMax:
                    rightMax = height[r]
                else:
                    total_water+= rightMax - height[r]
                r-=1
        return total_water
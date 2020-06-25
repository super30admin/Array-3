#Time Complexity:O(n)

#Space Complexity:O(1)

#Approach:The amount of water trapped will depend on the minimum. of the two bars on left and right. If right bar is longer than the left bar then. the amount of water that can be stored depend on the height of left bar. That's why we move the left pointer. until we find a left bar that's bigger than the current right bar. If we findone. then the amount of water that can be trapped depend on the height of right. Hence we move to the right pointer towards left. On both sides we maintain. the max height. If the current bar in both direction is smaller than the max bar's height on corresponding directions then water can be trapped there.If it's bigger than corresponding max, then this is the new max.

#Did it run on Leetcode:Yes
class Solution:
    def trap(self, height: List[int]) -> int:
        l,r,leftmax,rightmax=0,len(height)-1,0,0
        amount=0
        while l<r:
            if height[l]<height[r]:
                if height[l]<leftmax:
                    amount+=leftmax-height[l]
                else:
                    leftmax=height[l]
                l+=1
            else:
                if height[r]<rightmax:
                    amount+=rightmax-height[r]
                else:
                    rightmax=height[r]
                r-=1
        return amount
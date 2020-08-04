# Time Complexity :O(n)
# Space Complexity :O(1) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        #left and right pointer
        left = 0
        right = len(height)-1
        #initialize sol
        sol = 0
        #max left wall and max right wall
        leftMax = 0
        rightMax = 0
        # while left less than right
        while left < right:
            # always start from smaller as this means there is a larger wall on the other side that can keep water
            if height[left] < height[right]:
                #if hight is greater than or equal max update max
                if height[left] >= leftMax:
                    leftMax = height[left]
                else:
                    # else this means left max can hold water that is the difference between max and hight u r at
                    sol+= leftMax - height[left]
                # update left
                left +=1
            else:
                #if hight is greater than or equal max update max
                if height[right] >= rightMax:
                    rightMax = height[right]
                else:
                    # else this means left max can hold water that is the difference between max and hight u r at
                    sol+= rightMax - height[right]
                # update right
                right -=1
        return sol
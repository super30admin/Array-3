#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        trappedWater = 0
        left, right, leftWall, rightWall = 0, len(height)-1, 0, len(height)-1
        while left <= right:
            #process left side
            if height[leftWall] < height[rightWall]:
                #check if we can trap water
                if height[left] < height[leftWall]:
                    trappedWater += height[leftWall] - height[left]
                #update leftWall pointer
                else:
                    leftWall = left
                left += 1
            #process right side
            else:
                #check if we can trap water
                if height[right] < height[rightWall]:
                    trappedWater += height[rightWall] - height[right]
                #update rightWall pointer
                else:
                    rightWall = right
                right -= 1

        return trappedWater

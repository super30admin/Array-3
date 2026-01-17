# https://leetcode.com/problems/trapping-rain-water/
# Time complexity- O(n) Space Complexity- O(1)

class Solution:
    def trap(self, height: list[int]) -> int:
        # initialise the left and right pointer
        l, r = 0, len(height) - 1
        # intialise the left and right
        leftmax, rightmax = height[l], height[r]
        res = 0

        # loop till left pointer crosses the right to check the taller wall present on which side left or right
        while l < r:
            # taller wall present on right side
            if leftmax < rightmax:
                # increment the left pointer
                l += 1
                # update the leftmax by comparing with the height of next wall
                leftmax = max(leftmax, height[l])
                # update the result set with the unit value
                res += leftmax - height[l]
            else:
                # when the taller wall is present on the left side
                # decrement the right pointer
                r -= 1
                # update the rightmax by comparing with the height of adjacent wall
                rightmax = max(rightmax, height[r])
                # update the result set with the unit value
                res += rightmax - height[r]

        return res
    
solution = Solution()
print(solution.trap([0,1,0,2,1,0,1,3,2,1,2,1]))

        
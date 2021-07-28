# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def trap(self, height):

        n = len(height)
        left = 0
        right = n - 1

        left_max = 0
        right_max = 0
        result = 0
        #         We will check until left pointer is less than right pointer
        while left < right:
            #             We will check if height at left pointer is less than height at right pointer
            #            Then we will check further if left height is greater than left max , if then left
            #            max is  updated or else the difference is added to the result and will update left
            #            pointer and same for right pointer
            if height[left] < height[right]:
                if height[left] >= left_max:
                    left_max = height[left]
                else:
                    result += left_max - height[left]
                left += 1
            else:
                if height[right] >= right_max:
                    right_max = height[right]
                else:
                    result += right_max - height[right]

                right -= 1

        return result


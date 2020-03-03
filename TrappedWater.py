#Solution using two pointers
#Time Complexity O(N)
#Space Complexity O(1)

class Solution:
    def trap(self, height: List[int]) -> int:
        left,right = 0,len(height)-1
        left_max = right_max = 0
        amount = 0
        while left<right:
            left_max = max(left_max,height[left])
            right_max = max(right_max,height[right])
            if left_max <= right_max:
                amount += (left_max-height[left])
                left+= 1
            else:
                amount += (right_max-height[right])
                right -= 1
        return amount
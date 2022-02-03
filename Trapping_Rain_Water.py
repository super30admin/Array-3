class Solution:
    def trap(self, height: List[int]) -> int:
        """
        Trapping Rain Water
        Time complexity : O(N)
        Space complexity : O(1)
        """
        left = 0
        right = len(height) - 1
        left_max = height[left]
        right_max = height[right]
        trapped = 0
        
        while left < right:
            if height[left] <= height[right]:
                if height[left] < left_max:
                    trapped += left_max - height[left]
                else:
                    left_max = height[left]
                left += 1
            else:
                if height[right] < right_max:
                    trapped += right_max - height[right]
                else:
                    right_max = height[right]
                right -= 1
                    
        return trapped
            
        
        
#         max_ = height[0]
#         left = [max_]
#         for i in range(1,len(height)):
#             if height[i] >= max_:
#                 max_ = height[i]
#                 left.append(max_)
#             else:
#                 left.append(max_)
#         max_ = height[-1]
#         right = [0 for i in range(len(height))]
#         for i in range(1,len(height)+1):
#             if height[len(height) - i] >= max_:
#                 max_ = height[len(height) - i]
#                 right[len(height) - i] = max_
#             else:
#                 right[len(height) - i] = max_
                
#         trapped = 0
#         for i in range(len(height)):
#             trapped += abs(min(left[i],right[i]) - height[i])
#         return trapped
                
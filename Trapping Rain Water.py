""""// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
class Solution:
    def trap(self, height) -> int:
        result = 0
        lw = 0
        rw = 0
        l = 0
        r = len(height) - 1
        while l <= r:
            if lw <= rw:
                if height[l] < lw:
                    result += lw - height[l]
                else:
                    lw = height[l]
                l += 1
            else:
                if height[r] < rw:
                    result += rw - height[r]
                else:
                    rw = height[r]
                r -= 1
        return result

# class Solution:
#     def trap(self, height: List[int]) -> int:
#         slow=0
#         fast=1
#         temp=0
#         result=0
#         while fast<len(height):
#             if height[slow]>height[fast]:
#                 temp+= height[slow]-height[fast]
#             else:
#                 result+=temp
#                 slow=fast
#                 temp=0
#             fast+=1

#         peak=slow
#         temp=0
#         slow=len(height)-1
#         fast=slow-1

#         while fast>=peak:
#             if height[slow]>height[fast]:
#                 temp+= height[slow]-height[fast]
#             else:
#                 result+=temp
#                 slow=fast
#                 temp=0
#             fast-=1
#         return result


# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class Solution:
    def trap(self, height) -> int:
        if len(height) < 3:
            return 0
        result = 0
        lw, rw = 0, 0
        l, r = 0, len(height)-1
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


print(Solution().trap([4, 2, 0, 3, 2, 5]))

# TC: O(n); SC: O(1)
# class Solution:
#     def trap(self, height) -> int:
#         if len(height) < 3:
#             return 0
#         slow = 0
#         fast = slow + 1
#         temp = 0
#         result = 0
#         while fast < len(height):
#             if height[slow] > height[fast]:
#                 temp += height[slow] - height[fast]
#             else:
#                 result += temp
#                 slow = fast
#                 temp = 0
#             fast += 1
#         peak = slow
#         slow = len(height) - 1
#         fast = slow - 1
#         temp = 0
#         while fast >= peak:
#             if height[slow] > height[fast]:
#                 temp += height[slow] - height[fast]
#             else:
#                 result += temp
#                 slow = fast
#                 temp = 0
#             fast -= 1
#         return result
#
#
# print(Solution().trap([4, 2, 0, 3, 2, 5]))

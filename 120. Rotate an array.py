class Solution:
    def rotate(self, nums, k):
        """
        Do not return anything, modify nums in-place instead.
        """
        if nums is None:
            return
        n = len(nums)
        if k > n:
            k = k % n
        self.reverse(nums, 0, n - 1)
        print(nums)
        self.reverse(nums, 0, k - 1)
        print(nums)
        self.reverse(nums, k, n - 1)
        print(nums)

    def reverse(self, L, l, r):
        while l < r:
            L[l], L[r] = L[r], L[l]
            l += 1
            r -= 1

# TC = O(N)
# Space complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

obj = Solution()
L = [1, 2, 3, 4, 5, 6, 7]
print(len(L))
obj.rotate(L, 3)

#
# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         """
#         Do not return anything, modify nums in-place instead.
#         """
#         if nums is None:
#             return
#
#         n = len(nums)
#
#         if k > n:
#             k = k % n  # rotating array by k % n places is same as rotating it by k place when k is greater than n
#         self.reverse(nums, 0, n - 1)
#         self.reverse(nums, 0, k - 1)
#         self.reverse(nums, k, n - 1)
#
#     def reverse(self, nums, left, right):
#         while left < right:
#             self.swap(nums, left, right)
#             left += 1
#             right -= 1
#
#     def swap(self, nums, left, right):
#         temp = nums[left]
#         nums[left] = nums[right]
#         nums[right] = temp
#
# # Time Complexity: O(n)
# # Space Complexity: O(1)


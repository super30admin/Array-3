# 1. Using Extra Array - Single Pass
# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         """
#         Do not return anything, modify nums in-place instead.
#         """
#         n = len(nums)
#         out = [0] * n
#         for i in range(n):
#             if i < n-k:
#                 out[k+i] = nums[i] 
#             else:
#                 out[i-n+k] = nums[i]
#         return out

# 2. 2 Pass- O(1)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        n = len(nums)
        # Edge case - Dont forget
        k = k % n
        l = 0
        r = n - 1

        self.reverse(nums, 0, n - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, n - 1)

    def reverse(self, nums, l, r):
        while l < r:
            self.swap(nums, l, r)
            l += 1
            r -= 1

    def swap(self, nums, i, j):
        temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp

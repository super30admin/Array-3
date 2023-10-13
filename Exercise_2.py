# Problem3  Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)
# // Time Complexity : O(n) * 3 = O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

class Solution:
    def rotate(self, nums, k):
        # if no nums then return
        if not nums:
            return
        n = len(nums)
        k = k % n
        # reversing total array
        self.reverse(nums, 0, n - 1)
        # reversing k elements
        self.reverse(nums, 0, k - 1)
        # reversing n-k elements
        self.reverse(nums, k, n - 1)
        return nums

    def reverse(self, nums, left, right):
        while left <= right:
            self.swap(nums, left, right)
            left += 1
            right -= 1

    def swap(self, arr, i, j):
        temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp


nums = [1, 2, 3, 4, 5, 6, 7]
k = 3
sol = Solution()
print(sol.rotate(nums, k))

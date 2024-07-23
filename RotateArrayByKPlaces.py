# Time Complexity : O(n)
# Space Complexity : O(1)
class Solution:
    def rotate(self, nums, k):
        if not nums:
            return
        
        n = len(nums)
        k %= n # If k is greater than n, then the rotation needs to happen only for k%n times
               # i.e the remainder
        self.reverse(nums, 0, n - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, n - 1)

    def reverse(self, nums, start, end):
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1

# Examples
solution = Solution()

# Example 1
nums1 = [1, 2, 3, 4, 5, 6, 7]
k1 = 3
solution.rotate(nums1, k1)
print("Input: nums = [1, 2, 3, 4, 5, 6, 7], k = 3")
print("Output:", nums1) # Expected Output: [5, 6, 7, 1, 2, 3, 4]

# Example 2
nums2 = [-1, -100, 3, 99]
k2 = 2
solution.rotate(nums2, k2)
print("Input: nums = [-1, -100, 3, 99], k = 2")
print("Output:", nums2) # Expected Output: [3, 99, -1, -100]

# Example 3
nums3 = [1, 2, 3, 4, 5]
k3 = 7
solution.rotate(nums3, k3)
print("Input: nums = [1, 2, 3, 4, 5], k = 7")
print("Output:", nums3) # Expected Output: [4, 5, 1, 2, 3]
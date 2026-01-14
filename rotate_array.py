# https://leetcode.com/problems/rotate-array/
# Time Complexity- On) Space Complexity- O(1) 

class Solution:
    def rotate(self, nums: list[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        # to handle the condition when k is greater than the length of the array then we don't want to rotate the array unnecessarily 
        # nums = [1,2,3], k = 5,  k % 3 = 2
        k = k % n

        # reverse the entire array
        self.reverse(nums, 0, n - 1)
        # reverse the kth array
        self.reverse(nums, 0, k - 1)
        # reverse the n-k array
        self.reverse(nums, k, n - 1)

    # define the reverse function
    def reverse(self, nums, left, right):
        while left < right:
            # swap the element
            self.swap(nums, left, right)
            # increment the left side
            left += 1
            # decrement the right side
            right -= 1

    # define the swap function
    def swap(self, nums, i, j):
        # swap the elements
        nums[i], nums[j] = nums[j], nums[i]

solution = Solution()
print(solution.rotate([1,2,3,4,5,6,7],3))

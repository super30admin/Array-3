# Time Complexity : O(n)
# Space Complexity :O(1)
# Passed on Leetcode: yes

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def reverse_list(arr):
            left = 0
            right = len(arr)-1
            while (left < right):
                # Swap
                temp = arr[left]
                arr[left] = arr[right]
                arr[right] = temp
                left += 1
                right -= 1
            return arr

        k = k%len(nums)
        nums = reverse_list(nums)
        nums[:k] = reverse_list(nums[:k])
        nums[k:] = reverse_list(nums[k:])
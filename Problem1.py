"""
To rotate the array to the right by k steps, I first reversed the entire array. Then, I reversed the first k elements to place them in correct order. Finally, I reversed the remaining elements from index k to end. This achieves the desired rotation in-place.
Time Complexity: O(n)
Space Complexity: O(1)
"""
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        if n <= 1:
            return

        k = k % n

        def reverse(left, right):
            while left < right:
                nums[left], nums[right] = nums[right], nums[left]
                left += 1
                right -= 1
        
        reverse(0, n - 1)
        reverse(0, k - 1)
        reverse(k, n - 1)

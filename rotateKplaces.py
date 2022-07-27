# Approach: Reverse entire array, then reverse first k elements, then reverse remaining elements
# TC: O(N)
# SC: O(1)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # If k is larger than len of nums, we use mod operation to get actual k
        # E.g. [1,2] and k=3 means we can only actually rotate it once
        # 3%2 = 1 and our ans will be [2,1]
        k = k % len(nums) 
        self.reverse(nums, 0, len(nums)-1)
        self.reverse(nums, 0, k-1)
        self.reverse(nums, k, len(nums)-1)
    
    def reverse(self, nums, l, h):        
        
        while l < h:
            nums[l], nums[h] = nums[h], nums[l]
            l += 1
            h -= 1
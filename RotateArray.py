# TC: O(N) since we are iterating over each element. 
# SC: O(1) since we do not use any extra space. 

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if not nums: 
            return
        
        k = k % len(nums)
        
        def reverse(start, end): 
            while start <= end: 
                temp = nums[start]
                nums[start] = nums[end]
                nums[end] = temp
                start += 1
                end -= 1
        
        reverse(0, len(nums) - 1)
        reverse(0, k -1)
        reverse(k, len(nums) - 1)

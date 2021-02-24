#Time Complexity -- O(N)
#Space Complexity -- O(1)
class Solution:
    
    def reverse(self, nums, i, j):
        while i < j:
            nums[i],nums[j] = nums[j], nums[i]
            i += 1
            j -= 1
        
    
    
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k % n
        
        self.reverse(nums, 0, n-1)
        self.reverse(nums, 0, k-1)
        self.reverse(nums, k, n-1)
        

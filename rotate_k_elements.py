# Time Complexity : O(n)
# Space Complexity : O(1)

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        k = k  % len(nums)
        
        self.reverse(nums, 0, len(nums) - 1)
        self.reverse(nums, 0, k-1)
        self.reverse(nums, k, len(nums)-1)
        
        return nums
    
    def reverse(self, nums, i , j):
        
        while ( i < j ) :
            
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
            
            i = i + 1
            j = j - 1
        
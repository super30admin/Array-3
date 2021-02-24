# Approach - Reverse the list completey first, then reverse it up till k and k onwards which is revrsing the halves of array
# Time - O(N)
# Space - O(1)
def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        if not nums or len(nums) == 0:
            return 
        
        n = len(nums)
        
        if k >= n:
            k = k % n
            
        self.reverse(nums, 0, n-1)
        self.reverse(nums, 0, k-1)
        self.reverse(nums, k, n-1)
        
        return nums
        
        
    def reverse(self, nums, l, r):
        
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l += 1
            r -= 1
            
        
        
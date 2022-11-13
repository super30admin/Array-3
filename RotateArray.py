class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # Brute force approach
        
        k = k % len(nums)
        
        for i in range(k):
            last = nums[-1]
            for j in range(len(nums)):
                nums[j], last = last, nums[j]
                
        # Time complexity: O(n ^2)
        # Space complexity: O(1) because doing inplace

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # Time efficient approach
        
        k = k % len(nums)
        
        def reverse(nums, left, right):
            
            while left <= right:
                temp = nums[left]
                nums[left] = nums[right]
                nums[right] = temp
                
                left += 1
                right -= 1
            return nums
        
        n = len(nums)
        
        nums = reverse(nums, 0, n-1)
        nums = reverse(nums, 0, k - 1)
        nums = reverse(nums, k, n - 1)
        
        return nums
    
    # Time Complexity: O(N), actually is is 3 N but 3 is constant so O(N)
    # Space Complexity: O(1) because we are doing in place
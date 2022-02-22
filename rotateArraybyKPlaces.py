#O(n) time and O(n) space solution
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #null case
        if nums == None or len(nums) == 0:
            return None
        n = len(nums)
        if k > n:
            k = k % n
        
        #Step 1. Reverse the whole array
        self.reverse(nums, 0, n - 1)
        
        #Step 2. Reverse from 0 to k - 1
        self.reverse(nums, 0, k - 1)
        
        #Step 3. Reverse from k to n - 1
        self.reverse(nums, k, n - 1)
        
    def reverse(self, nums, left, right):
        while(left < right):
            nums[left], nums[right] = nums[right], nums[left]
            left += 1
            right -= 1
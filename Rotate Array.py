class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        #where, n is the length of nums
        
        temp = nums.copy()
        for i in range(len(nums)):
            idx = (i - k) % len(nums)
            nums[i] = temp[idx]
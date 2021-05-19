class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if not nums:
            return 
        n = len(nums)
        k = k % n
        nums.reverse()
        #print(nums)
        nums[0:k] = nums[0:k][::-1]
        #print(nums)
        
        nums[k:n] = nums[k:n][::-1]
        #print(nums)
        

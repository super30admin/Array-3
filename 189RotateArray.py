
# Time complexity  - O(N)
# Space complexity - O(N)
# Ran on Leetcode - Yes

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        list_k = [k]
        
        if k > len(nums):
            list_k = [len(nums),k - len(nums)]
        
        for k in list_k:
            output = []

            output.extend(nums[-k:])
            output.extend(nums[:-k])

            for i in range(len(nums)):
                nums[i] = output[i]
                

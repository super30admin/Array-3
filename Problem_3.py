# Runs on Leetcode - Bruteforce
    # runtime - O(n^2), space - O(1)
    
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        if not nums:
            return []
        
        length = len(nums)
        for i in range(k):
            temp = nums.pop()
            nums.insert(0,temp)

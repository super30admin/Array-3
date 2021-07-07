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

# Runs on Leetcode - Optimized
# Runtime is O(n) and space is O(1)
            
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        size = len(nums)
        if k > size:
            k = k % size 
        nums[:] = nums[:][::-1]
        nums[:k] = nums[:k][::-1]
        nums[k:] = nums[k:][::-1]

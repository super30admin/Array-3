# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Approach:
#Brute Force with stack: Push last k elements on a stack, shift the rest elements to the right and then pop from stack and push them in front. TC: O(k+n), SC: O(k)
#Optimal with intuition:
#1. reverse whole array [7,6,5:4,3,2,1,0]
#2. reverse both partitions (n-k:k) [7,6,5:4,3,2,1,0]-> [5,6,7:0,1,2,3,4]

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = k%len(nums)
        
        if k==0:
            return
        
        self.reversed(nums, 0, len(nums)-1)
        self.reversed(nums, 0, k-1)
        self.reversed(nums, k, len(nums)-1)
        
        
        
    def reversed(self,nums, left, right):
        while left<right:
            temp = nums[left]
            nums[left] = nums[right]
            nums[right]= temp
            
            left+=1
            right-=1
            
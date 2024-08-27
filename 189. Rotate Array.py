#######189. Rotate Array######################################################################################
// Time Complexity : O(n)
// Space Complexity : O(1) -> no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
Here we achieved the result but reversing the array first and than again doing 2 reversal 1 for start to k and another from k to end

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        if len(nums)<2:
            return
        """
        Do not return anything, modify nums in-place instead.
        """
        k=mod(k,len(nums))
        #print(len(nums),k)
        self.rev(nums,0,len(nums)-1)
        self.rev(nums,0,k-1)
        self.rev(nums,k,len(nums)-1)

    def rev(self,nums,start,end):
        while start<=end:
            nums[start],nums[end]=nums[end],nums[start]
            start+=1
            end-=1
        

        
        

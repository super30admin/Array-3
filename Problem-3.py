# Time Complexity :O(n)
# Space Complexity :O(1) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : k bigger then length don't forget
class Solution(object):
    # create function reverse
    def reverse(self,arr,start,end):
        while start < end:
            temp = arr[start]
            arr[start] = arr[end]
            arr[end] = temp
            start +=1
            end -=1
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        # if array is one element or less don't do anything
        if len(nums) <=1:
            return
        # check if rotations more than array size
        K = k%len(nums)
        # reverse all array
        self.reverse(nums,0,len(nums)-1)
        #reverse the first k elements
        self.reverse(nums,0,K-1)
        # reverse the rest of the array
        self.reverse(nums,K,len(nums)-1)
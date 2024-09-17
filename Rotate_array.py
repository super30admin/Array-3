// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
In this we reverse the whole array and then we reverse the first k elements in the reversed array and then we reverse the other n-k elements in the reversed array.

# Time complexity --> o(n)
# space complexity --> o(1)
class Solution(object):
    def reverse(self,str1,start,end):
        while start<end:
            str1[start],str1[end]=str1[end],str1[start]
            start=start+1
            end=end-1
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        n=len(nums)
        k=k%n
        self.reverse(nums,0,n-1)
        self.reverse(nums,0,k-1)
        self.reverse(nums,k,n-1)
        
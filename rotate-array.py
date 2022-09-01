"""
Runtime Complexity: O(n) - where 'n' is the number of elements in the list.
The approach is to reverse the half left to the k and similar with right half. Once this is done we reverse the whole list to get the resultant list.
Space Complexity: O(1) - no extra space was used to compute the solution. 
Yes, the code worked on leetcode.
Issues while coding- No
"""

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        n = len(nums)
        k = k % n
        self.reverse(nums,0,n-k-1)
        self.reverse(nums,n-k,n-1)
        self.reverse(nums,0,n-1)
    
    def reverse(self,nums,left,right):
        while left<=right:
            self.swap(nums,left,right)
            left+=1
            right-=1
    def swap(self,nums,left,right):
        temp = nums[left]
        nums[left] = nums[right]
        nums[right] = temp
        
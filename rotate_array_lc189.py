"""
Time Complexity: O(n)
Space Complexity: O(1)
Did it run on LC: Yes
Logic - 3 reversals - first reversal will reverse the entire array\
      - second reversal on the first k elements, since, that is the order
      - third reversal from elements k+1 to end
""" 
class Solution:
    def reverse(self,arr,start,end):
        
        while start < end:
            arr[start],arr[end] = arr[end],arr[start]
            start,end = start+1, end-1
    
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        
        #if k > n, k-n rotations need not take place
        k = k%n
        
        self.reverse(nums,0,n-1)
        self.reverse(nums,0,k-1)
        self.reverse(nums,k,n-1)
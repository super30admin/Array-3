# Time Complexity : O(N) for each operation.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to use a reverse method to swap till k elements then reverse remaining then reverse whole array.
r
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n=len(nums)
        if k>n:
            k=k%n
        self.reverse(nums, 0,n-k-1)
        self.reverse(nums,n-k,n-1)
        self.reverse(nums, 0,n-1)
        return nums 

    def reverse(self,arr, l, r):
        while(l<r):
            self.swap(arr, l, r)
            l+=1
            r-=1
    
    def swap(self,arr,i,j):
        temp=arr[i]
        arr[i]=arr[j]
        arr[j]=temp
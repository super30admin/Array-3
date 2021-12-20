class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        TC: O(n)
        SC: O(1)
        Do not return anything, modify nums in-place instead.
        
In this approach, we firstly reverse all the elements of the array.
Then, reversing the first k elements followed by reversing
the rest n-kn−k elements gives us the required result.

Let n = 7 n=7 and k = 3k=3.

Original List                   : 1 2 3 4 5 6 7
After reversing all numbers     : 7 6 5 4 3 2 1
After reversing first k numbers : 5 6 7 4 3 2 1
After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
        """
        n=len(nums)
        k%=n
        ####cyclicity because after all 7 get reversed and k =8, it is as if k=1 and it can be assumed it can be reversed just one time
        
        self.reverse(nums,0, n-1)##all
        self.reverse(nums,0, k-1)##first k remeber to do this
        self.reverse(nums,k, n-1)

    def reverse(self, nums, start, end):
        while start<end:
            nums[start], nums[end]=nums[end], nums[start]
            start+=1
            end-=1
        
    
        
    
    
    
        
        
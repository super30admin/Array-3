"""
approach 1 - Remove the last element and attach it to the first index, and move all others to the right - repeat this k times
TC = O(nk)

approach 2 - 
Reverse the whole array in place, reverse first k elements and rest of the elements, reverse the rest of the elements in place

approach 3 - 
Reverse first n-k elements, then reverse k elements, then reverse the whole array

How to left rotate using reversing approach?
Reverse first k elements, then n-k, then the whole array which is formed after 2 reversals

OR 
Reverse the whole array, then first n-k elements, then k elements

TC = O(n)
SC = O(n)

"""

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # if len(nums)==1:
        #     return nums
        
        k = k%len(nums)
        def reverse(l,h):
            while l<h:
                swap(l,h, nums)
                l+=1
                h-=1
                
        def swap(a,b,nums):
            temp = nums[a]
            nums[a]= nums[b]
            nums[b]= temp
            
            return nums
        n =len(nums)-1
        reverse(0, n)
        reverse(0, k-1)
        reverse(k, n)
        
        return nums
        